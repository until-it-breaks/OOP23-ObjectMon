package it.unibo.objectmon.model.world;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import it.unibo.objectmon.model.world.api.Coord;
import it.unibo.objectmon.model.world.api.World;
import it.unibo.objectmon.model.world.api.Worlds;

/**
 * Represents the game environment, consisting of a grid of tiles.
 * The World class initializes itself by loading tiles from a default file.
 */
public final class WorldImpl implements World {

    private int width;
    private int height;
    private final Map<Coord, Tile> map;
    private Coord startingPosition;

    /**
     * Constructs a new World and initializes it by loading tiles from a config.
     * 
     * @param config The config from which default settings are taken.
     */
    public WorldImpl(final Worlds config) {
        map = new LinkedHashMap<>();
        initialize(config);
    }

    @Override
    public Map<Coord, Tile> getMap() {
        return Collections.unmodifiableMap(this.map);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Coord getStartingPosition() {
        return startingPosition;
    }

    private void initialize(final Worlds config) {
        final MapData mapData = MapData.loadFromJson(config.getWorldPath());
        final TileSet tileSet = new TileSet(config.getAtlasPath());
        this.width = mapData.getWidth();
        this.height = mapData.getHeight();
        this.startingPosition = new Coord(mapData.getStartingX(), mapData.getStartingY());
        for (int i = 0; i < mapData.getWidth(); i++) {
            for (int j = 0; j < mapData.getHeight(); j++) {
                final int tileId = mapData.getData().get(i).get(j);
                final Tile tile = tileSet.getTileById(tileId);
                map.put(new Coord(j, i), tile);
            }
        }
    }
}
