package it.unibo.objectmon.model.misc.interaction;

import java.util.Set;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.HashSet;

import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Direction;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.npc.HealerImpl;
import it.unibo.objectmon.model.entities.npc.VendorImpl;
import it.unibo.objectmon.model.entities.player.PlayerImpl;
import it.unibo.objectmon.model.item.trademanager.api.TradeInitiator;
import it.unibo.objectmon.model.misc.interaction.api.InteractionManager;
import it.unibo.objectmon.model.world.api.Coord;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link InteractionManagerImpl} class.
*/
class TestInteractionManager {

    private InteractionManager interactionManager;
    private Set<AbstractNPC> npcs;
    private Player player;

    @BeforeEach
    void init() {
        interactionManager = new InteractionManagerImpl();
        npcs = new HashSet<>();
        npcs.add(new VendorImpl("Beta", new Coord(1, 0), mock(TradeInitiator.class)));
        npcs.add(new HealerImpl("Alpha", new Coord(4, 4)));
        player = new PlayerImpl("Player", new Coord(0, 0), List.of());
    }

    @Test
    void testTriggerInteraction() {
        player.setPosition(new Coord(0, 0));
        player.setDirection(Direction.RIGHT);
        //There is an NPC to the right.
        assertTrue(interactionManager.triggerInteraction(npcs, player));
        player.setDirection(Direction.LEFT);
        //There isn't one at the left.
        assertFalse(interactionManager.triggerInteraction(npcs, player));
    }

    @Test
    void testStacked() {
        player.setPosition(new Coord(4, 4));
        player.setDirection(Direction.RIGHT);
        assertFalse(interactionManager.triggerInteraction(npcs, player));
        player.setDirection(Direction.LEFT);
        assertFalse(interactionManager.triggerInteraction(npcs, player));
        player.setDirection(Direction.DOWN);
        assertFalse(interactionManager.triggerInteraction(npcs, player));
        player.setDirection(Direction.UP);
        assertFalse(interactionManager.triggerInteraction(npcs, player));
    }
}
