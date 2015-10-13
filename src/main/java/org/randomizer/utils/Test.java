package org.randomizer.utils;

import java.util.ArrayList;
import java.util.List;

import org.randomizer.basic.RandomBoolean;
import org.randomizer.basic.RandomNumber;
import org.randomizer.utils.GraphPrinter.Mode;


public class Test {
	
	private static long points = 100000;
	private static int intervals = 40;
	
	private static Mode mode = Mode.RANDOM_GAUSSIAN_JUST_LIMITS_INT;
	private static boolean decimals = true;

	public static void main(String[] args) throws Exception {		
		List<Double> numbers = new ArrayList<Double>();
		
		switch (mode) {
			case RANDOM_INT:
				for (int i = 0; i < points; i++) {numbers.add((double) RandomNumber.nextInteger());}
			break;
			
			case RANDOM_POSITIVE_INT:
				for (int i = 0; i < points; i++) {numbers.add((double) RandomNumber.nextPositiveInteger());}
			break;
			
			case RANDOM_NEGATIVE_INT:
				for (int i = 0; i < points; i++) {numbers.add((double) RandomNumber.nextNegativeInteger());}
			break;
			
			case RANDOM_ONE_LIMIT_INT:
				for (int i = 0; i < points; i++) {numbers.add((double) RandomNumber.nextInteger(10000));}
			break;
			
			case RANDOM_TWO_LIMITS_INT:
				for (int i = 0; i < points; i++) {numbers.add((double) RandomNumber.nextInteger(-500, 500));}
			break;
			
			case RANDOM_GAUSSIAN_INT:
				for (int i = 0; i < points; i++) {numbers.add((double) RandomNumber.nextGaussianInteger(0, 1000));}
			break;
			
			case RANDOM_GAUSSIAN_TWO_LIMITS_INT:
				for (int i = 0; i < points; i++) {numbers.add((double) RandomNumber.nextGaussianInteger(400, 400, 0, 1600));}
			break;
			
			case RANDOM_GAUSSIAN_JUST_LIMITS_INT:
				for (int i = 0; i < points; i++) {numbers.add((double) RandomNumber.nextGaussianInteger(750, 0, 1500));}
			break;
			
			case RANDOM_GAUSSIAN_TWO_LIMITS_DOUBLE:
				for (int i = 0; i < points; i++) {numbers.add(RandomNumber.nextGaussianDouble(100, 400, 0, 1500));}
			break;
			
			case RANDOM_BOOLEAN:
				for (int i = 0; i < points; i++) {numbers.add(RandomBoolean.nextBoolean()? 1d : 0d);}
			break;
			
			case RANDOM_BOOLEAN_PERCENTAGE:
				for (int i = 0; i < points; i++) {numbers.add(RandomBoolean.nextBoolean(20)? 1d : 0d);}
			break;
			
			case NONE:
				System.out.println("EXIT");
			break;
				
			default: System.out.println("Not available!");
			break;
		}
		
		GraphPrinter.drawDistribution(numbers, intervals, decimals, mode);
	}
}
