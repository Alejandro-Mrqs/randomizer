package org.randomizer.basic;

import org.junit.Assert;
import org.junit.Test;

public class RandomIntegerTest {

	@Test
	public void testRandomInteger() {
		int result = RandomNumber.nextInteger();
		Assert.assertTrue(result >= Integer.MIN_VALUE && result < Integer.MAX_VALUE);
	}

	@Test
	public void testRandomIntegerWithUpperLimit() throws Exception {
		int limit = 10;

		int result = RandomNumber.nextInteger(limit);
		Assert.assertTrue(result >= 0 && result < limit);
	}

	@Test
	public void testRandomIntegerWithLimits() throws Exception {
		int min = -10;
		int max = 10;
		
		int result = RandomNumber.nextInteger(min, max);
		Assert.assertTrue(result >= min && result < max);
	}

	@Test (expected= Exception.class)
	public void testRandomIntegerWithLimits_NegativeDifference() throws Exception {
		RandomNumber.nextInteger(10, 0);
	}

	@Test (expected= Exception.class)
	public void testRandomIntegerWithLimits_TooBigDifference() throws Exception {
		RandomNumber.nextInteger(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	@Test (expected= Exception.class)
	public void testRandomIntegerWithLimits_TooBigAndNegativeDifference() throws Exception {
		RandomNumber.nextInteger(Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	@Test
	public void testRandomPositiveInteger() {
		int result = RandomNumber.nextPositiveInteger();
		Assert.assertTrue(result >= 0 && result < Integer.MAX_VALUE);
	}

	@Test
	public void testRandomNegativeInteger() {
		int result = RandomNumber.nextNegativeInteger();
		Assert.assertTrue(result >= Integer.MIN_VALUE && result < 0);
	}

}