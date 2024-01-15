package it.unibo.objectmon.controller;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import it.unibo.objectmon.model.MainModel;
import it.unibo.objectmon.view.api.View;
/**
 * Models the master controller of the application.
 */
public final class MainController {

    private static final long PERIOD = 20;
    private static final int COMMAND_LIMIT = 64;

    private final Queue<Command> commandQueue;

    private final Logger logger = Logger.getLogger("TextureLoader");

    private final MainModel model;
    private final View view;

    /**
     * Creates a controller and hooks it to a model and a view.
     * 
     * @param model the target model.
     * @param view the target view.
     */
    public MainController(final MainModel model, final View view) {
        this.model = model;
        this.view = view;
        commandQueue = new ArrayBlockingQueue<>(COMMAND_LIMIT);
    }

    private void startLoop() {
        long previousTime = System.currentTimeMillis();
        while (true) {
            final long currentTime = System.currentTimeMillis();
            final long elapsed = currentTime - previousTime;
            printFPS(elapsed);
            processInput();
            update(); //uses elapsed
            render();
            waitForNextFrame(currentTime);
            previousTime = currentTime;
        }
    }

    private void waitForNextFrame(final long startTime) {
        final long delta = System.currentTimeMillis() - startTime;
        if (delta < PERIOD) {
            try {
                Thread.sleep(PERIOD - delta);
            } catch (final InterruptedException e) {
                logger.log(Level.FINE, e.getMessage(), e);
            }
        }
    }

    private void printFPS(final long elapsed) {
        if (elapsed > 0) {
            final long fps = 1_000 / elapsed;
            this.logger.log(Level.INFO, "FPS: " + fps);
        }
    }

    private void processInput() {
        final Command command = commandQueue.poll();
        if (command != null) {
            command.execute(model.getGameState());
        }
    }

    private void update() {
        //To be implemented to avoid giving an advantage to fast PCs
    }
    /**
     * Notifies the controller of a Command.
     * 
     * @param command the command to be added to the controller command queue.
     */
    public void notifyCommand(final Command command) {
        this.commandQueue.add(command);
    }

    private void render() {
        this.view.render();
    }
    /**
     * 
     * @return the model.
     */
    public MainModel getModel() {
        return this.model;
    }
    /**
     * Starts the game.
     */
    public void startGame() {
        this.startLoop();
    }
}
