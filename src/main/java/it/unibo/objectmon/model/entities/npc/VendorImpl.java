package it.unibo.objectmon.model.entities.npc;

import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Seller;
import it.unibo.objectmon.model.misc.eventlog.api.InteractionLogger;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * Models an NPC capable of selling its own wares.
 */
public final class VendorImpl extends AbstractNPC implements Seller {

    /**
     * Constructs a new Seller NPC.
     * 
     * @param name The name of the seller.
     * @param coord The starting position of the seller.
     */
    public VendorImpl(final String name, final Coord coord) {
        super(name, coord);
    }

    @Override
    public void handleInteraction(final Player player, final InteractionLogger logger) {
        logger.log(this.getName() + " has started trading with " + player.getName());
        this.trade();
    }

    @Override
    public void trade() {
    }
}
