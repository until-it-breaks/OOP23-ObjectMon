package it.unibo.objectmon.controller;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import it.unibo.objectmon.model.GameModel;
import it.unibo.objectmon.model.GameState;
import it.unibo.objectmon.view.GameView;

public final class GameController {

    private static final int FPS = 60;
    private static final long SECOND_IN_MILLIS = 1_000_000_000;

    private static final int COMMAND_LIMIT = 64;
    private Queue<Command> commandQueue;

    private GameModel model;
    private GameView view;

    public GameController(final GameModel model, final GameView view) {
        this.model = model;
        this.view = view;
        commandQueue = new ArrayBlockingQueue<>(COMMAND_LIMIT);
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
                processInput();
                //update();
                render();
                delta--;
            }
        }
    }

    public void processInput() {
        Command command = commandQueue.poll();
        if (command != null) {
            command.execute(model.getGameState());
        }
    }

    public void update() {
        //To be implemented to avoid giving an advantage to fast PCs
    }

    public void notifyCommand(final Command command) {
        this.commandQueue.add(command);
    }

    public void render() {
        this.view.render();
    }

    public GameState gameState() {
        return this.model.getGameState();
    }
}
