package it.unibo.objectmon.model;


public final class MainModel {
    private GameState gameState;

    public MainModel() {
        this.gameState = new GameState();
    }

    public GameState getGameState() {
        return this.gameState;
    }
}
