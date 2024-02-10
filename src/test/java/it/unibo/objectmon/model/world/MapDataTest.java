package it.unibo.objectmon.model.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link MapData} class.
 */
class MapDataTest {

    private static final String DEFAULT_MAP = "/world/map.json";
    private static final int DEFAULT_MAP_WIDTH = 50;
    private static final int DEFAULT_MAP_HEIGHT = 50;
    private static final int DEFAULT_STARTING_X = 25;
    private static final int DEFAULT_STARTING_Y = 25;


    @Test
    void testLoadFromJson() {
        final MapData mapData = MapData.loadFromJson(DEFAULT_MAP);
        assertNotNull(mapData);
    }

    @Test
    void testGetters() {
        final MapData mapData = MapData.loadFromJson(DEFAULT_MAP);
        assertNotNull(mapData);
        assertEquals(DEFAULT_MAP_HEIGHT, mapData.getHeight());
        assertEquals(DEFAULT_MAP_WIDTH, mapData.getWidth());
        assertEquals(DEFAULT_STARTING_X, mapData.getStartingX());
        assertEquals(DEFAULT_STARTING_Y, mapData.getStartingY());
    }
}
