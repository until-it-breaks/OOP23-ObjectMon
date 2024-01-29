package it.unibo.objectmon.model.world;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A basic representation of the game environment.
 */
public final class World {
    private int width;
    private int height;

    private final Map<Coord, Tile> map;
    /**
     * Creates a world with its tiles loaded from a default file.
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
        for (int i = 0; i < mapData.getWidth(); i++) {
            for (int j = 0; j < mapData.getHeight(); j++) {
                for (final Tile tile : tileSet.getTileAtlas()) {
                    if (tile.getId() == mapData.getData().get(i).get(j)) {
                        map.put(new Coord(j, i), tile);
                        break;
                    }
                }
            }
        }
    }

    /**
     * 
     * @return an immutable list of tiles.
     */
    public Map<Coord, Tile> getMap() {
        return Collections.unmodifiableMap(this.map);
    }
    /**
     * 
     * @return the world width.
     */
    public int getWidth() {
        return width;
    }
    /**
     * 
     * @return the world height
     */
    public int getHeight() {
        return height;
    }
}
