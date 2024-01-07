package it.unibo.objectmon.model.world;

/**
 * Represents a tile type.
 */
public enum TileType {
    /**
     * A water tile.
     */
    WATER("water", 0),
    /**
     * A grass tile.
     */
    GRASS("grass", 1),
    /**
     * The default tile.
     */
    VOID("void", -1);

    private final String tileName;
    private final int tileId;

    TileType(final String tileName, final int tileId) {
        this.tileName = tileName;
        this.tileId = tileId;
    }
    /**
     * @return the tile name.
     */
    public String getName() {
        return this.tileName;
    }
    /**
     * @return the tile id.
     */
    public int getId() {
        return this.tileId;
    }
}
