package org.randomizer.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class GraphPrinter {
	
	public enum Type {
		NONE,
		INTEGER,
		DOUBLE,
		BOOLEAN,
		DATE
	}
	
	public enum Mode {
		RANDOM_INT (Type.INTEGER),
		RANDOM_POSITIVE_INT (Type.INTEGER),
		RANDOM_NEGATIVE_INT (Type.INTEGER),
		RANDOM_ONE_LIMIT_INT (Type.INTEGER),
		RANDOM_TWO_LIMITS_INT (Type.INTEGER),
		RANDOM_GAUSSIAN_INT (Type.INTEGER),
		RANDOM_GAUSSIAN_TWO_LIMITS_INT (Type.INTEGER),
		RANDOM_GAUSSIAN_JUST_LIMITS_INT (Type.INTEGER),
		RANDOM_GAUSSIAN_TWO_LIMITS_DOUBLE (Type.DOUBLE),
		RANDOM_BOOLEAN (Type.BOOLEAN),
		RANDOM_BOOLEAN_PERCENTAGE (Type.BOOLEAN),
		NONE (Type.NONE);
		
		public Type type;
		
		private Mode (Type type){
			this.type = type;
		}
	}
	
	private static DecimalFormat decimalFormat = new DecimalFormat("#.##");
	private static DecimalFormat integerFormat = new DecimalFormat("#");

	public static void drawDistribution (List<Double> numbers, int intervals, boolean decimalIntervals, Mode mode){
		if (numbers.isEmpty()){
			System.out.println("No points to paint");
			return;
		}
		
		double minKey = numbers.get(0);
		double maxKey = numbers.get(0);
		long maxValue = 1;
		
		switch (mode.type) {
			case BOOLEAN:
				intervals = 2;
				decimalIntervals = false;
			break;
			
			case INTEGER:
				decimalIntervals = false;
			break;
			
			default: break;
		}
		
		Map<Double, Long> distribution = new TreeMap<Double, Long>();
		
		// Aggregates every point and gets the minimum and maximum key values
		for (double number : numbers) {
			if (number > maxKey) {maxKey = number;}
			if (number < minKey) {minKey = number;}
			
			Long previous = distribution.put(number, 1L);
			if (null != previous){
				previous++;
				distribution.put(number, previous);
				if (previous > maxValue) {maxValue = previous;}
			}
		}

		// Calculates the intervals in which the points will be aggregated and painted
		Map<String, Long> intervalDistribution = new LinkedHashMap<String, Long>();
		
		// If no decimal intervals are requested integer values are calculated for the interval window
		if (!decimalIntervals){
			minKey = (int) minKey;
			// If max key has no decimals it is kept otherwise integer part is retrieved and one is added in order to include any decimals
			maxKey = (maxKey == (int) maxKey)? (int) maxKey : ((int) maxKey) + 1;
		}
		
		double window = maxKey - minKey;
		if (window == 0) {window = 1;} 
		double intervalSize = window / intervals;
		
		if (!decimalIntervals){
			if (window % intervals != 0){
				intervalSize = ((int) intervalSize) + 1;
				minKey = (int) (minKey - ((intervals * intervalSize) - window) / 2);
			}
		}

		// Aggregates points inside a given rank
		for (int i = 0; i < intervals; i++) {
			double lowerIntervalValue = minKey + (i * intervalSize);
			double upperIntervalValue = lowerIntervalValue + intervalSize;
			
			long count = 0;
			List<Double> keys = new ArrayList<Double>();
			
			for (Entry<Double, Long> entry : distribution.entrySet()) {
				if (entry.getKey() >= lowerIntervalValue && entry.getKey() < upperIntervalValue || i == (intervals - 1)){
					count = count + entry.getValue();
					keys.add(entry.getKey());
				}
				else{break;}
			}
			for (double key : keys) {distribution.remove(key);}
			
			intervalDistribution.put(getIntervalLegend(lowerIntervalValue, upperIntervalValue, decimalIntervals, mode), count);
			if (count > maxValue){maxValue = count;}
		}
		
		paintDistribution(intervalDistribution, new Double(maxValue));
	}
	
	private static void paintDistribution (Map<String, Long> distribution, Double maxValue){
		for (Entry<String, Long> interval : distribution.entrySet()) {
			System.out.print(interval.getKey() + " ");
			Integer points = (int)(interval.getValue() * 100 / maxValue);
			System.out.print(getCharacters("+", points));
			System.out.print(getCharacters(" ", 100 - points));
			System.out.println(" (" + interval.getValue() + ")");
		}
	}
	
	private static String getIntervalLegend(double lowerIntervalValue, double upperIntervalValue, boolean decimalInterval, Mode mode){
		String legend = "¿?";
		
		switch (mode.type) {
			case BOOLEAN:
				legend = "[" + String.valueOf(lowerIntervalValue == 1) + "]";
			break;
			
			case INTEGER:
				legend = "[" + (int) lowerIntervalValue + " / " + (int) upperIntervalValue + "]";
			break;
			
			case DOUBLE:
				DecimalFormat format = (decimalInterval)? decimalFormat : integerFormat;
				legend = "[" + format.format(lowerIntervalValue) + " / " + format.format(upperIntervalValue) + "]";
			break;
			
			default: break;
		}
		
		if (legend.length() > 20) {legend = legend.substring(0,16) + "...]";}
		else {legend = legend + getCharacters(" ", 20 - legend.length());}
		return legend;
	}
	
	private static String getCharacters (String character, int number){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < number; i++) {
			builder.append(character);
		}
		return builder.toString();
	}
}
