package it.unibo.objectmon.model.item.trademanager.impl;

import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.inventory.api.Inventory;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;

/**
 * Models a trade manager capable of applying penalties for selling items.
 */
public final class TradeManagerWithPenalty implements TradeManager {

    private final TradeManager tradeManager;
    private final double penaltyRatio;

    /**
     * Creates a trade manager with a penalty.
     * 
     * @param penaltyRatio The ratio of credits refunded.
     * @param tradeManager The trade manager.
     */
    public TradeManagerWithPenalty(final double penaltyRatio, final TradeManager tradeManager) {
        this.tradeManager = tradeManager;
        this.penaltyRatio = penaltyRatio;
    }

    @Override
    public boolean buyItem(final Inventory inventory, final Item item) {
       return tradeManager.buyItem(inventory, item);
    }

    @Override
    public boolean sellItem(final Inventory inventory, final Item item) {
        if (tradeManager.sellItem(inventory, item)) {
            inventory.withdrawCredits((int) (item.getValue() * penaltyRatio));
            return true;
        }
        return false;
    }
}
