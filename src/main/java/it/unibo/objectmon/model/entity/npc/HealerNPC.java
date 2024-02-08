package it.unibo.objectmon.model.entity.npc;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.api.npc.AbstractNPC;
import it.unibo.objectmon.model.entity.api.npc.Healer;
import it.unibo.objectmon.model.misc.eventlog.EventLogger;
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
    public void handleInteraction(final Player player) {
        EventLogger.getLogger().log("Player's team has been healed");
        this.healTeam(player.getObjectmonParty());
    }

    @Override
    public void healTeam(final ObjectmonParty team) {
    }
}
