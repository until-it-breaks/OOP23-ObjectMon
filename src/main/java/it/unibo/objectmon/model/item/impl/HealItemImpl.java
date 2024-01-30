package it.unibo.objectmon.model.item.impl;

import it.unibo.objectmon.model.item.api.HealItem;

public class HealItemImpl implements HealItem{

    final String name;
    final int value;
    final int healPoint;

    public HealItemImpl(final String name, final int value, final int healPoint) {
        this.name = name;
        this.value = value;
        this.healPoint = healPoint;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public int getHealPoints() {
        return this.healPoint;
    }
    
}
