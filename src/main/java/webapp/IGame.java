package webapp;

/**
 * This interface exposes main methods used by a turn game.
 * Author : Mathieu Le Veve
 * Date : 10/10/2019
 */
public interface IGame {

    /**
     * Detects if the Game is over
     * @param value int total matches
     * @return boolean True if the Game is over, False otherwise
     */
    boolean isEndGame(final int value);

    /**
     * PickUp 1, 2 or 3 matches
     * @param value int
     * @return int 1, 2 or 3 matches removed
     */
    int pickUp(final int value);

    /**
     * Apply the player turn
     * @param value int value current option
     */
    void playUserTurn(final int value);

    /**
     * Setup the player turn
     */
    void changeTurn();

    /**
     * Apply the IA player turn
     * @return int Value of the option chooser by the IA player between 1 and 3 inclusive
     */
    int playIATurn();

    /**
     * Detects whom is the winner
     * @return boolean True if the current Player is the winner
     */
    boolean isWinner();
}
