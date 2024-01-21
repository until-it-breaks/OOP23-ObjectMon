package it.unibo.objectmon.model.battle.api;

/**
 * MoveFactory is a factory which produces all possible moves in the battle.
 */
public interface RunAway {
    /**
     * a move which player can leave the battle.
     * @return if the player has successed leaving the battle
     */
    boolean runAway();
}
