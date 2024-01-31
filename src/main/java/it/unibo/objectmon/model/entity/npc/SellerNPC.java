package it.unibo.objectmon.model.entity.npc;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import it.unibo.objectmon.model.entity.PlayerManager;
import it.unibo.objectmon.model.entity.npc.api.Seller;
import it.unibo.objectmon.model.world.Coord;
/**
 * Models an NPC capable of selling its own wares.
 */
public final class SellerNPC extends AbstractNPC implements Seller {

    private final Set<Object> inventory;

    /**
     * Constructs a new Seller NPC.
     * @param name The name of the seller.
     * @param coord The starting position of the seller.
     * @param inventory The available wares of the seller.
     */
    public SellerNPC(final String name, final Coord coord, final Set<Object> inventory) {
        super(name, coord);
        this.inventory = new LinkedHashSet<>(Collections.unmodifiableSet(inventory));
    }

    @Override
    public void handleInteraction(final PlayerManager player) {
        //Says something like "Trading started".
        //Calls a trade manager
    }

    @Override
    public Set<Object> getInventory() {
        return Collections.unmodifiableSet(this.inventory);
    }
}
