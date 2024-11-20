package it.unibo.objectmon.model.entities.npc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.battle.api.BattleInitiator;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.item.trademanager.api.TradeInitiator;
import it.unibo.objectmon.model.misc.eventlog.api.InteractionLogger;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * Tests for NPC behaviour.
 */
class TestNPC {

    @Test
    void testHealerInteraction() {
        final Player player = mock(Player.class);
        final InteractionLogger logger = mock(InteractionLogger.class);
        final HealerImpl healer = new HealerImpl("Healer1", new Coord(0, 0));
        final ObjectmonParty party = mock(ObjectmonParty.class);
        when(player.getObjectmonParty()).thenReturn(party);
        healer.handleInteraction(player, logger);
        verify(logger).log("Healer1 has healed " + player.getName() + "'s party completely.");
    }

    @Test
    void testTrainerInteractionDefeated() {
        final Player player = mock(Player.class);
        final InteractionLogger logger = mock(InteractionLogger.class);
        final TrainerImpl trainer = new TrainerImpl("Trainer1", new Coord(0, 0), List.of(), mock(BattleInitiator.class));
        trainer.handleInteraction(player, logger);
        verify(logger).log("Trainer1 has already been defeated.");
    }

    @Test
    void testVendorInteraction() {
        final Player player = mock(Player.class);
        final InteractionLogger logger = mock(InteractionLogger.class);
        final TradeInitiator tradeInitiator = mock(TradeInitiator.class);
        final VendorImpl vendor = new VendorImpl("Vendor1", new Coord(0, 0), tradeInitiator);
        vendor.handleInteraction(player, logger);
        verify(tradeInitiator).tradeStarted();
    }
}
