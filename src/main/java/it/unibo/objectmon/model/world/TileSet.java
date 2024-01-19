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
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/**
 * A temporary class used as lookup to initialize World.
 */
public final class TileSet {
    private static final String ATLAS_PATH = "/world/atlas.json";

    private final Set<Tile> tileAtlas;
    private final Logger logger = Logger.getLogger("TileManager");
    /**
     * Creates the tileset with data deserialized already.
     */
    public TileSet() {
        this.tileAtlas = loadFromJson();
    }
    /**
     * 
     * @return an immutable Set of tiles.
     */
    public Set<Tile> getTileAtlas() {
        return Collections.unmodifiableSet(tileAtlas);
    }

    private Set<Tile> loadFromJson() {
        try (InputStream inputStream = this.getClass().getResourceAsStream(ATLAS_PATH);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            final Type setOfTiles = new TypeToken<LinkedHashSet<Tile>>() { }.getType();
            final Gson gson = new Gson();
            return gson.fromJson(reader, setOfTiles);
        } catch (final IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
        return Set.of();
    }
}
