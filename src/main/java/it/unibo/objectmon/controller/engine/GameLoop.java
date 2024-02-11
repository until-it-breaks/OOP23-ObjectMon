package it.unibo.objectmon.controller.engine;

/**
 * A game loop interface responsible for managing the main loop of a game.
 * Implementations of this interface control the flow of the game,
 * including starting and stopping the continuous update and rendering cycle.
 */
public interface GameLoop {

    /**
     * Starts the game loop.
     */
    void start();

    /**
     * Stops the game loop.
     */
    void stop();

    /**
     * Retrieves the game loop status.
     * @return Whether the game loop is running.
     */
    boolean isRunning();
}
