package it.unibo.objectmon.model.item.trademanager.api;

import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.inventory.api.Inventory;

/**
 * Models the TRADE mode.
 */
public interface TradeManager {

    /**
     * Allows a player to buy an item during a trade session.
     * @param inventory the inventory which contains the item to be sold
     * @param item the item being bought
     * @return true if the transaction is successfull, false otherwise
     */
    boolean buyItem(Inventory inventory, Item item);

    /**
     * Allows a player to sell an item during a trade session.
     * @param inventory the inventory which contains the item to be sold
     * @param item the item being sold
     * @return true if the transaction is successfull, false otherwise
     */
    boolean sellItem(Inventory inventory, Item item);
}
