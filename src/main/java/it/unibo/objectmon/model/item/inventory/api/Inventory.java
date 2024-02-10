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
     */
    void addItem(Item item, int count);

    <T extends Item> void useItem(T item);

    int getHealItemCount();

    int getBallItemCount();

    int getTotalItemCount();

    Map<Item, Integer> getItems();

    void Clear();

    int getInventoryValue();
}
