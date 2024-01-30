package it.unibo.objectmon.model.item.api;

/**
 * Item interface models a player usable item.
 */
public interface Item {
    
    /**
     * returns the item name.
     * @return itemName
     */
    String getName();

    /**
     * return the item value.
     * @return itemValue
     */
    int getValue();

}
