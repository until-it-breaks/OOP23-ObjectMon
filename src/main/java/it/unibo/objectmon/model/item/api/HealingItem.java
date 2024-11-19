package it.unibo.objectmon.model.item.api;

/**
 * Models a tool used to heal objectmons.
 */
public interface HealingItem extends Item {

    /**
     * Retrieves the amount of HP that the item can restore.
     * 
     * @return The amount of HP the item can restore.
     */
    int getHealedHPs();
}
