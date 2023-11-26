package it.unibo.objectmon;

import it.unibo.objectmon.controller.GameController;
import it.unibo.objectmon.model.GameModel;
import it.unibo.objectmon.view.GameView;

public class LaunchApp {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        GameController gameController = new GameController();
        GameModel gameModel = new GameModel();
        gameView.setController(gameController);
        gameController.setView(gameView);
        gameController.setModel(gameModel);
        gameController.startGame();
    }
}
