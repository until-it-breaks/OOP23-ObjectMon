package it.unibo.objectmon.model.gamestate;
/**
 * functional interface: it only set the gamestate.
 */
public interface GameStateSetter {
    /**
     * 
     * @param gameState new gamestate to set.
     */
    void setGameState(GameState gameState);
}
