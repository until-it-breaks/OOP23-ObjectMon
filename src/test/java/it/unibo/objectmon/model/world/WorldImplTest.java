package it.unibo.objectmon.model.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.world.api.Coord;
import it.unibo.objectmon.model.world.api.Worlds;

/**
 * Tests for {@link WorldImpl}.
 */
class WorldImplTest {
    private WorldImpl world;

    @BeforeEach
    public void init() {
        final Worlds config = Worlds.DEMO;
        world = new WorldImpl(config);
    }

    @Test
    void testMapLoading() {
        final Map<Coord, Tile> map = world.getMap();
        assertNotNull(map, "Map should not be null");
    }

    /**
     * Check if the world has tiles that trigger encounters.
     */
    @Test
    void testTilesTriggerEncounters() {
        final Map<Coord, Tile> map = world.getMap();
        boolean foundTileWithEncounters = false;
        for (final Tile tile : map.values()) {
            if (tile.isTriggersEncounters()) {
                foundTileWithEncounters = true;
                break;
            }
        }
        assertTrue(foundTileWithEncounters, "No tiles found that trigger encounters");
    }

    /**
     * Check if the amount of tiles is in line with the declared height times the width of the map.
     * Additionally none must be null.
     */
    @Test
    void testTilesCount() {
        final Map<Coord, Tile> map = world.getMap();
        final int expectedNumberOfTiles = world.getWidth() * world.getHeight();
        assertEquals(expectedNumberOfTiles, map.size(), "Number of tiles loaded does not match the expected number");
        boolean foundNullTile = false;
        for (final Tile tile : map.values()) {
            if (tile == null) {
                foundNullTile = true;
                break;
            }
        }
        assertFalse(foundNullTile, "Found null tile in the map");
    }
}
