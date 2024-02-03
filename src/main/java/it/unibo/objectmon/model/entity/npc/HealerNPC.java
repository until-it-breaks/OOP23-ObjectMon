package it.unibo.objectmon.model.entity.npc;

import java.util.Set;
import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.model.entity.PlayerManager;
import it.unibo.objectmon.model.entity.npc.api.Healer;
import it.unibo.objectmon.model.eventlog.EventLogger;
import it.unibo.objectmon.model.world.Coord;

/**
 * Models an NPC capable of healing the Player's team.
 */
public final class HealerNPC extends AbstractNPC implements Healer {

    /**
     * Constructs a new Healer NPC.
     * @param name The name of the healer NPC.
     * @param coord The starting position of the healer NPC.
     */
    public HealerNPC(final String name, final Coord coord) {
        super(name, coord);
    }

    @Override
    public void handleInteraction(final PlayerManager player) {
        EventLogger.getLogger().log("Player's team has been healed");
        this.healTeam(player.getTeam());
    }

    @Override
    public void healTeam(final Set<Objectmon> team) {
        //Heals all the objectmons in the player party.
    }
}
