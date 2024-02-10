package it.unibo.objectmon.model.item.inventory.impl;

import java.util.Map;
import java.util.HashMap;

import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.inventory.api.Inventory;

/**
 * Models the player inventory that uses a Map.
 */
public final class InventoryImpl implements Inventory {

    private Map<Item, Integer> items;

    public InventoryImpl() {
        this.items = new HashMap<>();
    }

    @Override
    public void addItem(Item item, int count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }

    @Override
    public <T extends Item> void useItem(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useItem'");
    }

    @Override
    public int getHealItemCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHealItemCount'");
    }

    @Override
    public int getBallItemCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBallItemCount'");
    }

    @Override
    public int getTotalItemCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotalItemCount'");
    }

    @Override
    public Map<Item, Integer> getItems() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItems'");
    }

    @Override
    public void Clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Clear'");
    }

    @Override
    public int getInventoryValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInventoryValue'");
    }

    @Override
    public void removeItem(Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItem'");
    }

    @Override
    public int getItemCount(Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItemCount'");
    }

    
}
