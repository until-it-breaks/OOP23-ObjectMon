package it.unibo.objectmon.model.item.inventory;

import it.unibo.objectmon.model.item.api.ObjectballEnum;
import it.unibo.objectmon.model.item.api.HealingItemEnum;
import it.unibo.objectmon.model.item.impl.ObjectballImpl;
import it.unibo.objectmon.model.item.impl.HealingItemImpl;
import it.unibo.objectmon.model.item.inventory.impl.InventoryImpl;

/**
 * Utility class for creating inventory instances with predefined sets of items.
 */
public final class Inventories {

    private static final int BASIC_COUNT = 5;

    private Inventories() {
    }

    /**
     * Creates an inventory with basic initial items.
     * 
     * @return An instance of InventoryImpl with basic initial items.
     */
    public static InventoryImpl createWithBasicInitialItems() {
        final InventoryImpl inventory = new InventoryImpl(1000);
        inventory.addItem(new ObjectballImpl(ObjectballEnum.OBJECTBALL), BASIC_COUNT);
        inventory.addItem(new HealingItemImpl(HealingItemEnum.POTION), BASIC_COUNT);
        return inventory;
    }

    /**
     * Creates an inventory with one of each item type.
     * 
     * @return An instance of InventoryImpl with one of each type of item.
     */
    public static InventoryImpl createWithOneOfEachItem() {
        final InventoryImpl inventory = new InventoryImpl(5000);
        inventory.addItem(new ObjectballImpl(ObjectballEnum.OBJECTBALL), 1);
        inventory.addItem(new ObjectballImpl(ObjectballEnum.ULTRABALL), 1);
        inventory.addItem(new ObjectballImpl(ObjectballEnum.MASTERBALL), 1);
        inventory.addItem(new HealingItemImpl(HealingItemEnum.POTION), 1);
        inventory.addItem(new HealingItemImpl(HealingItemEnum.SUPERPOTION), 1);
        inventory.addItem(new HealingItemImpl(HealingItemEnum.HYPERPOTION), 1);
        return inventory;
    }
}
