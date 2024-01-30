package it.unibo.objectmon.model.item.inventory.impl;

import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;

import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.inventory.api.Inventory;

public class InventoryImpl implements Inventory{

    public ArrayList<Item> inventory = new ArrayList<>();

    @Override
    public void setItems() {
        
    }


}
