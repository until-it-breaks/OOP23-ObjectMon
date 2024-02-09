package it.unibo.objectmon.controller.engine;

import java.util.logging.Level;
import java.util.logging.Logger;
import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.view.api.View;

/**
 * A basic implementation of a game loop.
 */
public class GameLoopImpl implements GameLoop {
    private static final int TARGET_FPS = 30;
    private static final long PERIOD = 1_000 / TARGET_FPS;
    private final Logger logger = Logger.getLogger("GameLoop");
    private final Model model;
    private final View view;
    private final Controller controller;
    private boolean keepRunning;

    /**
     * Constructs a new Game Loop.
     * 
     * @param model the model on which commands will be executed.
     * @param view the view on which the game will be rendered.
     * @param controller the controller from which commands are polled.
     */
    public GameLoopImpl(final Model model, final View view, final Controller controller) {
        this.model = model;
        this.view = view;
        this.controller = controller;
        this.keepRunning = true;
    }

    /**
     * Starts the game loop, continuously updating the game state and rendering frames until stopped.
     * This method should be called once to begin the game loop.
     */
    @Override
    public void start() {
        long previousTime = System.currentTimeMillis();
        while (keepRunning) {
            final long currentTime = System.currentTimeMillis();
            final long elapsed = currentTime - previousTime;
            printFPS(elapsed);
            processInput();
            render();
            waitForNextFrame(currentTime);
            previousTime = currentTime;
        }
        view.destroy();
    }

    /**
     * Stops the game loop, causing it to exit the main loop and terminate gracefully.
     * Once stopped, the game loop cannot be restarted.
     */
    @Override
    public void stop() {
        this.keepRunning = false;
    }

    /**
     * Waits for the next frame to maintain the target frame rate.
     * 
     * @param startTime the time when the current frame started rendering.
     */
    protected void waitForNextFrame(final long startTime) {
        final long delta = System.currentTimeMillis() - startTime;
        if (delta < PERIOD) {
            try {
                Thread.sleep(PERIOD - delta);
            } catch (final InterruptedException e) {
                logger.log(Level.FINE, e.getMessage(), e);
            }
        }
    }

    /**
     * Prints the FPS to the controller.
     * 
     * @param elapsed the time elapsed since the start of the current frame.
     */
    protected void printFPS(final long elapsed) {
        if (elapsed > 0) {
            controller.updateFPS(1_000 / elapsed);
        }
    }

    /**
     * Processes user input by polling commands from the controller and executing them on the model.
     */
    protected void processInput() {
        final Command command = this.controller.pollCommand();
        if (command != null) {
            command.execute(model);
        }
    }

    /**
     * Renders the current state of the game using the view.
     */
    protected void render() {
        this.view.render();
    }
}
