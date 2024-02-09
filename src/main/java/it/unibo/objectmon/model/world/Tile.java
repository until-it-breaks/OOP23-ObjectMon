package it.unibo.objectmon.model.world;

/**
 * Models a single map unit.
 * Each tile has a unique identifier, a type, and an associated image path.
 */
public final class Tile {

    private final int id;
    private final String type;
    private final boolean triggersEncounters;
    private final boolean passable;
    private final String imagePath;

    /**
     * Creates a basic tile.
     * 
     * @param id The unique identifier of the tile.
     * @param type The type of the tile.
     * @param triggersEncounters The ability of triggering random encounters.
     * @param passable The ability of preventing movement.
     * @param imagePath The file path to the image representing the tile.
     */
    public Tile(final int id, final String type, final boolean triggersEncounters,
                final boolean passable, final String imagePath) {
        this.id = id;
        this.type = type;
        this.triggersEncounters = triggersEncounters;
        this.passable = passable;
        this.imagePath = imagePath;
    }

    /**
     * Retrieves the unique identifier of the tile.
     * @return The tile's unique identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the name or type of the tile.
     * @return The tile's name or type.
     */
    public String getType() {
        return type;
    }

    /**
     * Retrieves whether the tile can trigger random encounters.
     * @return The tile ability to trigger random encounters.
     */
    public boolean isTriggersEncounters() {
        return triggersEncounters;
    }

    /**
     * Retrieves whether the tile can be walked over.
     * @return The ability of the tile of preventing the player from walking over.
     */
    public boolean isPassable() {
        return passable;
    }

    /**
     * Retrieves the file path to the image representing the tile.
     * @return The file path to the tile's image.
     */
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "Tile [id=" + id + ", type=" + type + ", imagePath=" + imagePath + "]";
    }
}
