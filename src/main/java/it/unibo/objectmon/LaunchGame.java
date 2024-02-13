package it.unibo.objectmon;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.controller.ControllerImpl;

/**
 * The entry point of the game.
 */
public final class LaunchGame {

    private LaunchGame() {
    }

    /**
     * Sets up and starts the game.
     * 
     * @param args The arguments from the command-line.
     */
    public static void main(final String[] args) {
        final Controller controller = new ControllerImpl();
        controller.startGame();
    }
}
