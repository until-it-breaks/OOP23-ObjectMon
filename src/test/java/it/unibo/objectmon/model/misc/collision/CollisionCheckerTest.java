package it.unibo.objectmon.model.misc.collision;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import java.util.HashSet;
import it.unibo.objectmon.model.entities.api.npc.AbstractNPC;
import it.unibo.objectmon.model.entities.npc.HealerNPCImpl;
import it.unibo.objectmon.model.entities.npc.SellerNPCImpl;
import it.unibo.objectmon.model.misc.collision.api.CollisionChecker;
import it.unibo.objectmon.model.world.Coord;
import it.unibo.objectmon.model.world.Tile;
import it.unibo.objectmon.model.world.World;
import it.unibo.objectmon.model.world.Worlds;

/**
 * Unit tests for the {@link CollisionCheckerImpl} class.
 */
class CollisionCheckerTest {

    private World world;
    private CollisionChecker collisionChecker;

    @BeforeEach
    void init() {
        world = new World(Worlds.DEMO);
        final Set<AbstractNPC> npcs =  new HashSet<>(Set.of(
            new SellerNPCImpl("Bob", new Coord(0, 0)),
            new HealerNPCImpl("Semple", new Coord(2, 2))
            ));
        collisionChecker = new CollisionCheckerImpl(world, npcs);
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
