package it.unibo.objectmon.controller;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import it.unibo.objectmon.model.MainModel;
import it.unibo.objectmon.view.MainView;

public final class MainController {

    final long period = 20;

    private static final int COMMAND_LIMIT = 64;
    private Queue<Command> commandQueue;

    private MainModel model;
    private MainView view;

    public MainController(final MainModel model, final MainView view) {
        this.model = model;
        this.view = view;
        commandQueue = new ArrayBlockingQueue<>(COMMAND_LIMIT);
    }

    private void startLoop() {
        long previousTime = System.currentTimeMillis();
        while (true) {
            long currentTime = System.currentTimeMillis();
            long elapsed = currentTime - previousTime;
            //printFPS(elapsed);
            processInput();
            update(elapsed);
            render();
            waitForNextFrame(currentTime);
            previousTime = currentTime;
        }
    }

    private void waitForNextFrame(final long startTime) {
        long delta = System.currentTimeMillis() - startTime;
        if (delta < period) {
            try {
                Thread.sleep(period - delta);
            } catch (Exception e) {}
        }
    }

    private void printFPS(long elapsed) {
        if (elapsed > 0) {
            System.out.println("FPS: " + (1_000 / elapsed));
        } else {
            System.out.println("FPS: N/A");
        }
    }

    public void processInput() {
        Command command = commandQueue.poll();
        if (command != null) {
            command.execute(model.getGameState());
        }
    }

    public void update(long elapsed) {
        //To be implemented to avoid giving an advantage to fast PCs
    }

    public void notifyCommand(final Command command) {
        this.commandQueue.add(command);
    }

    public void render() {
        this.view.render();
    }

    public MainModel getModel() {
        return this.model;
    }

    public void startGame() {
        this.startLoop();
    }
}
