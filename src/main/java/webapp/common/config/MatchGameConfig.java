package webapp.common.config;

import webapp.common.utils.Level;
import webapp.common.utils.NumberUtils;
import webapp.models.player.TrickyPlayer;
import webapp.models.player.NoobiePlayer;
import webapp.models.player.Player;


/**
 * This class is a final class. It aims to init all game configurations.
 */
public final class MatchGameConfig {
    private static int      matches     = 10;
    private static boolean  isPlaying   = true;
    private static boolean  isUserhasWon;
    private static boolean  isIAhasWon;
    private static String   user;
    private static Level    level;
    private static Player   player;

    public MatchGameConfig() { }

    public static void setMatchGameConfig(final String levelMode, final String username) {
        initUserPlayer(username);
        initGameState();
        initConfig(levelMode);
    }

    /**
     * This method is used for choosing a range of matches during the game. The number depends on the level mode.
     * @param min min matches number value during the game depending on the level mode.
     * @param max max matches number value during the game depending on the level mode.
     */
    private static void initNumberOfMatches(final int min, final int max) {
        try {
            matches = NumberUtils.getRandomNumberInRange(min, max);
        } catch(final IllegalArgumentException ex) {
            // fixed by default
            matches = 10;
        }
    }

    /**
     * This method initialises the username.
     * @param username String username.
     */
    private static void initUserPlayer(final String username) {
        user = username;
    }

    /**
     * This method reset to false state for starting the game.
     */
    private static void initGameState() {
        isUserhasWon = isIAhasWon = false;
    }

    /**
     * This method is used for choosing a range of matches during the game. The number depends on the level mode.
     * @param newLevel String level Mode selected by the player
     *                 Case 1: Noobie is a low level: Random choice between 1 and 3
     *                 Case 2: Medium is a middle level: Uses tactics by 4-peer
     *                 Case 3: Expert is a highest level: Same than Medium but you are starting with 24 matches (impossible to win)
     */
    private static void initConfig(final String newLevel) {
        if (newLevel.equalsIgnoreCase(Level.MEDIUM.toString())) {
            level = Level.MEDIUM;
            player = new TrickyPlayer();
            initNumberOfMatches(15, 25);
        } else if (newLevel.equalsIgnoreCase(Level.EXPERT.toString())) {
            level = Level.EXPERT;
            player = new TrickyPlayer();
            matches = 24;
        } else {
            // level by default
            level = Level.NOOBIE;
            player = new NoobiePlayer();
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

    public static Player getPlayer() {
        return player;
    }


    public static boolean getIsPlaying() {
        return isPlaying;
    }

    public static void setIsPlaying() {
        isPlaying = !isPlaying;
    }

    public static String getUsername() {
        return user;
    }

    public static boolean getIsUserHasWon() {
        return isUserhasWon;
    }

    public static void setIsUserHasWon() {
        isUserhasWon = !isUserhasWon;
    }

    public static boolean getIsIAHasWon() {
        return isIAhasWon;
    }

    public static void setIsIAHasWon() {
        isIAhasWon = !isIAhasWon;
    }

}
