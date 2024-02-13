package it.unibo.objectmon.model.item.inventory.api;

import java.util.Map;

import it.unibo.objectmon.model.battle.api.Battle;
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
     * Consume an item of the inventory.
     * @param <T> The type of item to be used. Must be a subtype of {@link Item}
     * @param item item to be used
     * @return True if the item is present and successfully used
     */
    <T extends Item> boolean useItem(T item);

    /**
     * Returns number of heal items in the inventory.
     * @return heal count
     */
    int getHealItemCount();

    /**
     * Returns number of ball items in the inventory.
     * @return ball count
     */
    int getBallItemCount();

    /**
     * Returns number of total items in the inventory.
     * @return total item count
     */
    int getTotalItemCount();

    /**
     * Returns the map of items.
     * @return a map of items
     */
    Map<Item, Integer> getItems();

    /**
     * Clears the inventory.
     */
    void clear();

    /**
     * Returns the total value of the inventory.
     * @return total inventory value
     */
    int getInventoryValue();

    int getCredits();

    int addCredits();

    boolean withdrawCredits(int amount);
}
