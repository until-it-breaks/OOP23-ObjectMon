package it.unibo.objectmon.controller.engine;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.view.api.View;

/**
 * Unit tests for the {@link GameLoopImpl} class.
 */
class GameLoopTest {

    private final Model model = mock(Model.class);
    private final View view = mock(View.class);
    private Controller controller;
    private GameLoopImpl gameLoop;
    private Thread gameLoopThread;
    private static final int MILLIS_TO_WAIT = 3000;

    @BeforeEach
    void init() {
        controller = mock(Controller.class);
        gameLoop = new GameLoopImpl(model, view, controller);
        gameLoopThread = new Thread(() -> gameLoop.start());
    }

    @Test
    void testStartAndStop() throws InterruptedException {
        gameLoopThread.start();
        Thread.sleep(1000);
        assertTrue(gameLoop.isRunning());
        gameLoop.stop();
        assertFalse(gameLoop.isRunning());
    }

    @Test
    void testFrameRate() throws InterruptedException {
        gameLoopThread.start();
        Thread.sleep(MILLIS_TO_WAIT);
        assertTrue(controller.getFPS() <= GameLoopImpl.TARGET_FPS);
        gameLoop.stop();
    }
}
