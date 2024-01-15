package it.unibo.objectmon.model.world;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A basic representation of the game environment.
 */
public final class World {
    private final Map<Coord, Tile> tiles;
    /**
     * Creates a world with its tiles loaded from a default file.
     */
    public World() {
        tiles = new LinkedHashMap<>();
        init();
    }
    private void init() {
    }
    /**
     * 
     * @return an immutable list of tiles.
     */
    public Map<Coord, Tile> getTiles() {
        return Collections.unmodifiableMap(this.tiles);
    }
}
