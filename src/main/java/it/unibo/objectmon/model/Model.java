package it.unibo.objectmon.model;

/**
 * Models the master model of the application.
 */
public final class Model {
    private final GameManager gameManager;
    /**
     * Creates a world with entities and environment.
     */
    public Model() {
        this.gameManager = new GameManager();
    }
    /**
     * 
     * @return the game manager.
     */
    public GameManager getGameManager() {
        return this.gameManager;
    }
}
