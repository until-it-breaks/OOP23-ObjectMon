package it.unibo.objectmon.controller;

/**
 * Represents the basic behaviour of a game loop.
 */
public interface Gameloop {
    /**
     * Runs an infinite loop and calls update() according to a strict timing.
     */
    void run();

    /**
     * This method will receive inputs from the view implementation and update the model accordingly.
     */
    void update();

    /**
     * Starts the thread itself.
     */
    void start();

}
