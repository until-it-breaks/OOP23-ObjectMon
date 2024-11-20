package it.unibo.objectmon.model.gamestate.api;

/**
 * Functional interface that only sets the gamestate.
 */
public interface GameStateSetter {

    /**
     * Sets the new game state.
     * 
     * @param gameState The new gamestate to be set.
     */
    void setGameState(GameState gameState);
}
