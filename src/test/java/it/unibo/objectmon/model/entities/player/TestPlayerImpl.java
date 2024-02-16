package it.unibo.objectmon.model.entities.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;
import it.unibo.objectmon.model.entities.api.Direction;
import it.unibo.objectmon.model.misc.collision.api.CollisionManager;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * Tests for {@link PlayerImpl}.
 */
class TestPlayerImpl {

    private PlayerImpl player;

    @BeforeEach
    void init() {
        player = new PlayerImpl("Player1", new Coord(0, 0), new ArrayList<>());
    }
    @Test
    void testMoveWithoutCollision() {
        // Create a mock CollisionManager that always returns false for isCollision
        final CollisionManager collisionManager = mock(CollisionManager.class);
        when(collisionManager.isCollision(any())).thenReturn(false);
        player.move(Direction.UP, collisionManager);
        // Assert that the player has moved to the correct position, -1 because rendering Y axis is flipped.
        assertEquals(new Coord(0, -1), player.getPosition());
    }

    @Test
    void testMoveWithCollision() {
        // Create a mock CollisionManager that always returns true for isCollision
        final CollisionManager collisionManager = mock(CollisionManager.class);
        when(collisionManager.isCollision(any())).thenReturn(true);
        player.move(Direction.UP, collisionManager);
        // Assert that the player remains in the same position
        assertEquals(new Coord(0, 0), player.getPosition());
    }

    @Test
    void testIsDefeatedTrue() {
        final PlayerImpl player = new PlayerImpl("Player1", new Coord(0, 0), List.of());
        // Assert that the player is defeated
        assertTrue(player.isDefeated());
    }

    @Test
    void testIsDefeatedFalse() {
        final Objectmon objectmon = ObjectmonFactory.createObjectmon(ObjectmonEnum.ODDISH, 3);
        player = new PlayerImpl("Player1", new Coord(0, 0), List.of(objectmon));
        // Assert that the player is not defeated
        assertFalse(player.isDefeated());
        player.getObjectmonParty().getParty().get(0).setCurrentHp(0);
        assertFalse(player.isDefeated());
    }
}
