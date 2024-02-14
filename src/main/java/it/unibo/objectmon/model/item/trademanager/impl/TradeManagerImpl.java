package it.unibo.objectmon.model.item.trademanager.impl;

import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.gamestate.GameStateManager;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;

/**
 * Models TRADE mode.
 */
public final class TradeManagerImpl implements TradeManager {

    private final GameStateManager gameStateManager;

    /**
     * Construct basic trade manager.
     * @param gameStateManager game state manager
     */
    public TradeManagerImpl(final GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    @Override
    public void startTrade() {
        gameStateManager.setGameState(GameState.TRADE);
    }

    @Override
    public void stopTrade() {
        gameStateManager.setGameState(GameState.EXPLORATION);
    }

    @Override
    public boolean buyItem(final Player player, final Item item) {
        if (isTradeSession()) {
            if (player.getInventory().withdrawCredits(item.getValue())) {
                player.getInventory().addItem(item, 1);
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalStateException("Cannot buy an item outside of a trade session.");
        }
    }

    @Override
    public boolean sellItem(final Player player, final Item item) {
        if (isTradeSession()) {
            if (player.getInventory().useItem(item)) {
                player.getInventory().addCredits(item.getValue());
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalStateException("Cannot sell an item outside of a trade session.");
        }
    }

    private boolean isTradeSession() {
        return gameStateManager.getGameState() == GameState.TRADE;
    }
}
