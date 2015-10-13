package org.randomizer.basic;

import java.util.Random;

public class RandomNumber {
    
    private static Random random = new Random();


    /**
     * Uses {@code java.util.Random} in order to generate a random {@code int} value between -(2<font size="-1">
     * <sup>31</sup></font>) (inclusive) and 2<font size="-1"><sup>31</sup></font> (exclusive). Values are
     * produced with (approximately) equal probability.
     *
     * @return          pseudorandom, uniformly distributed {@code int} value
     */
    public static int nextInteger(){
        return random.nextInt();
    }


    /**
     * Uses {@code java.util.Random} in order to generate a random {@code long} value. Values are produced with 
     * (approximately) equal probability.
     *
     * @return          pseudorandom, uniformly distributed {@code long} value
     */
    public static long nextLong(){
        return random.nextLong();
    }


    /**
     * Uses {@code java.util.Random} in order to generate a random {@code double} value between {@code 0.0} 
     * (inclusive) and {@code 1.0} (exclusive). Values are produced with (approximately) equal probability.
     *
     * @return          pseudorandom, uniformly distributed {@code double} value
     */
    public static double nextDouble(){
        return random.nextDouble();
    }
    

    /**
     * Uses {@code java.util.Random} in order to generate a random {@code int} value between 0 (inclusive) and 
     * {@code max} value (exclusive). Values are produced with (approximately) equal probability.
     *
     * @param max       max value of the random number to be returned (Exclusive). Must be positive.
     * @return          pseudorandom, uniformly distributed {@code int} value between {@code 0} (inclusive) and
     *                  {@code max} (exclusive)
     */
    public static int nextInteger(int max) throws ArithmeticException{
        if (max <= 0) {throw new ArithmeticException("Maximum value must be a positive integer");}
        return random.nextInt(max);
    }
    

    /**
     * Uses {@code nextInteger} in order to generate a random {@code int} value between 0 (inclusive) and 
     * {@code max} value (exclusive). And then uses {@code java.util.Random} to generate a random {@code double} 
     * value between 0.0 (inclusive) and {@code 1.0} value (exclusive) which is added to the previously generated 
     * integer, giving as a result a random {@code double} value between 0 (inclusive) and {@code max} value 
     * (exclusive). Values are produced with (approximately) equal probability.
     *
     * @param max       max value of the random number to be returned (Exclusive). Must be positive.
     * @return          pseudorandom, uniformly distributed {@code double} value between {@code 0} (inclusive) and
     *                  {@code max} (exclusive)
     */
    public static double nextDouble(int max) throws ArithmeticException{
        return nextInteger(max) + nextDouble();
    }
    

    /**
     * Uses {@code java.util.Random} in order to generate a random {@code int} value between {@code min} (Inclusive) 
     * and {@code max} (Exclusive) values. In order to get those limits the a random value between 0 and the 
     * difference between minimum a maximum values is calculated and then added to the minimum value. As it uses 
     * {@code nextInt} method values are produced with (approximately) equal probability. Besides minimum value 
     * cannot be greater than maximum value, as the difference between both numbers must be positive and the 
     * difference cannot be greater than {@code Integer.MAX_VALUE} as it may result in an Integer overflow.
     *
     * @param max       max value of the random number to be returned (Exclusive).
     * @param min       min value of the random number to be returned (Exclusive).
     * @return          pseudorandom, uniformly distributed {@code int} value between {@code min} (inclusive) and
     *                  {@code max} (exclusive)
     */
    public static int nextInteger (int min, int max) throws ArithmeticException{
        long difference = (long) max - (long) min;
        if (difference <= 0){
            throw new ArithmeticException("Maximum value must be greater than minimum value");
        }
        if (difference > Integer.MAX_VALUE){
            throw new ArithmeticException("Difference between minimum value and maximum value " +
                    "exceeds the maximum allowed value for an integer.");
        }
        return min + random.nextInt((int) difference);
    }
    

