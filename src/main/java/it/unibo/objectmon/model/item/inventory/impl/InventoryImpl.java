package it.unibo.objectmon.model.item.inventory.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import it.unibo.objectmon.model.item.api.BallItem;
import it.unibo.objectmon.model.item.api.HealItem;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.inventory.api.Inventory;

/**
 * Models the player inventory that uses a Map.
 */
public final class InventoryImpl implements Inventory {

    private final Map<Item, Integer> items;

    /**
     * 
     */
    public InventoryImpl() {
        this.items = new HashMap<>();
    }

    @Override
    public void addItem(final Item item, final int count) {
        //aggiunge un tot di oggetti basandosi sulla chiave (es new HealItem(HealEnum.POTION))
        items.put(item, items.getOrDefault(item, 0) + count);
    }

    @Override
    public <T extends Item> void useItem(final T item) {
        //un metodo generico che diminuisce la conta di uno strumento usando come chiave qualunque classe estenda Item
        items.computeIfPresent(item, (key, count) -> count > 1 ? count - 1 : null);
    }

    @Override
    public int getHealItemCount() {
        return items.entrySet().stream()
            .filter(entry -> entry.getKey() instanceof HealItem)
            .mapToInt(count -> count.getValue())
            .sum();
    }

    @Override
    public int getBallItemCount() {
        return items.entrySet().stream()
            .filter(entry -> entry.getKey() instanceof BallItem)
            .mapToInt(count -> count.getValue())
            .sum();
    }

    @Override
    public int getTotalItemCount() {
        return items.values().stream()
            .mapToInt(count -> count.intValue())
            .sum();
    }

    @Override
    public Map<Item, Integer> getItems() {
        return Collections.unmodifiableMap(this.items);
    }

    @Override
    public void clear() {
        this.items.clear();
    }

    @Override
    public int getInventoryValue() {
        //ritorna il totale del valore dell'inventario attraverso lo stream delle chiavi(items) e sommando il loro campo "value"
        return items.keySet().stream()
            .mapToInt(item -> item.getValue())
            .sum();
    }
}
