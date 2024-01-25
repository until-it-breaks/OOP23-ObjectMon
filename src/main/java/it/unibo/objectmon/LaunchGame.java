package it.unibo.objectmon;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.view.View;
/**
 * The entry point of the game.
 */
public final class LaunchGame {

    private LaunchGame() {
    }
    /**
     * Sets up and starts the game.
     * @param args does nothing
     */
    public static void main(final String[] args) {
        final Model model = new Model();
        final View view = new View();
        final Controller controller = new Controller(model, view);
        view.build(controller);
        controller.startGame();
    }
}
