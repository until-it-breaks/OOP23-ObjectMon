package it.unibo.objectmon.model.world;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents the game environment, consisting of a grid of tiles.
 * The World class initializes itself by loading tiles from a default file.
 */
public final class World {

    private int width;
    private int height;
    private final Map<Coord, Tile> map;
    private Coord startingPosition;

    /**
     * Constructs a new World object and initializes it by loading tiles from a default file.
     */
    public World() {
        map = new LinkedHashMap<>();
        init();
    }

    private void init() {
        final MapData mapData = MapData.loadFromJson();
        final TileSet tileSet = new TileSet();
        this.width = mapData.getWidth();
        this.height = mapData.getHeight();
        this.startingPosition = new Coord(mapData.getStartingX(), mapData.getStartingY());
        for (int i = 0; i < mapData.getWidth(); i++) {
            for (int j = 0; j < mapData.getHeight(); j++) {
                final int tileId = mapData.getData().get(i).get(j);
                final Tile tile = tileSet.getTileById(tileId);
                if (tile != null) {
                    map.put(new Coord(j, i), tile);
                }
            }
        }
    }

    /**
     * Retrieves an immutable mapping of coordinates to tiles, representing the game world.
     * @return An immutable map of coordinates to tiles.
     */
    public Map<Coord, Tile> getMap() {
        return Collections.unmodifiableMap(this.map);
    }

    /**
     * Retrieves the width of the game world grid.
     * @return The width of the game world.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Retrieves the height of the game world grid.
     * @return The height of the game world.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Retrives the starting position of the player.
     * @return A coord representing the starting position of the player.
     */
    public Coord getStartingPosition() {
        return startingPosition;
    }
}
