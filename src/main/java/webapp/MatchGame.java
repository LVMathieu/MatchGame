package webapp;

import webapp.common.config.MatchGameConfig;

/**
 * Created by Mathieu Le Veve on 10/10/2019
 * This class aims to manage the game logic.
 * It initialises some configuration and manages the game lifecycle
 * Date : 10/10/2019
 *
 */
public class MatchGame implements IGame {
    private static MatchGameConfig gameConfig   = new MatchGameConfig();


    public MatchGame() {

    }

    /**
     * Init the configuration
     * @param levelMode String level mode
     * @param username String username
     */
    public static void setMatchGame(final String levelMode, final String username) {
        MatchGameConfig.setMatchGameConfig(levelMode, username);
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

    /**
     * PickUp 1, 2 or 3 matches
     * @param value int
     * @return int 1, 2 or 3 matches removed
     */
    @Override
    public int pickUp(final int value) {
        final int currentMatchesNumber = MatchGameConfig.getMatches();
        MatchGameConfig.setMatches(currentMatchesNumber - value);
        return MatchGameConfig.getMatches();
    }

    /**
     * Apply the player turn
     * @param value int value current option
     */
    @Override
    public void playUserTurn(final int value) {
        final int updatedMatchesNumber = pickUp(value);
        if (isEndGame(updatedMatchesNumber)) {
            MatchGameConfig.setIsUserHasWon();
        }
        changeTurn();
    }

    /**
     * Setup the player turn
     */
    @Override
    public void changeTurn() {
        MatchGameConfig.setIsPlaying();
    }

    /**
     * Apply the player turn
     * @return int Value of the option chooser by the IA player between 1 and 3 inclusive
     */
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

    /**
     * Detects whom is the winner
     * @return boolean True if the current Player is the winner
     */
    @Override
    public boolean isWinner() {
        return MatchGameConfig.getIsUserHasWon() || MatchGameConfig.getIsIAHasWon();
    }
}
