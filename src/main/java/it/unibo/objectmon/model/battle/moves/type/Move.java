package it.unibo.objectmon.model.battle.moves.type;

/**
 * Move represents a type of move in the battle.
 */
public enum Move {
    /**
     * type of attack move.
     */
    ATTACK,
    /**
     * type of use ball.
     */
    USE_BALL,
    /**
     * type of use heal.
     */
    USE_HEAL,
    /**
     * type of run away.
     */
    RUN_AWAY,
    /**
     * type of switch objectmon.
     */
    SWITCH_OBJECTMON,
    /**
     * when there is no move.
     */
    NOT_IN_FIGHT
}
