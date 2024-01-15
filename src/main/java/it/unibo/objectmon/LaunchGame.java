package it.unibo.objectmon;

import it.unibo.objectmon.controller.MainController;
import it.unibo.objectmon.model.MainModel;
import it.unibo.objectmon.view.MainViewImpl;
import it.unibo.objectmon.view.api.View;
/**
 * The entry point of the game.
 */
public final class LaunchGame {

    private LaunchGame() {
    }
    /**
     * Sets up and starts the game.
     * @param args
     */
    public static void main(final String[] args) {
        final MainModel model = new MainModel();
        final View view = new MainViewImpl();
        final MainController controller = new MainController(model, view);

        controller.startGame();
    }
}
