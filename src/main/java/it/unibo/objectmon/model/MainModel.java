package it.unibo.objectmon.model;

/**
 * Models the master model of the application.
 */
public final class MainModel {
    private final GameState gameState;
    /**
     * Creates a basic model.
     */
    public MainModel() {
        this.gameState = new GameState();
    }
    /**
     * 
     * @return the current game state.
     */
    public GameState getGameState() {
        return this.gameState;
    }
}
