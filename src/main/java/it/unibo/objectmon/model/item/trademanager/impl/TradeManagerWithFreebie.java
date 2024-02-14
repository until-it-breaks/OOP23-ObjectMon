package it.unibo.objectmon.model.item.trademanager.impl;

import java.util.Map;
import java.util.HashMap;

import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;

public class TradeManagerWithFreebie implements TradeManager {

    private final TradeManager tradeManager;
    private final int freebieTrigger;
    private final Map<Item, Integer> itemCountMap;

    public TradeManagerWithFreebie(final TradeManager tradeManager, final int freebieTrigger) {
        this.tradeManager = tradeManager;
        this.freebieTrigger = freebieTrigger;
        this.itemCountMap = new HashMap<>();
    }

    @Override
    public void startTrade() {
        tradeManager.startTrade();
    }

    @Override
    public void stopTrade() {
        tradeManager.stopTrade();   
    }

    @Override
    public boolean buyItem(Player player, Item item) {
        if (tradeManager.buyItem(player, item)) {
            final int count = itemCountMap.getOrDefault(item, 0) + 1;
            itemCountMap.put(item, count);
            if (count % freebieTrigger == 0) {
                player.getInventory().addItem(item, 1);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean sellItem(Player player, Item item) {
        return tradeManager.sellItem(player, item);
    }
    
}
