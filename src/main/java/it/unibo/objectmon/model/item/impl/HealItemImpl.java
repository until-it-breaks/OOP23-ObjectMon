package it.unibo.objectmon.model.item.impl;

import it.unibo.objectmon.model.item.api.HealItem;

/**
 * Models a Heal item usable by player.
 */
public final class HealItemImpl implements HealItem {

    private final String name;
    private final int value;
    private final int healPoint;

    /**
     * Creates a Heal item.
     * @param name the heal item
     * @param value the heal value
     * @param healPoint the heal HP value
     */
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
