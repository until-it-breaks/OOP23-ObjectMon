package it.unibo.objectmon.model.item.trademanager.impl;

import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;

/**
 * Models TRADE mode.
 */
public final class TradeManagerImpl implements TradeManager {

    @Override
    public boolean buyItem(final Player player, final Item item) {
            if (player.getInventory().withdrawCredits(item.getValue())) {
                player.getInventory().addItem(item, 1);
                return true;
            } else {
                return false;
            }
    }

    @Override
    public boolean sellItem(final Player player, final Item item) {
        if (player.getInventory().useItem(item)) {
            player.getInventory().addCredits(item.getValue());
            return true;
        } else {
            return false;
        }
    }
}
