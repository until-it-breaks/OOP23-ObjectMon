package it.unibo.objectmon.controller.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.controller.ControllerImpl;
import it.unibo.objectmon.controller.commands.EndGame;
import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.gamestate.GameState;

/**
 * Unit tests for the {@link GameLoopImpl} class.
 */
class TestEndGame {
    private final Controller controller = new ControllerImpl();

    /**
     * Test EndGame Command.
     */
    @Test
    void testEndGame() {
        assertFalse(controller.isWin());
        assertFalse(controller.isLoss());

        // Check that game can't reach end state if not paused.
        controller.notifyCommand(new EndGame());
        controller.execute();
        assertEquals(GameState.EXPLORATION, controller.getGameState());

        // Check that game can reach end state if paused.
        controller.notifyCommand(new Command() {
            @Override
            public void execute(final Model model) {
                model.setGameState(GameState.PAUSE);
            }
        });
        controller.execute();
        assertEquals(GameState.PAUSE, controller.getGameState());

        controller.notifyCommand(new EndGame());
        controller.execute();
        assertEquals(GameState.END, controller.getGameState());

        //Resets the model of the controller, restarting the game
        controller.restart();
        assertEquals(GameState.EXPLORATION, controller.getGameState());
    }
}
