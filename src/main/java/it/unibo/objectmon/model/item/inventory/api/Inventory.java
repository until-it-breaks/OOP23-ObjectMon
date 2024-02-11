package it.unibo.objectmon.model.item.inventory.api;

import java.util.Map;

import it.unibo.objectmon.model.item.api.Item;

/**
 * Models the player Inventory.
 */
public interface Inventory {

    /**
     * add items in the inventory.
     * @param item item to be added
     * @param count count of items
     */
    void addItem(Item item, int count);

    /**
     * uses item of the inventory.
     * @param <T>
     * @param item item to be used
     */
    <T extends Item> void useItem(T item);

    /**
     * Returns number of heal items.
     * @return heal count
     */
    int getHealItemCount();

    /**
     * Returns number of ball items.
     * @return ball count
     */
    int getBallItemCount();

    /**
     * Returns number of items.
     * @return item count
     */
    int getTotalItemCount();

    /**
     * Returns unmodifiable list of items.
     * @return items list
     */
    Map<Item, Integer> getItems();

    /**
     * Clears keys and values by map.
     */
    void clear();

    /**
     * Returns inventory value by stream.
     * @return inventory value
     */
    int getInventoryValue();
}
