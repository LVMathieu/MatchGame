package webapp;

import webapp.common.config.MatchGameConfig;

public class MatchGame {
    private static MatchGameConfig game = new MatchGameConfig();

    public MatchGame() {

    }

    public static void setMatchGame(final String levelMode) {
        MatchGameConfig.setMatchGameConfig(levelMode);
    }

    public static void pickUp(final int value) {
        MatchGameConfig.setMatches(MatchGameConfig.getMatches() - value);
    }

    /**
     *
     * True if this is the end. Otherwise false
     **/
    public static boolean isEndGame(final int value) {
        return MatchGameConfig.getMatches() < 1;
    }


    public static MatchGameConfig getMatchGameConfig() {
        return game;
    }

    @Override
    public String toString() {
        return "MatchGame[" + game + ']';
    }
}
