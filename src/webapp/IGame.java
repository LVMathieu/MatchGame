package webapp;

import webapp.models.player.Player;

public interface IGame {
    /**
     * This method aims to detect if the game is finished or not
     * @param value int Matches number
     * @return {@code true} if the value is equals to 0 or negative
     **/
    /*public static boolean isEndGame(final int value) {
        return value < 1;
    }

    public static boolean isEndGame(final int totalMatches, final int value) {
        return isEndGame(totalMatches - value);
    }*/
    boolean isEndGame(final int value);
    int pickUp(final int value);
    void playUserTurn(final int value);
    void changeTurn();
    int playIATurn();
    boolean isWinner();
}
