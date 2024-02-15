package it.unibo.objectmon.model.trademanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    private static final int INITIAL_AMOUNT = 1000;
    private static final int EXPECTED_1 = 750;
    private static final int EXPECTED_2 = 1100;
    private TradeManager tradeManager;
    private Inventory inventory;

    @BeforeEach
    void init() {
        inventory = new InventoryImpl(1000);
        tradeManager = new TradeManagerWithPenalty(0.5, new TradeManagerImpl());
    }

    @Test
    void testBuyItem() {
        final Item item = new BallItemImpl(BallEnum.OBJECTBALL);
        assertEquals(INITIAL_AMOUNT, inventory.getCredits());
        assertEquals(0, inventory.getBallItemCount());
        tradeManager.buyItem(inventory, item);
        assertEquals(1, inventory.getBallItemCount());
        assertEquals(EXPECTED_1, inventory.getCredits());
    }

    @Test
    void testSellItem() {
        final Item item = new HealItemImpl(HealEnum.HYPERPOTION);
        inventory.addItem(item, 2);
        assertEquals(INITIAL_AMOUNT, inventory.getCredits());
        assertEquals(2, inventory.getHealItemCount());
        tradeManager.sellItem(inventory, item);
        assertEquals(1, inventory.getHealItemCount());
        assertEquals(EXPECTED_2, inventory.getCredits());
    }
}
