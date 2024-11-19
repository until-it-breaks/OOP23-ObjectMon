package it.unibo.objectmon.model.item.api;

/**
 * Models a player usable item.
 */
public interface Item {

    /**
     * Retrieves the item's name.
     * 
     * @return The item's name.
     */
    String getName();

    /**
     * Retrieves the item's value.
     * 
     * @return The item's value.
     */
    int getValue();
}
