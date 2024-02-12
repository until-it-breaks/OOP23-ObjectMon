package it.unibo.objectmon;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.controller.ControllerImpl;

/**
 * The start of the game application.
 * 
 * This class contains the main method that launches the game.
 * It initializes the Model, View, and Controller components, and then
 * starts the game by building the initial View and begins the game execution.
 * 
 */
public final class LaunchGame {

    private LaunchGame() {
    }

    /**
     * Sets up and starts the game.
     * 
     * @param args The arguments of the command-line passed to the application.
     */
    public static void main(final String[] args) {
        final Controller controller = new ControllerImpl();
        controller.startGame();
    }
}
