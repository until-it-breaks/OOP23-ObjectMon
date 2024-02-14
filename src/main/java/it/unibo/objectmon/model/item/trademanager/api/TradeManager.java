package it.unibo.objectmon.model.item.trademanager.api;

import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.item.api.Item;

public interface TradeManager {
    
    /**
     * Starts a trade session.
     */
    void startTrade();

    /**
     * Stops the current trade session.
     */
    void stopTrade();

    /**
     * Allows a player to buy an item during a trade session.
     * @param player the player who is buying the item
     * @param item the item being bought
     * @return true if the transaction is successfull, false otherwise
     */
    boolean buyItem(Player player, Item item);

    /**
     * Allows a player to sell an item during a trade session.
     * @param player the player who is selling the item
     * @param item the item being sold
     * @return true if the transaction is successfull, false otherwise
     */
    boolean sellItem(Player player, Item item);
}
