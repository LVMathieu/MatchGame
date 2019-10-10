package webapp.models.player;


import webapp.common.utils.NumberUtils;

public class NoobiePlayer extends Player {
    @Override
    public int playTurn(final int currentMatches) {
        try {
            return NumberUtils.getRandomNumberInRange(1, 3);
        } catch (final IllegalArgumentException ex) {
            return 1;
        }
    }
}
