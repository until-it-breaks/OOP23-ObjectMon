package it.unibo.objectmon.model;

public final class GameModel {
    private GameState gameState;

    public GameState getGameState() {
        return gameState;
    }

    public GameModel() {
        this.gameState = new GameState();
    }
}
