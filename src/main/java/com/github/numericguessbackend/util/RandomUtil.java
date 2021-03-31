package com.github.numericguessbackend.util;

import java.util.Random;

/**
 * Utility methods for random number generation
 */
public class RandomUtil {

    private static final int MIN = 1;

    private static final int MAX = 100;

    /**
     * Private constructor
     */
    private RandomUtil() {
    }

    /**
     * Generate a random integer between MIN and MAX
     *
     * @return random integer
     */
    public static Integer getRandom() {
        Random rn = new Random();
        return rn.nextInt(MAX - MIN + 1) + MIN;
    }
}
