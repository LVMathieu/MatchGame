package webapp;

import webapp.common.config.MatchGameConfig;

public class MatchGame implements IGame {
    private static MatchGameConfig gameConfig   = new MatchGameConfig();


    public MatchGame() {

    }

    public static void setMatchGame(final String levelMode, final String username) {
        MatchGameConfig.setMatchGameConfig(levelMode, username);
    }


    public static MatchGameConfig getMatchGameConfig() {
        return gameConfig;
    }

    @Override
    public String toString() {
        return "MatchGame[" + gameConfig + ']';
    }

    /**
     * This method aims to detect if the game is finished or not
     * @param value int Matches number
     * @return {@code true} if the value is equals to 0 or negative
     **/
    @Override
    public boolean isEndGame(final int value) {
        return value < 1;
    }

    @Override
    public int pickUp(final int value) {
        final int currentMatchesNumber = MatchGameConfig.getMatches();
        MatchGameConfig.setMatches(currentMatchesNumber - value);
        return MatchGameConfig.getMatches();
    }

    @Override
    public void playUserTurn(final int value) {
        final int updatedMatchesNumber = pickUp(value);
        if (isEndGame(updatedMatchesNumber)) {
            MatchGameConfig.setIsUserHasWon();
        }
        changeTurn();
    }

    @Override
    public void changeTurn() {
        MatchGameConfig.setIsPlaying();
    }

    @Override
    public int playIATurn() {
        final int matchesRemoved = MatchGameConfig.getPlayer().playTurn(MatchGameConfig.getMatches());
        final int updatedMatchesNumber = pickUp(matchesRemoved);
        if (isEndGame(updatedMatchesNumber)) {
            MatchGameConfig.setIsIAHasWon();
        }
        changeTurn();
        return matchesRemoved;
    }

    @Override
    public boolean isWinner() {
        return MatchGameConfig.getIsUserHasWon() || MatchGameConfig.getIsIAHasWon();
    }
}
