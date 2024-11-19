package it.unibo.objectmon.model.item.trademanager.impl;

import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.inventory.api.Inventory;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;

/**
 * Models a manager responsible for the TRADE mode.
 */
public final class TradeManagerImpl implements TradeManager {

    @Override
    public boolean buyItem(final Inventory inventory, final Item item) {
        if (inventory.withdrawCredits(item.getValue())) {
            inventory.addItem(item, 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sellItem(final Inventory inventory, final Item item) {
        if (inventory.useItem(item)) {
            inventory.addCredits(item.getValue());
            return true;
        } else {
            return false;
        }
    }
}
