package it.unibo.objectmon.model.world;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Represents a set of tiles used within the game environment.
 * The TileSet class loads tile data from a JSON file and provides methods
 * for accessing individual tiles by their IDs.
 */
public final class TileSet {

    private final Set<Tile> tileAtlas;
    private final Map<Integer, Tile> tileIdMap;
    private final Logger logger = Logger.getLogger(TileSet.class.getName());

    /**
     * Creates the tileset by loading data from JSON.
     * @param path the path to the atlas file.
     */
    public TileSet(final String path) {
        this.tileAtlas = loadFromJson(path);
        this.tileIdMap = createTileIdMap();
    }

    /**
     * Retrieves a Tile object by its ID.
     * @param id The ID of the tile to retrieve.
     * @return The Tile object corresponding to the given ID, or null if not found.
     */
    public Tile getTileById(final int id) {
        return tileIdMap.get(id);
    }

    private Set<Tile> loadFromJson(final String path) {
        try (InputStream inputStream = this.getClass().getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            final Type setOfTiles = new TypeToken<LinkedHashSet<Tile>>() { }.getType();
            final Gson gson = new Gson();
            final Set<Tile> tileSet = gson.fromJson(reader, setOfTiles);
            if (tileSet == null) {
                throw new IllegalStateException("No tile data found in: " + path);
            }
            return tileSet;
        } catch (final IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            throw new IllegalStateException("Error loading tile data from: " + path, e);
        }
    }

    private Map<Integer, Tile> createTileIdMap() {
        final Map<Integer, Tile> out = new HashMap<>();
        for (final Tile tile : tileAtlas) {
            out.put(tile.getId(), tile);
        }
        return Collections.unmodifiableMap(out);
    }
}
