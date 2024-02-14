package it.unibo.objectmon.model.gamestate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 *  Test of the package gamestate.
 */
class TestGameState {

    /**
     * Test of the GameStateManager.
     */
    @Test
    void testGameStateManager() {
        final GameStateManager gameStateManager = new GameStateManagerImpl();
        assertEquals(GameState.NONE, gameStateManager.getGameState());
        gameStateManager.setGameState(GameState.EXPLORATION);
        assertEquals(GameState.EXPLORATION, gameStateManager.getGameState());
        gameStateManager.setGameState(GameState.BATTLE);
        assertEquals(GameState.BATTLE, gameStateManager.getGameState());
        gameStateManager.setGameState(GameState.BATTLE);
        assertEquals(GameState.BATTLE, gameStateManager.getGameState());
        gameStateManager.setGameState(GameState.BATTLE);
    }
}