    /**
     * Uses {@code nextInteger} in order to generate a random {@code int} value between {@code min} (Inclusive) and 
     * {@code max} value (Exclusive). And then uses {@code java.util.Random} to generate a random {@code double} 
     * value between 0.0 (Inclusive) and {@code 1.0} value (Exclusive) which is added to the previously generated 
     * integer, giving as a result a random {@code double} value between 0 (Inclusive) and {@code max} value 
     * (Exclusive). Values are produced with (approximately) equal probability. Besides minimum value cannot be 
     * greater than maximum value, as the difference between both numbers must be positive and the difference 
     * cannot be greater than {@code Integer.MAX_VALUE} as it may result in an Integer overflow.
     *
     * @param max       max value of the random number to be returned (Exclusive). Must be positive.
     * @return          pseudorandom, uniformly distributed {@code double} value between {@code 0} (inclusive) and
     *                  {@code max} (exclusive)
     */
    public static double nextDouble (int min, int max) throws ArithmeticException{
        return nextInteger(min, max) + nextDouble();
    }
    

    /**
     * Uses {@code java.util.Random} in order to generate a random {@code int} value between {@code 0} (Inclusive) 
     * and {@code Integer.MAX_VALUE} value (Exclusive). Values are produced with (approximately) equal probability.
     *
     * @return          pseudorandom, uniformly distributed {@code int} value between {@code 0} (inclusive) and
     *                  {@code Integer.MAX_VALUE} value (exclusive)
     */
    public static int nextPositiveInteger(){
        return random.nextInt(Integer.MAX_VALUE);
    }
    

    /**
     * Uses {@code java.util.Random} in order to generate a random {@code int} value between {@code 0} (Inclusive) 
     * and {@code Integer.MAX_VALUE} value (Exclusive). Then uses {@code java.util.Random} to generate a random 
     * {@code double} value between 0.0 (Inclusive) and {@code 1.0} value (Exclusive) which is added to the 
     * previously generated integer, giving as a result a random {@code double} value between {@code 0} (Inclusive) 
     * and {@code Integer.MAX_VALUE} value (Exclusive). Values are produced with (approximately) equal probability.
     *
     * @return          pseudorandom, uniformly distributed {@code int} value between {@code 0} (inclusive) and
     *                  {@code Integer.MAX_VALUE} value (exclusive)
     */
    public static double nextPositiveDouble(){
        return nextPositiveInteger() + nextDouble();
    }
    

    /**
     * Uses {@code java.util.Random} in order to generate a random {@code int} value between 
     * {@code Integer.MIN_VALUE} (Inclusive) and {@code 0} value (Exclusive). Values are produced with 
     * (approximately) equal probability.
     *
     * @return          pseudorandom, uniformly distributed {@code int} value between {@code Integer.MIN_VALUE}
     *                  (inclusive) and {@code 0} value (exclusive)
     */
    public static int nextNegativeInteger(){
        return Integer.MIN_VALUE + random.nextInt(Integer.MAX_VALUE);
    }
    

