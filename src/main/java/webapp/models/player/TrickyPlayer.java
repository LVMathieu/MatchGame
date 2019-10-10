package webapp.models.player;

import static webapp.common.Constants.*;
import static webapp.common.utils.NumberUtils.computeWithTestValue;

/**
 * This class is extended from Player. New instance of Tricky Player whom is using 4-peer tactic
 * Author : Mathieu Le Veve
 * Date : 10/10/2019
 */
public class TrickyPlayer extends Player {

    /**
     * Override method for playing the turn in the case of TrickyPlayer because he is using 4-peer tactic
     * @param currentMatches total matches
     * @return int Number of Matches removed
     */
    @Override
    public int playTurn(final int currentMatches) {
        int bestChoice;

        // compute the best choice to trick us
        if(evaluate(currentMatches, ONE)) {
            bestChoice = ONE;
        } else if(evaluate(currentMatches, TWO)) {
            bestChoice = TWO;
        } else if (evaluate(currentMatches, THREE)) {
            bestChoice = THREE;
        } else {
            bestChoice = ONE;
        }
        return bestChoice;
    }

    /**
     * 4-peer tactic method. Evaluates the best option.
     * @param totalMatches int total matches
     * @param optionValue int current option to test
     * @return boolean True if is a 4-peer compatibility. False, otherwise.
     */
    private static boolean evaluate(final int totalMatches, final int optionValue) {
        return (computeWithTestValue(totalMatches, optionValue) % FOUR) == ZERO;
    }

}
