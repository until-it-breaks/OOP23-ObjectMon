package it.unibo.objectmon.model.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.item.api.BallEnum;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.impl.BallItemImpl;
import it.unibo.objectmon.model.item.inventory.impl.InventoryImpl;

class InventoryImplTest {

    private InventoryImpl inventory;

    @BeforeEach
    void init() {
        inventory = new InventoryImpl();
    }

    @Test
    void testAddItem() {
        final Item item = new BallItemImpl(BallEnum.OBJECTBALL);
        assertEquals(0, inventory.getTotalItemCount());
        inventory.addItem(item, 1);
        assertEquals(1, inventory.getTotalItemCount());
        assertTrue(inventory.getItems().containsKey(item));
        assertEquals(1, inventory.getItems().get(item));
    }

    @Test
    void testUseItem() {
        final Item item = new BallItemImpl(BallEnum.MEGABALL);
        inventory.addItem(item, 2);
        inventory.useItem(item);
        assertEquals(1, inventory.getTotalItemCount());
        assertEquals(1, inventory.getItems().get(item));
        assertTrue(inventory.useItem(item));
        assertFalse(inventory.useItem(item));
        assertEquals(0, inventory.getTotalItemCount());
        assertEquals(0, inventory.getBallItemCount());
    }
}
