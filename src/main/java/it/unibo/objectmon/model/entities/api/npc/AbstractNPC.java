package it.unibo.objectmon.model.entities.api.npc;

import it.unibo.objectmon.model.entities.api.EntityImpl;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.misc.eventlog.api.EventLogger;
import it.unibo.objectmon.model.world.Coord;

/**
 * Models an npc with a behaviour that can be triggered on interaction.
 */
public abstract class AbstractNPC extends EntityImpl {

    /**
     * Constructs an incomplete NPC.
     * @param name the npc name
     * @param coord the npc position
     */
    public AbstractNPC(final String name, final Coord coord) {
        super(name, coord);
    }

    /**
     * Triggers the NPC specific behaviour after performing checks.
     * 
     * @param player The player that is affected by the interaction.
     * @param logger The logger on which interaction outputs are logged.
     */
    public abstract void handleInteraction(Player player, EventLogger logger);
}
