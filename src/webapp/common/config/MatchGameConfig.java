package webapp.common.config;

import webapp.common.utils.Level;

import java.util.Random;

public final class MatchGameConfig {
    private static Level level;
    private static int matches = 10;

    public MatchGameConfig() { }

    public static void setMatchGameConfig(final String levelMode) {
        initConfig(levelMode);
    }

    @Override
    public String toString() {
        return "MatchGameConfig[" +
                "level=" + level.toString() + ',' +
                "matches=" + matches + ']';
    }
    /**
     * This method is used for choosing a range of matches during the game. The number depends on the level mode.
     * @param min min matches number value during the game depending on the level mode.
     * @param max max matches number value during the game depending on the level mode.
     * @return random matches number value during the game depending on the level mode.
     */
    private static int getRandomNumberInRange(final int min, final int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        return new Random().nextInt((max - min) + 1) + min;
    }

    /**
     * This method is used for choosing a range of matches during the game. The number depends on the level mode.
     * @param min min matches number value during the game depending on the level mode.
     * @param max max matches number value during the game depending on the level mode.
     */
    private static void initNumberOfMatches(final int min, final int max) {
        try {
            matches = getRandomNumberInRange(min, max);
        } catch(final IllegalArgumentException ex) {
            // fixed by default
            matches = 10;
        }
    }

    /**
     * This method is used for choosing a range of matches during the game. The number depends on the level mode.
     * @param newLevel
     */
    private static void initConfig(final String newLevel) {
        if (newLevel.equalsIgnoreCase(Level.MEDIUM.toString())) {
            level = Level.MEDIUM;
            initNumberOfMatches(15, 25);
        } else if (newLevel.equalsIgnoreCase(Level.EXPERT.toString())) {
            level = Level.EXPERT;
            initNumberOfMatches(25, 30);
        } else {
            // level by default
            level = Level.NOOBIE;
            matches = 10;
        }
    }

    /* Getters & Setters */
    public static String getLevel() {
        return level.toString();
    }

    public static void setLevel(final Level newLevel) {
        level = newLevel;
    }

    public static int getMatches() {
        return matches;
    }

    public static void setMatches(final int value) {
        matches = value;
    }
}
