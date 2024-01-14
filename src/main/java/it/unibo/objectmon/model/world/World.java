package it.unibo.objectmon.model.world;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import it.unibo.objectmon.model.world.MapLoader.MapData;
import it.unibo.objectmon.model.world.TileSetLoader.Tile;
import it.unibo.objectmon.model.world.TileSetLoader.TileSet;

public final class World {
    private final Map<Coord, Tile> tiles;

    public World() {
        tiles = new LinkedHashMap<>();
        init();
    }

    private void init() {
        MapData mapData = MapLoader.loadFromJson();
        TileSet tileSet = TileSetLoader.loadFromJson();

        Map<Integer, Tile> tileSetMap = new HashMap<>();
        for (Tile tile : tileSet.getTiles()) {
            tileSetMap.put(tile.getId(), tile);
        }

        var iterator = mapData.getLayers().get(0).getData().iterator();
        for (int i = 0; i < mapData.getHeight(); i++) {
            for (int j = 0; j < mapData.getWidth(); j++) {
                if (iterator.hasNext()) {
                    tiles.put(new Coord(i, j), tileSetMap.get(iterator.next()));
                }
            }
        }
        
    }

    public Map<Coord, Tile> getTiles() {
        return Collections.unmodifiableMap(this.tiles);
    }

    public void addTile(final Coord coord, final Tile tile) {
        this.tiles.put(coord, tile);
    }
}
