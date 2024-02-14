package it.unibo.objectmon.model.item.inventory.impl;

import java.util.Map;
import java.util.Collections;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.inventory.api.Inventory;

/**
 * A {@link Inventory} wrapper that only expose getters.
 */
@SuppressFBWarnings(
    value = "EI_EXPOSE_REP2", 
    justification = "By design this provides read-only information outside of the model."
)
public final class InventoryReadOnly implements Inventory {
    private final Inventory inventory;

    /**
     * Constructs a new read-only Inventory instance that wraps the given {@link Inventory} object.
     * @param inventory The inventory to be wrapped.
     */
    public InventoryReadOnly(final Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void addItem(final Item item, final int count) {
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }

    @Override
    public <T extends Item> boolean useItem(final T item) {
        throw new UnsupportedOperationException("Unimplemented method 'useItem'");
    }

    @Override
    public int getHealItemCount() {
        return inventory.getHealItemCount();
    }

    @Override
    public int getBallItemCount() {
        return inventory.getBallItemCount();
    }

    @Override
    public int getTotalItemCount() {
        return inventory.getTotalItemCount();
    }

    @Override
    public Map<Item, Integer> getItems() {
        return Collections.unmodifiableMap(inventory.getItems());
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public int getInventoryValue() {
        return inventory.getInventoryValue();
    }

    @Override
    public int getCredits() {
        return inventory.getCredits();
    }

    @Override
    public int addCredits(final int amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCredits'");
    }

    @Override
    public boolean withdrawCredits(final int amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withdrawCredits'");
    }
}
