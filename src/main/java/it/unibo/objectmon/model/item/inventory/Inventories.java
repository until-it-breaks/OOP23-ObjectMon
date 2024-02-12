package it.unibo.objectmon.model.item.inventory;

import it.unibo.objectmon.model.item.api.BallEnum;
import it.unibo.objectmon.model.item.api.HealEnum;
import it.unibo.objectmon.model.item.impl.BallItemImpl;
import it.unibo.objectmon.model.item.impl.HealItemImpl;
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
     * Each basic item (OBJECTBALL/POTION) is added with a count of {@value BASIC_COUNT}.
     * @return an instance of InventoryImpl with basic initial items
     */
    public static InventoryImpl createWithBasicInitialItems() {
        final InventoryImpl inventory = new InventoryImpl();
        inventory.addItem(new BallItemImpl(BallEnum.OBJECTBALL), BASIC_COUNT);
        inventory.addItem(new HealItemImpl(HealEnum.POTION), BASIC_COUNT);
        return inventory;
    }

    /**
     * Creates an inventory with one of each item.
     * Each item (Ball/Heal) is added with a count of 1.
     * @return an instance of InventoryImpl with one of each type of item
     */
    public static InventoryImpl createWithOneOfEachItem() {
        final InventoryImpl inventory = new InventoryImpl();
        inventory.addItem(new BallItemImpl(BallEnum.OBJECTBALL), 1);
        inventory.addItem(new BallItemImpl(BallEnum.ULTRABALL), 1);
        inventory.addItem(new BallItemImpl(BallEnum.MASTERBALL), 1);
        inventory.addItem(new HealItemImpl(HealEnum.POTION), 1);
        inventory.addItem(new HealItemImpl(HealEnum.SUPERPOTION), 1);
        inventory.addItem(new HealItemImpl(HealEnum.HYPERPOTION), 1);
        return inventory;
    }
}
