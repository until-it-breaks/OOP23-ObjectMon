package it.unibo.objectmon.model.entities.api;

import it.unibo.objectmon.model.misc.eventlog.api.InteractionLogger;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * Models an NPCS with a behaviour that can be triggered on interaction.
 */
public abstract class AbstractNPC extends AbstractEntity {

    /**
     * Creates an incomplete NPC.
     * 
     * @param name The NPC's name.
     * @param coord The NPC's position.
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
    public abstract void handleInteraction(Player player, InteractionLogger logger);

}
