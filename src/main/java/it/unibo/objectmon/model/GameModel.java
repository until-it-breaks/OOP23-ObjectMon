package it.unibo.objectmon.model;

import it.unibo.objectmon.model.world.TileSetLoader;
import it.unibo.objectmon.model.world.TileSetLoader.TileSet;

public final class GameModel {
    private GameState gameState;
    private TileSet tileSet;

    public GameModel() {
        this.gameState = new GameState();
        this.tileSet = TileSetLoader.loadFromJson();
    }

    public TileSet getTileSet() {
        return this.tileSet;
    }

    public GameState getGameState() {
        return this.gameState;
    }
}
