package it.unibo.objectmon.controller.engine;

/**
 * Implementations of this interface allow control the flow of the game,
 * including starting and stopping the updates and rendering cycle.
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
     * 
     * @return Whether the game loop is running.
     */
    boolean isRunning();

    /**
     * Retrieves the last calculated FPS.
     * 
     * @return The FPS.
     */
    int getFPS();
}
