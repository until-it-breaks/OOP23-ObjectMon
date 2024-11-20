package it.unibo.objectmon.model.gamestate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.gamestate.api.GameState;
import it.unibo.objectmon.view.SwingViewImpl;

/**
 *  Test of the package gamestate.
 */
class TestGameState {

private GameStateManagerImpl gameStateManager;
    private SwingViewImpl observer;

    @BeforeEach
    void init() {
        gameStateManager = new GameStateManagerImpl();
        observer = mock(SwingViewImpl.class);
    }

    @Test
    void testSetGameStateNotifyingObservers() {
        gameStateManager.registerObserver(observer);
        gameStateManager.setGameState(GameState.EXPLORATION);
        // Verify that the observers were notified
        verify(observer).update();
    }

    @Test
    void testSetGameStateNotNotifyingObserversWhenStateUnchanged() {
        gameStateManager.registerObserver(observer);
        // Set the game state to the same state
        gameStateManager.setGameState(GameState.NONE);
        // Verify that the observers were not notified
        verify(observer, never()).update();
    }

    @Test
    void testUnregisterObserver() {
        gameStateManager.registerObserver(observer);
        // Unregister one observer
        gameStateManager.unregisterObserver(observer);
        // Set the game state
        gameStateManager.setGameState(GameState.ENDING);
        // Verify that only one observer was notified
        verify(observer, never()).update();
    }
}
