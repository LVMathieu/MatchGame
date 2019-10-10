package webapp.models.player;

import static webapp.common.Constants.*;
import static webapp.common.utils.NumberUtils.computeWithTestValue;

public class TrickyPlayer extends Player {
    @Override
    public int playTurn(final int currentMatches) {
        int bestChoice;
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


    private static boolean evaluate(final int totalMatches, final int optionValue) {
        return (computeWithTestValue(totalMatches, optionValue) % FOUR) == ZERO;
    }

}
