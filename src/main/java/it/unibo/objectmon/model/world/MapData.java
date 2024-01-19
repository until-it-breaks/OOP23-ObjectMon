package it.unibo.objectmon.model.world;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
/**
 * Temporary class used for deserialization and data refining.
 */
public final class MapData {
    private static final String MAP_PATH = "/world/map.json";
    private static final Logger LOGGER = Logger.getLogger("MapDataLoading");

    private final int height;
    private final int width;
    private final List<List<Integer>> data;

    private MapData(final int height, final int width, final List<List<Integer>> data) {
        this.height = height;
        this.width = width;
        this.data = data;
    }
    /**
     * 
     * @return the height of the map.
     */
    public int getHeight() {
        return height;
    }
    /**
     * 
     * @return the width of the map.
     */
    public int getWidth() {
        return width;
    }
    /**
     * 
     * @return an matrix-like id representation of the map.
     */
    public List<List<Integer>> getData() {
        return Collections.unmodifiableList(data);
    }
    /**
     * 
     * @return returns MapData from a json file in the resource folder.
     */
    public static MapData loadFromJson() {
        try (InputStream inputStream = MapData.class.getResourceAsStream(MAP_PATH);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                final Gson gson = new Gson();
                return gson.fromJson(reader, MapData.class);
            } catch (final IOException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        return null;
    }
}
