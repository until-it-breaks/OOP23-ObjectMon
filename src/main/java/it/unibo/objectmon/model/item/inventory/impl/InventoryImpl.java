package it.unibo.objectmon.model.item.inventory.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import it.unibo.objectmon.model.item.BallEnum;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.impl.BallItemImpl;
import it.unibo.objectmon.model.item.inventory.api.Inventory;

/**
 * Models the player inventory that uses a Map.
 */
public final class InventoryImpl implements Inventory {

    private final Map<Item, Integer> items = new LinkedHashMap<>();

    @Override
    public void addItem(final Item item) {
        final Integer count = items.get(item);
        if (count != null) {
            items.put(item, count + 1);
        } else {
            items.put(item, 1);
        }
    }

    @Override
    public void removeItem(final Item item) {
        final Integer count = items.get(item);
        if (count != null && count > 1) {
            items.put(item, count - 1);
        }
    }

    @Override
    public int getItemCount(final Item item) {
        return items.get(item);
    }
}


