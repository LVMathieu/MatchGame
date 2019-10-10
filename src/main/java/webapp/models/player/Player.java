package webapp.models.player;

/**
 * This class is abstract. We will override playTurn methods depending on the level mode selected.
 * Author : Mathieu Le Veve
 * Date : 10/10/2019
 */
public abstract class Player {
    public abstract int playTurn(final int currentMatches);
}
