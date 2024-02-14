package it.unibo.objectmon.model.gamestate;

/**
 * An enumeration of possible game states.
 */
public enum GameState {

    /**
     * Exploration mode.
     */

    EXPLORATION,

    /**
     * Battle mode.
     */
    BATTLE,

    /**
     * Pause mode.
     */
    PAUSE,
    /**
     * When player wins.
     */
    WIN,
    /**
     * When player loses.
     */
    LOSS,

    /**
     * The default mode.
     */
    NONE
}
