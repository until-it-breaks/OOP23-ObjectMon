package it.unibo.objectmon.model.entity.npc;

import it.unibo.objectmon.model.entity.PlayerManager;
import it.unibo.objectmon.model.entity.npc.api.Seller;
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
    public void handleInteraction(final PlayerManager player) {
        //Says something like "Trading started".
        //Calls a trade manager
    }

    @Override
    public void trade() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'trade'");
    }
}
