package it.unibo.objectmon.model.world;

public class Tile {
    private TileType type;
    private boolean passable;

    public Tile(TileType type) {
        this.type = type;
        this.passable = true;
    }

    @Override
    public String toString() {
        return "Tile [type=" + type + ", passable=" + passable + "]";
    }

    public TileType getType() {
        return type;
    }

    public boolean isPassable() {
        return passable;
    }
}
