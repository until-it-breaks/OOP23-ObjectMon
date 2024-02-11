package it.unibo.objectmon.controller.engine;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.view.View;

/**
 * A basic implementation of a game loop.
 */
public class GameLoopImpl implements GameLoop {
    /**
     * The target frame rate.
     */
    public static final int TARGET_FPS = 30;
    private static final int SECOND_IN_MILLIS = 1_000;
    private static final int PERIOD = SECOND_IN_MILLIS / TARGET_FPS;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final Model model;
    private final View view;
    private long fps;
    private final Controller controller;
    private boolean keepRunning;

    /**
     * Constructs a new Game Loop.
     * 
     * @param model The model where commands will be executed.
     * @param view The view where the game will be rendered.
     * @param controller The controller where the commands are polled.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "The game engine has the ability to shut down the view")
    public GameLoopImpl(final Model model, final View view, final Controller controller) {
        this.model = model;
        this.view = view;
        this.controller = controller;
        this.keepRunning = true;
    }

    /**
     * The methods that starts the game loop.
     * It updates the game state and rendering frames until stopped.
     * This method should be called once to begin the game loop.
     */
    @Override
    public void start() {
        long previousTime = System.currentTimeMillis();
        while (keepRunning) {
            final long currentTime = System.currentTimeMillis();
            final long elapsed = currentTime - previousTime;
            updateFPS(elapsed);
            processInput();
            render();
            waitForNextFrame(currentTime);
            previousTime = currentTime;
        }
        view.destroy();
    }

    /**
     * Stops the game loop, causing it to exit the main loop.
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
     * Updates the FPS.
     * 
     * @param elapsed the time elapsed since the start of the current frame.
     */
    protected void updateFPS(final long elapsed) {
        if (elapsed > 0) {
            this.fps = SECOND_IN_MILLIS / elapsed;
        }
    }

    /**
     * Retrieves the latest calculate fps.
     * 
     * @return The fps.
     */
    protected long getFPS() {
        return this.fps;
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

    /**
     * Returns the game loop status.
     */
    @Override
    public boolean isRunning() {
        return this.keepRunning;
    }
}
