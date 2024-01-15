package it.unibo.objectmon;

import it.unibo.objectmon.controller.MainController;
import it.unibo.objectmon.model.MainModel;
import it.unibo.objectmon.view.MainView;

public final class LaunchGame {

    private LaunchGame() {
    }

    public static void main(final String[] args) {
        MainModel model = new MainModel();
        MainView view = new MainView();
        MainController controller = new MainController(model, view);

        controller.startGame();
    }
}
