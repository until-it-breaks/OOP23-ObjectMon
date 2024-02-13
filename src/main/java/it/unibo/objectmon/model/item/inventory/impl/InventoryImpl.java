package it.unibo.objectmon.model.item.inventory.impl;

import java.util.Map;

import java.util.LinkedHashMap;
import java.util.Collections;

import it.unibo.objectmon.model.item.api.BallItem;
import it.unibo.objectmon.model.item.api.HealItem;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.inventory.api.Inventory;

/**
 * Models the player inventory using a map that accepts the item istance as key.
 */
public final class InventoryImpl implements Inventory {

    private final Map<Item, Integer> items;
    private int credits;

    /**
     * Constructs the inventory.
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
        return items.keySet().stream()
            .mapToInt(item -> item.getValue())
            .sum();
    }

    @Override
    public int getCredits() {
        return this.credits;
    }

    @Override
    public int addCredits(final int amount) {
        return credits += amount;
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
