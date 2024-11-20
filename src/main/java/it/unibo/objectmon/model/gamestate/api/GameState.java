package it.unibo.objectmon.model.gamestate.api;

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
     * Trade mode.
     */
    TRADE,

    /**
     * Pause mode.
     */
    PAUSE,

    /**
     * Victory or defeat resolution mode.
     */
    ENDING,

    /**
     * Unused mode.
     */
    NONE,
}
