package it.unibo.objectmon.controller;

import it.unibo.objectmon.model.GameModel;
import it.unibo.objectmon.model.world.World;
import it.unibo.objectmon.view.GameView;

public class GameController {

    private static final int FPS = 30;
    private static final long SECOND_IN_MILLIS = 1_000_000_000;

    private GameModel model;
    private GameView view;

    public GameController(final GameModel model, final GameView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        final double drawInterval = (double) SECOND_IN_MILLIS / FPS;
        double delta = 0.0;
        long previousTime = System.nanoTime();
        long currentTime;

        while (true) {
            currentTime = System.nanoTime();
            delta += (currentTime - previousTime) / drawInterval;
            previousTime = currentTime;

            if (delta >= 1) {
                update();
                render();
                delta--;
            }
        }
    }

    public void processInput() {

    }

    public void update() {
    }

    public World getWorld() {
        return model.getWorld();
    }

    public void render() {
        this.view.render();
    }
}
