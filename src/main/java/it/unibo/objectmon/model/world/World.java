package it.unibo.objectmon.model.world;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class World {
    private final Map<Coord, Tile> tiles;

    public World() {
        tiles = new LinkedHashMap<>();
        init();
    }

    private void init() {

    }

    public Map<Coord, Tile> getTiles() {
        return Collections.unmodifiableMap(this.tiles);
    }

    public void addTile(final Coord coord, final Tile tile) {
        this.tiles.put(coord, tile);
    }
}
