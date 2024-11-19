package it.unibo.objectmon.model.item.impl;

import java.util.Objects;

import it.unibo.objectmon.model.item.api.ObjectballEnum;
import it.unibo.objectmon.model.item.api.Objectball;

/**
 * Models objectballs used by the player.
 */
public final class ObjectballImpl implements Objectball {

    private final String name;
    private final int value;
    private final double catchMultiplier;

    /**
     * Creates a new objectball.
     * 
     * @param name The name of the objectball.
     * @param value The value of the objectball.
     * @param catchMultiplier The catch rate multiplier of the objectball.
     */
    public ObjectballImpl(final String name, final int value, final double catchMultiplier) {
        this.name = name;
        this.value = value;
        this.catchMultiplier = catchMultiplier;
    }

    /**
     * Creates a new objectball based on information from ObjectballEnum.
     * 
     * @param objectball The objectball to be created.
     */
    public ObjectballImpl(final ObjectballEnum objectball) {
        this.name = objectball.getName();
        this.value = objectball.getValue();
        this.catchMultiplier = objectball.getCatchRateMultiplier();
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + value;
        long temp;
        temp = Double.doubleToLongBits(catchMultiplier);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ObjectballImpl other = (ObjectballImpl) obj;
        return Double.compare(other.catchMultiplier, catchMultiplier) == 0
            && value == other.value
            && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "BallItemImpl [name=" + name + ", value=" + value + ", catchMultiplier=" + catchMultiplier + "]";
    }
}
