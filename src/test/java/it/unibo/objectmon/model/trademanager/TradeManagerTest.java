package it.unibo.objectmon.model.trademanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.core.GameContext;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.gamestate.GameStateManager;
import it.unibo.objectmon.model.item.api.BallEnum;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.impl.BallItemImpl;
import it.unibo.objectmon.model.item.inventory.api.Inventory;
import it.unibo.objectmon.model.item.inventory.impl.InventoryImpl;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;
import it.unibo.objectmon.model.item.trademanager.impl.TradeManagerImpl;

class TradeManagerTest {
    
    private TradeManager tradeManager;
    private GameStateManager gameStateManager;
    private GameContext gameContext;
    private Inventory inventory;
    
    @BeforeEach
    void init() {
        inventory = new InventoryImpl(1000);
        tradeManager = new TradeManagerImpl(gameStateManager);
    }

    @Test
    void testStartTrade() {
        
    }

    @Test
    void testStopTrade() {
        
    }

    @Test
    void testBuyItem() {
        final Item item = new BallItemImpl(BallEnum.OBJECTBALL);
        System.out.println("prova " + inventory.getCredits() + " roo " + inventory.getBallItemCount());
        assertEquals(1000, inventory.getCredits());
        assertEquals(0, inventory.getBallItemCount());
        tradeManager.buyItem(gameContext.getPlayer(), item);
        assertEquals(1, inventory.getBallItemCount());
        assertEquals(750, inventory.getCredits());
    }

    @Test
    void testSellItem() {
        
    }


    
}
