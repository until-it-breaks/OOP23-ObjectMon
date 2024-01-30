package it.unibo.objectmon.model.item.inventory.api;

import it.unibo.objectmon.model.item.api.Item;

/**
 * Models the player Inventory.
 */
public interface Inventory {

    /**
     * add items in the inventory.
     * @param item item to be added
     */
    void addItem(Item item);

    /**
     * remove items by the inventory.
     * @param item item to be removed
     */
    void removeItem(Item item);

    /**
     * count each item.
     * @param item item to count
     * @return counter of one item
     */
    int getItemCount(Item item);
}
