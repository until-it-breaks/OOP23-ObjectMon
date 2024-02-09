package it.unibo.objectmon.model.entities.npc;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.npc.AbstractNPC;
import it.unibo.objectmon.model.entities.api.npc.Healer;
import it.unibo.objectmon.model.misc.eventlog.api.EventLogger;
import it.unibo.objectmon.model.world.Coord;

/**
 * Models an NPC capable of healing the Player's team.
 */
public final class HealerNPCImpl extends AbstractNPC implements Healer {

    /**
     * Constructs a new Healer NPC.
     * 
     * @param name The name of the healer NPC.
     * @param coord The starting position of the healer NPC.
     */
    public HealerNPCImpl(final String name, final Coord coord) {
        super(name, coord);
    }

    @Override
    public void handleInteraction(final Player player, final EventLogger logger) {
        logger.log("Player's team has been healed");
        this.healTeam(player.getObjectmonParty());
    }

    @Override
    public void healTeam(final ObjectmonParty team) {
    }
}
