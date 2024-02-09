package it.unibo.objectmon.model.entities.npc;

import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.npc.AbstractNPC;
import it.unibo.objectmon.model.entities.api.npc.Seller;
import it.unibo.objectmon.model.misc.eventlog.api.EventLogger;
import it.unibo.objectmon.model.world.Coord;

/**
 * Models an NPC capable of selling its own wares.
 */
public final class SellerNPCImpl extends AbstractNPC implements Seller {

    /**
     * Constructs a new Seller NPC.
     * 
     * @param name The name of the seller.
     * @param coord The starting position of the seller.
     */
    public SellerNPCImpl(final String name, final Coord coord) {
        super(name, coord);
    }

    @Override
    public void handleInteraction(final Player player, final EventLogger logger) {
        logger.log("Trade started with player");
        this.trade();
    }

    @Override
    public void trade() {
    }
}