    /**
     * Uses {@code java.util.Random} in order to generate a random {@code int} value between 
     * {@code Integer.MIN_VALUE} (Inclusive) and {@code 0} value (Exclusive). Then uses {@code java.util.Random} 
     * to generate a random {@code double} value between 0.0 (Inclusive) and {@code 1.0} value (Exclusive) which 
     * is added to the previously generated integer, giving as a result a random {@code double} value between 
     * {@code Integer.MIN_VALUE} (Inclusive) and {@code 0} value (Exclusive). Values are produced with 
     * (approximately) equal probability.
     *
     * @return          pseudorandom, uniformly distributed {@code int} value between {@code 0} (inclusive) and
     *                  {@code Integer.MAX_VALUE} value (exclusive)
     */
    public static double nextNegativeDouble(){
        return nextNegativeInteger() + nextDouble();
    }
    
    
    /**
     * Uses {@code java.util.Random} in order to generate a random Gaussian ("normally") distributed {@code double} 
     * value with mean {@code mean} and standard deviation {@code variance}.
     * 
     * @param mean          central tendency of the gaussian distribution
     * @param variance      measure of how far the generated numbers are spread out from the mean value. 
     *                      It must be a non-negative number.
     * @return              pseudorandom, Gaussian ("normally") distributed {@code double} value with mean
     *                      {@code mean} and standard deviation {@code variance}
     * @throws ArithmeticException
     */
    public static double nextGaussianDouble (int mean, int variance) throws ArithmeticException {
        if (variance < 0){throw new ArithmeticException("Variance must be non-negative.");}
        return mean + variance * random.nextGaussian();
    }
    
    
    /**
     * Uses {@code nextGaussianDouble} in order to generate a random Gaussian ("normally") distributed {@code int} 
     * value with mean {@code mean} and standard deviation {@code variance}. It checks if the generated number is 
     * a valid {@code int} before returning it.
     * 
     * @param mean          central tendency of the gaussian distribution
     * @param variance      measure of how far the generated numbers are spread out from the mean value. It must 
     *                      be a non-negative number.
     * @return              pseudorandom, Gaussian ("normally") distributed {@code int} value with mean {@code mean}
     *                      and standard deviation {@code variance}
     * @throws ArithmeticException
     */
    public static int nextGaussianInteger (int mean, int variance) throws ArithmeticException{
        return checkIntegerRange(Math.round(nextGaussianDouble(mean, variance)));
    }
    

    /**
     * Uses {@code nextGaussianDouble} in order to generate a random Gaussian ("normally") distributed {@code double} 
     * value with mean {@code mean} and standard deviation {@code variance}. Once the number has been calculated it 
     * checks if it is located inside the given limits, generating a new one otherwise. Due to this recalculating 
     * method, it is not allowed to request limits that don't include the mean value and that makes the valid window 
     * narrower than variance. That way it is guaranteed that at least 35% of the generated numbers will fall inside 
     * the requested interval and, thus, each point will be recalculated an average of twice at most.
     * 
     * @param mean          central tendency of the gaussian distribution
     * @param variance      measure of how far the generated numbers are spread out from the mean value. It must 
     *                      be a non-negative number.
     * @param lowerLimit    minimum value to be calculated. Must be lower than mean value and upper limit.
     * @param upperLimit    maximum value to be calculated. Must be greater than mean value and lower limit.
     * @return              pseudorandom, Gaussian ("normally") distributed {@code double} value with mean
     *                      {@code mean} and standard deviation {@code variance} that is included in the range of 
     *                      values between {@code lowerLimit} and {@code upperLimit}
     * @throws ArithmeticException
     */
    public static double nextGaussianDouble (int mean, int variance, double lowerLimit, double upperLimit)
            throws ArithmeticException{
        if (upperLimit <= lowerLimit){
            throw new ArithmeticException("Upper limit should be bigger than lower limit");
        }
        if (mean < lowerLimit || mean > upperLimit){
            throw new ArithmeticException("Mean value should be inside the limits");
        }
        if (variance > (upperLimit - lowerLimit)){
            throw new ArithmeticException("Variance should be smaller than the limits distance");
        }
        
        double value;
        while (true){
            value = nextGaussianDouble(mean, variance);
            if (value >= lowerLimit && value <= upperLimit){return value;}
        }
    }
    

