package it.unibo.objectmon.model.battle.turn;

/**
 * stat turn of.
 */
public enum StatTurn {
    /**
     * waiting player choose a move.
     */
    IS_WAITING_MOVE,
    /**
     * AI (trainer or Objectmon) can start to execute his move.
     */
    AI_TURN,
    /**
     * player can start execute his move.
     */
    PLAYER_TURN,
    /**
     * when player and AI execute their moves.
     */
    TURN_COMPLETE
}

