package org.randomizer.basic;

import java.util.Random;

public class RandomString {
	
	private static Random random = new Random();
	
	public static String getDigit(){
		return Integer.toString(random.nextInt(10));
	}
	
	public static String getDigits(int length){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			builder.append(getDigit());
			
		}
		return builder.toString();
	}
}