package it.unibo.objectmon.model.world;

import java.util.LinkedHashMap;
import java.util.Map;


public class World {
    private Map<Coord, Tile> tiles;

    public World() {
        tiles = new LinkedHashMap<>();
    }

    public Tile getTileAt(final Coord coord) {
        return tiles.get(coord);
    }

    public void setTileAt(final Coord coord, final Tile tile) {
        this.tiles.put(coord, tile);
    }

    public Map<Coord, Tile> getTiles() {
        return this.tiles;
    }
}
