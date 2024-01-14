package it.unibo.objectmon;

import it.unibo.objectmon.controller.GameController;
import it.unibo.objectmon.model.GameModel;
import it.unibo.objectmon.view.GameView;

public final class LaunchGame {

    private LaunchGame() {
    }

    public static void main(final String[] args) {
        GameModel model = new GameModel();

        GameView view = new GameView();

        GameController controller = new GameController(model, view);

        view.setController(controller);

        controller.startGame();
    }
}
