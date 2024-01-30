package it.unibo.objectmon.model.item.impl;

import it.unibo.objectmon.model.item.api.BallItem;

public class BallItemImpl implements BallItem{

    final String name;
    final int value;
    final double catchMultiplier;

    public BallItemImpl(final String name, final int value, final double catchMultiplier) {
        this.name = name;
        this.value = value;
        this.catchMultiplier = catchMultiplier;
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
    public double getCatchMultiplier() {
        return this.catchMultiplier;
    }
    
}
