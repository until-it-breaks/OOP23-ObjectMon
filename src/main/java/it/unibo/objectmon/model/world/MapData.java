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
 * Represents map data loaded from a JSON file.
 * This class provides methods for deserializing map data and accessing its properties.
 */
public final class MapData {

    private static final Logger LOGGER = Logger.getLogger(MapData.class.getName());
    private final int height;
    private final int width;
    private final List<List<Integer>> data;
    private final int startingX;
    private final int startingY;

    /**
     * Creates a MapData object with the given map dimensions and data.
     * This constructor is private and is used internally for creating MapData instances.
     *
     * @param height The height of the map.
     * @param width The width of the map.
     * @param data A matrix-like representation of the map data.
     * @param startingX The starting X coordinate of the player.
     * @param startingY The starting Y coordinate of the player.
     */
    private MapData(final int height, final int width, final List<List<Integer>> data, final int startingX, final int startingY) {
        this.height = height;
        this.width = width;
        this.data = data;
        this.startingX = startingX;
        this.startingY = startingY;
    }

    /**
     * Retrieves the height of the map.
     * 
     * @return The height of the map.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Retrieves the width of the map.
     * 
     * @return The width of the map.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Retrieves the starting X coordinate of the player.
     * 
     * @return The starting X coordinate of the player.
     */
    public int getStartingX() {
        return startingX;
    }

    /**
     * Retrieves the starting Y coordinate of the player.
     * 
     * @return The starting Y coordinate of the player.
     */
    public int getStartingY() {
        return startingY;
    }

    /**
     * Retrieves a matrix-like representation of the map data.
     * The returned list is unmodifiable to prevent modification of the map data.
     * 
     * @return A matrix-like representation of the map data.
     */
    public List<List<Integer>> getData() {
        return Collections.unmodifiableList(data);
    }

    /**
     * Loads map data from a JSON file.
     * 
     * @param path the path that points to the map file.
     * @return A MapData object representing the loaded map data.
     * @throws IllegalStateException When an error occurs while loading map data.
     */
    public static MapData loadFromJson(final String path) {
        try (InputStream inputStream = MapData.class.getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            final Gson gson = new Gson();
            final MapData mapData = gson.fromJson(reader, MapData.class);
            if (mapData == null) {
                throw new IllegalStateException("No MapData found in: " + path);
            }
            return mapData;
        } catch (final IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            throw new IllegalStateException("Error loading map data from: " + path, e);
        }
    }
}
