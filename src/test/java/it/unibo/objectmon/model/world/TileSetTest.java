package it.unibo.objectmon.model.world;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link TileSet} class.
 */
class TileSetTest {

    @Test
    void testLoadFromJson() {
        final TileSet tileSet = new TileSet("/world/atlas.json");
        assertNotNull(tileSet.getTileAtlas());
    }
}
