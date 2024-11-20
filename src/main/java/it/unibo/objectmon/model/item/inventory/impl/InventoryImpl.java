package it.unibo.objectmon.model.item.inventory.impl;

import java.util.Map;

import java.util.LinkedHashMap;
import java.util.Collections;

import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.impl.HealingItemImpl;
import it.unibo.objectmon.model.item.impl.ObjectballImpl;
import it.unibo.objectmon.model.item.inventory.api.Inventory;

/**
 * Models the player's inventory using a map that accepts the item istance as key.
 */
public final class InventoryImpl implements Inventory {

    private final Map<Item, Integer> items;
    private int credits;

    /**
     * Creates the inventory.
     * 
     * @param credits The initial credits of the player.
     */
    public InventoryImpl(final int credits) {
        this.items = new LinkedHashMap<>();
        this.credits = credits;
    }

    @Override
    public void addItem(final Item item, final int count) {
        items.put(item, items.getOrDefault(item, 0) + count);
    }

    @Override
    public <T extends Item> boolean useItem(final T item) {
        final Integer count = items.get(item);
        if (count != null && count > 0) {
            items.put(item, count - 1);
            return true;
        }
        return false;
    }

    @Override
    public int getHealingItemCount() {
        return items.entrySet().stream()
            .filter(entry -> entry.getKey() instanceof HealingItemImpl)
            .mapToInt(count -> count.getValue())
            .sum();
    }

    @Override
    public int getObjectballCount() {
        return items.entrySet().stream()
            .filter(entry -> entry.getKey() instanceof ObjectballImpl)
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
        return items.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getValue() * entry.getValue())
            .sum();
    }

    @Override
    public int getCredits() {
        return this.credits;
    }

    @Override
    public int addCredits(final int amount) {
        credits += amount;
        return credits;
    }

    @Override
    public boolean withdrawCredits(final int amount) {
        if (credits >= amount) {
            credits -= amount; 
            return true;
        }
        return false;
    }
}
