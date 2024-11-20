package it.unibo.objectmon.model.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.item.api.HealingItemEnum;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.api.ObjectballEnum;
import it.unibo.objectmon.model.item.impl.HealingItemImpl;
import it.unibo.objectmon.model.item.impl.ObjectballImpl;
import it.unibo.objectmon.model.item.inventory.impl.InventoryImpl;

/**
 * Tests for {@link InventoryImpl}.
 */
//CHECKSTYLE: MagicNumber OFF
//Using arbitary values for testing.
class TestInventoryImpl {

    private InventoryImpl inventory;

    @BeforeEach
    void init() {
        inventory = new InventoryImpl(100);
    }

    @Test
    void testAddItem() {
        final Item item = new HealingItemImpl(HealingItemEnum.POTION);
        inventory.addItem(item, 1);
        assertEquals(1, inventory.getTotalItemCount());
        assertEquals(1, inventory.getHealingItemCount());
    }

    @Test
    void testUseItem() {
        final Item item = new HealingItemImpl(HealingItemEnum.POTION);
        inventory.addItem(item, 1);
        assertTrue(inventory.useItem(item));
        assertEquals(0, inventory.getTotalItemCount());
        assertEquals(0, inventory.getHealingItemCount());
    }

    @Test
    void testGetInventoryValue() {
        final Item item1 = new HealingItemImpl(HealingItemEnum.POTION);
        final Item item2 = new ObjectballImpl(ObjectballEnum.OBJECTBALL);
        inventory.addItem(item1, 2);
        inventory.addItem(item2, 1);
        assertEquals(item1.getValue() * 2 + item2.getValue(), inventory.getInventoryValue());
    }

    @Test
    void testAddCredits() {
        assertEquals(150, inventory.addCredits(50)); //adding 50 credits
    }

    @Test
    void testWithdrawCreditsEnoughCredits() {
        assertTrue(inventory.withdrawCredits(50)); //withdraw 50 credits from 100 initial
        assertEquals(50, inventory.getCredits());
    }

    @Test
    void testWithdrawCreditsNotEnoughCredits() {
        assertFalse(inventory.withdrawCredits(150)); //withdraw 150 from initial 100
        assertEquals(100, inventory.getCredits()); //credits should remain unchanged
    }
}
//CHECKSTYLE: MagicNumber ON
