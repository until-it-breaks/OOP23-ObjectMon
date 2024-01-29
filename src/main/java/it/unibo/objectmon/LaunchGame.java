package it.unibo.objectmon;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.view.ViewImpl;
import it.unibo.objectmon.view.api.View;

/**
 * The entry point of the game application.
 * 
 * This class contains the main method that serves as the entry point for launching
 * the game. It initializes the Model, View, and Controller components, and then
 * starts the game by building the initial view and beginning game execution.
 * 
 */
public final class LaunchGame {

    private LaunchGame() {
    }

    /**
     * Sets up and starts the game.
     * 
     * @param args The command-line arguments passed to the application (not used).
     */
    public static void main(final String[] args) {
        final Model model = new Model();
        final View view = new ViewImpl();
        final Controller controller = new Controller(model, view);
        view.build(controller);
        controller.startGame();
    }
}
