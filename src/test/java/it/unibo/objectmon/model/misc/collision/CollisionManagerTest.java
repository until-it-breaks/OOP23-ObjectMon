package it.unibo.objectmon.model.misc.collision;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import java.util.HashSet;

import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.npc.HealerImpl;
import it.unibo.objectmon.model.entities.npc.VendorImpl;
import it.unibo.objectmon.model.misc.collision.api.CollisionManager;
import it.unibo.objectmon.model.world.Tile;
import it.unibo.objectmon.model.world.WorldImpl;
import it.unibo.objectmon.model.world.api.Coord;
import it.unibo.objectmon.model.world.api.World;
import it.unibo.objectmon.model.world.api.Worlds;

/**
 * Unit tests for the {@link CollisionManagerImpl} class.
 */
class CollisionManagerTest {

    private World world;
    private CollisionManager collisionChecker;

    @BeforeEach
    void init() {
        world = new WorldImpl(Worlds.DEMO);
        final Set<AbstractNPC> npcs =  new HashSet<>(Set.of(
            new VendorImpl("Bob", new Coord(0, 0)),
            new HealerImpl("Semple", new Coord(2, 2))
            ));
        collisionChecker = new CollisionManagerImpl(world, npcs);
    }

    @Test 
    void testCollision() {
        assertTrue(collisionChecker.isCollision(new Coord(0, 0)));
        assertTrue(collisionChecker.isCollision(new Coord(2, 2)));
        assertFalse(collisionChecker.isCollision(new Coord(0, 1)));
    }

    @Test
    void testWorldBoundaries() {
        Tile tile = world.getMap().get(new Coord(world.getWidth() - 1, world.getHeight() - 1));
        assertEquals(!tile.isPassable(), collisionChecker.isCollision(new Coord(world.getWidth() - 1, world.getHeight() - 1)));
        tile = world.getMap().get(new Coord(0, 0));
        assertEquals(tile.isPassable(), collisionChecker.isCollision(new Coord(0, 0)));
    }

    @Test
    void testNullTile() {
        final Tile tile = world.getMap().get(new Coord(world.getWidth(), world.getHeight()));
        assertEquals(null, tile);
        assertTrue(collisionChecker.isCollision(new Coord(world.getWidth(), world.getHeight())));
    }
}
