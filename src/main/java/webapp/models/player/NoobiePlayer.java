package webapp.models.player;


import webapp.common.utils.NumberUtils;

/**
 * This class is extended from Player. New instance of Dummy Player
 * Author : Mathieu Le Veve
 * Date : 10/10/2019
 */
public class NoobiePlayer extends Player {

    /**
     * Override method for playing the turn in the case of NoobiePlayer
     * @param currentMatches total matches
     * @return int Number of Matches removed
     */
    @Override
    public int playTurn(final int currentMatches) {
        try {
            // Dummy behaviour by choosing between 1 and 3
            return NumberUtils.getRandomNumberInRange(1, 3);
        } catch (final IllegalArgumentException ex) {
            // If we faced an issue, choose 1 by default
            return 1;
        }
    }
}
