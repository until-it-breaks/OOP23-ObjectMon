package it.unibo.objectmon.model.entities.npc;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.data.api.statistics.StatId;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Healer;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.misc.eventlog.api.InteractionLogger;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * Models an NPC capable of healing the Player's team.
 */
public final class HealerImpl extends AbstractNPC implements Healer {

    /**
     * Constructs a new Healer NPC.
     * 
     * @param name The name of the healer NPC.
     * @param coord The starting position of the healer NPC.
     */
    public HealerImpl(final String name, final Coord coord) {
        super(name, coord);
    }

    @Override
    public void handleInteraction(final Player player, final InteractionLogger logger) {
        logger.log(this.getName() + " has healed " + player.getName() + "'s party completely.");
        this.healTeam(player.getObjectmonParty());
    }

    @Override
    public void healTeam(final ObjectmonParty team) {
        for (final var objectmon : team.getParty()) {
            objectmon.setCurrentHp(objectmon.getStats().getSingleStat(StatId.HP));
        }
    }
}
