package it.unibo.objectmon.model.entities.npc;

import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Seller;
import it.unibo.objectmon.model.item.trademanager.api.TradeInitiator;
import it.unibo.objectmon.model.misc.eventlog.api.InteractionLogger;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * Models an NPC capable of selling and buying items.
 */
public final class VendorImpl extends AbstractNPC implements Seller {

    private final TradeInitiator tradeInitiator;

    /**
     * Creates a new Seller NPC.
     * 
     * @param name The name of the seller.
     * @param coord The starting position of the seller.
     * @param tradeInitiator The notifier of a trade session start.
     */
    public VendorImpl(final String name, final Coord coord, final TradeInitiator tradeInitiator) {
        super(name, coord);
        this.tradeInitiator = tradeInitiator;
    }

    @Override
    public void handleInteraction(final Player player, final InteractionLogger logger) {
        logger.log(this.getName() + " has started trading with " + player.getName());
        this.trade();
    }

    @Override
    public void trade() {
        tradeInitiator.startTrade();
    }
}
