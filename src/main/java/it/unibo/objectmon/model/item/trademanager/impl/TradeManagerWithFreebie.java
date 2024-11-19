package it.unibo.objectmon.model.item.trademanager.impl;

import java.util.Map;
import java.util.HashMap;

import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.inventory.api.Inventory;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;

/**
 * Models a trade manager with capable of giving away freebies when many items of the same kind are bought.
 */
public final class TradeManagerWithFreebie implements TradeManager {

    private final TradeManager tradeManager;
    private final int freebieTrigger;
    private final Map<Item, Integer> itemCountMap;

    /**
     * Creates a trade manager that allows freebies.
     * 
     * @param freebieTrigger The item count required.
     * @param tradeManager The trade manager
     */
    public TradeManagerWithFreebie(final int freebieTrigger, final TradeManager tradeManager) {
        this.tradeManager = tradeManager;
        this.freebieTrigger = freebieTrigger;
        this.itemCountMap = new HashMap<>();
    }

    @Override
    public boolean buyItem(final Inventory inventory, final Item item) {
        if (tradeManager.buyItem(inventory, item)) {
            final int count = itemCountMap.getOrDefault(item, 0) + 1;
            itemCountMap.put(item, count);
            if (count % freebieTrigger == 0) {
                inventory.addItem(item, 1);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean sellItem(final Inventory inventory, final Item item) {
        return tradeManager.sellItem(inventory, item);
    }
}
