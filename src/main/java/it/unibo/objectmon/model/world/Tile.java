package it.unibo.objectmon.model.world;

/**
 * Models a single map unit.
 */
public final class Tile {
    private final int id;
    private final String type;
    private final String imagePath;
    /**
     * Creates a basic tile.
     * 
     * @param id the tile id.
     * @param type the tile name.
     * @param imagePath the tile image path.
     */
    public Tile(final int id, final String type, final String imagePath) {
        this.id = id;
        this.type = type;
        this.imagePath = imagePath;
    }
    /**
     *
     * @return the tile id.
     */
    public int getId() {
        return id;
    }
    /**
     * 
     * @return the tile name.
     */
    public String getType() {
        return type;
    }
    /**
     * 
     * @return the tile image path.
     */
    public String getImagePath() {
        return imagePath;
    }
    @Override
    public String toString() {
        return "Tile [id=" + id + ", type=" + type + ", imagePath=" + imagePath + "]";
    }
}
