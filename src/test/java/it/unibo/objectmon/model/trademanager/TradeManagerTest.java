package it.unibo.objectmon.model.trademanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.gamestate.GameStateManager;
import it.unibo.objectmon.model.gamestate.GameStateManagerImpl;
import it.unibo.objectmon.model.item.api.BallEnum;
import it.unibo.objectmon.model.item.api.HealEnum;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.impl.BallItemImpl;
import it.unibo.objectmon.model.item.impl.HealItemImpl;
import it.unibo.objectmon.model.item.inventory.api.Inventory;
import it.unibo.objectmon.model.item.inventory.impl.InventoryImpl;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;
import it.unibo.objectmon.model.item.trademanager.impl.TradeManagerImpl;
import it.unibo.objectmon.model.item.trademanager.impl.TradeManagerWithPenalty;

class TradeManagerTest {

    private TradeManager tradeManager;
    private GameStateManager gameStateManager;
    private Inventory inventory;

    @BeforeEach
    void init() {
        inventory = new InventoryImpl(1000);
        tradeManager = new TradeManagerWithPenalty(0.5, new TradeManagerImpl());
        gameStateManager = new GameStateManagerImpl();
    }

    @Test
    void testBuyItem() {
        gameStateManager.setGameState(GameState.TRADE);
        final Item item = new BallItemImpl(BallEnum.OBJECTBALL);
        assertEquals(1000, inventory.getCredits());
        assertEquals(0, inventory.getBallItemCount());
        tradeManager.buyItem(inventory, item);
        assertEquals(1, inventory.getBallItemCount());
        assertEquals(750, inventory.getCredits());
    }

    @Test
    void testSellItem() {
        gameStateManager.setGameState(GameState.TRADE);
        final Item item = new HealItemImpl(HealEnum.HYPERPOTION);
        inventory.addItem(item, 2);
        assertEquals(1000, inventory.getCredits());
        assertEquals(2, inventory.getHealItemCount());
        tradeManager.sellItem(inventory, item);
        assertEquals(1, inventory.getHealItemCount());
        assertEquals(1100, inventory.getCredits());
    }
}
