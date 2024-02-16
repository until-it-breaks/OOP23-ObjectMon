package it.unibo.objectmon.model.trademanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.item.api.BallEnum;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.impl.BallItemImpl;
import it.unibo.objectmon.model.item.inventory.api.Inventory;
import it.unibo.objectmon.model.item.inventory.impl.InventoryImpl;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;
import it.unibo.objectmon.model.item.trademanager.impl.TradeManagerImpl;
import it.unibo.objectmon.model.item.trademanager.impl.TradeManagerWithFreebie;
import it.unibo.objectmon.model.item.trademanager.impl.TradeManagerWithPenalty;

/**
 * Tests for the various {@link TradeManager} decorations.
 */
class TradeManagerTest {

    private static final int STARTING_CREDITS = 1000;
    private static final double PENALTY = 0.5;
    private TradeManager tradeManager;
    private Inventory inventory;

    @BeforeEach
    void init() {
        inventory = new InventoryImpl(STARTING_CREDITS);
    }

    @Test
    void testBuyItemNoCreditsWithoutDecoration() {
        inventory = new InventoryImpl(0);
        final Item item = new BallItemImpl(BallEnum.GREATBALL);
        tradeManager = new TradeManagerImpl();
        assertFalse(tradeManager.buyItem(inventory, item));
        assertEquals(0, inventory.getCredits());
        assertEquals(0, inventory.getBallItemCount());
    }

    @Test
    void testBuyItemEnoughCreditsWithoutDecoration() {
        final Item item = new BallItemImpl(BallEnum.OBJECTBALL);
        tradeManager = new TradeManagerImpl();
        assertTrue(tradeManager.buyItem(inventory, item));
        assertEquals(STARTING_CREDITS - item.getValue(), inventory.getCredits());
        assertEquals(1, inventory.getBallItemCount());
    }

    @Test
    void testSellItemWithoutDecoration() {
        final Item item = new BallItemImpl(BallEnum.OBJECTBALL);
        tradeManager = new TradeManagerImpl();
        inventory.addItem(item, 1);
        assertTrue(tradeManager.sellItem(inventory, item));
        assertEquals(STARTING_CREDITS + item.getValue(), inventory.getCredits());
        assertEquals(0, inventory.getBallItemCount());
    }

    @Test
    void testSellItemWithPenaltyDecoration() {
        final Item item = new BallItemImpl(BallEnum.OBJECTBALL);
        tradeManager = new TradeManagerWithPenalty(PENALTY, new TradeManagerImpl());
        inventory.addItem(item, 1);
        assertTrue(tradeManager.sellItem(inventory, item));
        assertEquals(STARTING_CREDITS + item.getValue() * PENALTY, inventory.getCredits());
        assertEquals(0, inventory.getBallItemCount());
    }

    @Test
    void testBuyItemWithFreebieDecoration() {
        final Item item = new BallItemImpl(BallEnum.OBJECTBALL);
        tradeManager = new TradeManagerWithFreebie(2, new TradeManagerImpl());
        assertTrue(tradeManager.buyItem(inventory, item));
        assertEquals(STARTING_CREDITS - item.getValue(), inventory.getCredits());
        assertTrue(tradeManager.buyItem(inventory, item));
        assertEquals(STARTING_CREDITS - item.getValue() * 2, inventory.getCredits());
        assertEquals(3, inventory.getBallItemCount());
    }
}
