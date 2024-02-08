package it.unibo.objectmon.model.entity.npc;

import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.api.npc.AbstractNPC;
import it.unibo.objectmon.model.entity.api.npc.Seller;
import it.unibo.objectmon.model.misc.eventlog.EventLogger;
import it.unibo.objectmon.model.world.Coord;
/**
 * Models an NPC capable of selling its own wares.
 */
public final class SellerNPC extends AbstractNPC implements Seller {

    /**
     * Constructs a new Seller NPC.
     * @param name The name of the seller.
     * @param coord The starting position of the seller.
     */
    public SellerNPC(final String name, final Coord coord) {
        super(name, coord);
    }

    @Override
    public void handleInteraction(final Player player) {
        EventLogger.getLogger().log("Trade started with player");
        this.trade();
    }

    @Override
    public void trade() {
    }
}
