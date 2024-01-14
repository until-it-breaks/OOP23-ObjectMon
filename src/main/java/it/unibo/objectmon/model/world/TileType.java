package it.unibo.objectmon.model.world;

/**
 * Represents a tile type.
 */
public enum TileType {
    /**
     * A water tile.
     */
    WATER("water"),
    /**
     * A grass tile.
     */
    GRASS("grass"),
    /**
     * A stone tile.
     */
    STONE("stone"),
    /**
     * The default tile.
     */
    VOID("void");

    private final String tileName;

    TileType(final String tileName) {
        this.tileName = tileName;
    }
    /**
     * @return the tile name.
     */
    public String getName() {
        return this.tileName;
    }
}

