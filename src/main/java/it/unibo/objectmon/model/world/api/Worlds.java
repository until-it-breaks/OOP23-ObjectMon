package it.unibo.objectmon.model.world.api;

/**
 * An enum containing information about each world available.
 */
public enum Worlds {

    /**
     * The DEMO world.
     */
    DEMO("/world/map.json", "/world/atlas.json");

    private final String worldPath;
    private final String atlasPath;

    Worlds(final String worldPath, final String atlasPath) {
        this.worldPath = worldPath;
        this.atlasPath = atlasPath;
    }

    /**
     * Returns a string representing the map path.
     * 
     * @return The path corresponding to the map location.
     */
    public String getWorldPath() {
        return this.worldPath;
    }

    /**
     * Returns a string representing the map atlas.
     * 
     * @return The path corresponding to the map atlas,
     */
    public String getAtlasPath() {
        return this.atlasPath;
    }
}
