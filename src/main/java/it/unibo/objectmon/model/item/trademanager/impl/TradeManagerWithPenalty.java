package it.unibo.objectmon.model.item.trademanager.impl;

import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;

public class TradeManagerWithPenalty implements TradeManager {

    private final TradeManager tradeManager;
    private final double penaltyRatio;

    public TradeManagerWithPenalty(final double penaltyRatio, final TradeManager tradeManager) {
        this.tradeManager = tradeManager;
        this.penaltyRatio = penaltyRatio;
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
       return tradeManager.buyItem(player, item);
    }

    @Override
    public boolean sellItem(Player player, Item item) {
        if (tradeManager.sellItem(player, item)) {
            player.getInventory().withdrawCredits((int) (item.getValue() * penaltyRatio));
            return true;
        }
        return false;
    }
    
}
