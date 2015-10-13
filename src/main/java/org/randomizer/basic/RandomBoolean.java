package org.randomizer.basic;


public class RandomBoolean {

	public static boolean nextBoolean () throws ArithmeticException{
		return RandomNumber.nextInteger(2) != 0;
	}

	public static boolean nextBoolean (int truePercentage) throws ArithmeticException {
		return (RandomNumber.nextInteger(100)) + 1 <= truePercentage;
	}
}