    /**
     * Uses {@code nextGaussianDouble} in order to generate a random Gaussian ("normally") distributed {@code int} 
     * value with mean {@code mean} and standard deviation {@code variance}. Once the number has been calculated it 
     * checks if it is located inside the given limits, generating a new one otherwise. Due to this recalculating 
     * method, it is not allowed to request limits that don't include the mean value and that makes the valid window 
     * narrower than variance. That way it is guaranteed that at least 35% of the generated numbers will fall inside 
     * the requested interval and, thus, each point will be recalculated an average of twice at most. It checks if 
     * the generated number is a valid {@code int} before returning it.
     * 
     * @param mean          central tendency of the gaussian distribution
     * @param variance      measure of how far the generated numbers are spread out from the mean value. It must be a
     *                                       non-negative number.
     * @param lowerLimit    minimum value to be calculated. Must be lower than mean value and upper limit.
     * @param upperLimit    maximum value to be calculated. Must be greater than mean value and lower limit.
     * @return              pseudorandom, Gaussian ("normally") distributed {@code int} value with mean {@code mean}
     *                      and standard deviation {@code variance} that is included in the range of values between
     *                      {@code lowerLimit} and {@code upperLimit}
     * @throws ArithmeticException
     */
    public static int nextGaussianInteger (int mean, int variance, int lowerLimit, int upperLimit) 
            throws ArithmeticException{
        return checkIntegerRange(Math.round(nextGaussianDouble(mean, variance, lowerLimit, upperLimit)));
    }
    

    /**
     * Uses {@code nextGaussianDouble} in order to generate a random Gaussian ("normally") distributed {@code double} 
     * value with mean {@code mean} located inside the given limits, generating a new one otherwise. Due to this 
     * recalculating method, it is not allowed to request limits that don't include the mean value. The variance is 
     * calculated as the third part of the maximum distance between mean and one of the limits. This way it is 
     * guaranteed that at least 44,5% of the values fall inside the requested window, limiting that way the number 
     * of recalculations.
     * 
     * @param mean          central tendency of the gaussian distribution
     * @param lowerLimit    minimum value to be calculated. Must be lower than mean value and upper limit.
     * @param upperLimit    maximum value to be calculated. Must be greater than mean value and lower limit.
     * @return              pseudorandom, Gaussian ("normally") distributed {@code double} value with mean
     *                      {@code mean} that is included in the range of values between {@code lowerLimit} 
     *                      and {@code upperLimit}
     * @throws ArithmeticException
     */
    public static double nextGaussianDouble (int mean, double lowerLimit, double upperLimit)
            throws ArithmeticException{
        int maxVariance = (int) Math.max(mean - lowerLimit, upperLimit - mean) / 3;
        return nextGaussianDouble(mean, maxVariance, lowerLimit, upperLimit);
    }
    

    /**
     * Uses {@code nextGaussianDouble} in order to generate a random Gaussian ("normally") distributed {@code int} 
     * value with mean {@code mean} located inside the given limits, generating a new one otherwise. Due to this 
     * recalculating method, it is not allowed to request limits that don't include the mean value. The variance is 
     * calculated as the third part of the maximum distance between mean and one of the limits. This way it is 
     * guaranteed that at least 44,5% of the values fall inside the requested window, limiting that way the number 
     * of recalculations. It checks if the generated number is a valid {@code int} before returning it.
     * 
     * @param mean          central tendency of the gaussian distribution
     * @param lowerLimit    minimum value to be calculated. Must be lower than mean value and upper limit.
     * @param upperLimit    maximum value to be calculated. Must be greater than mean value and lower limit.
     * @return              pseudorandom, Gaussian ("normally") distributed {@code int} value with mean {@code mean}
     *                      that is included in the range of values between {@code lowerLimit} and {@code upperLimit}
     * @throws ArithmeticException
     */
    public static int nextGaussianInteger (int mean, int lowerLimit, int upperLimit)
            throws ArithmeticException{
        return checkIntegerRange(Math.round(nextGaussianDouble(mean, lowerLimit, upperLimit)));
    }
    
    
    /**
     * Checks whether the given value is a valid {@code int} value by checking integer limit boundaries
     * 
     * @param value         number to be checked
     * @return              {@code int} value of the given number if it is a valid integer
     */
    private static int checkIntegerRange(long value) {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE){
            throw new ArithmeticException("Overflow while casting value into an Integer.");
        }
        return (int) value;
    }
}
