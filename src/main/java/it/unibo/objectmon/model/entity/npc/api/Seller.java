package it.unibo.objectmon.model.entity.npc.api;

import java.util.Set;

/**
 * Models a seller NPC.
 */
public interface Seller {

    /**
     * Retrieves the NPC available wares.
     * @return the set of item the npc is able to sell.
     */
    Set<Object> getInventory();    //Object a temporary stub.
}
