package webapp.common.utils;

import java.util.Random;

public final class NumberUtils {

    /**
     * This method is used for choosing a range of matches during the game. The number depends on the level mode.
     * @param min min matches number value during the game depending on the level mode.
     * @param max max matches number value during the game depending on the level mode.
     * @return random matches number value during the game depending on the level mode.
     */
    public static int getRandomNumberInRange(final int min, final int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static int computeWithTestValue(final int totalMatches, final int optionValue) {
        return totalMatches - optionValue;
    }
}
