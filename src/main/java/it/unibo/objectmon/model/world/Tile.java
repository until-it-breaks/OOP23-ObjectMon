package it.unibo.objectmon.model.world;

public final class Tile {
    private final TileType type;
    private final boolean passable;

    public Tile(final TileType type) {
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
