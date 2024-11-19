package it.unibo.objectmon.model.item.inventory.api;

import java.util.Map;

import it.unibo.objectmon.model.item.api.Item;

/**
 * Models the player's inventory.
 */
public interface Inventory {

    /**
     * Adds items to the inventory.
     * 
     * @param item The item to be added.
     * @param count The amount to be added.
     */
    void addItem(Item item, int count);

    /**
     * Consumes an item in the inventory.
     * 
     * @param <T> The type of item to be used. Must be a subtype of {@link Item}.
     * @param item The item to be used.
     * @return true if the item is present and successfully used, false otherwise.
     */
    <T extends Item> boolean useItem(T item);

    /**
     * Retrieves the amount of healing items in the inventory.
     * 
     * @return The amount of healing items.
     */
    int getHealingItemCount();

    /**
     * Retrieves number of objectballs in the inventory.
     * 
     * @return The amount of objectballs.
     */
    int getObjectballCount();

    /**
     * Retrieves the total amount of items in the inventory.
     * 
     * @return The total item count.
     */
    int getTotalItemCount();

    /**
     * Retrieves a map of the items.
     * 
     * @return A map of the items.
     */
    Map<Item, Integer> getItems();

    /**
     * Clears the inventory.
     */
    void clear();

    /**
     * Returns the total value of the inventory.
     * 
     * @return The total inventory value.
     */
    int getInventoryValue();

    /**
     * Returns the credits owned by the player.
     * 
     * @return The credits owned.
     */
    int getCredits();

    /**
     * Adds credits.
     * 
     * @param amount The amount to be added.
     * @return true if the operation is performed successfully, false otherwise.
     */
    int addCredits(int amount);

    /**
     * Attempts to withdraw credits to pay items with.
     * 
     * @param amount The amount needed.
     * @return true if the operation is performed successfully, false otherwise.
     */
    boolean withdrawCredits(int amount);
}
