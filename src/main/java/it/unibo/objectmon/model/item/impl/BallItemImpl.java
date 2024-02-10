package it.unibo.objectmon.model.item.impl;

import it.unibo.objectmon.model.item.api.BallEnum;
import it.unibo.objectmon.model.item.api.BallItem;

/**
 * Models Ball item usable by player.
 */
public final class BallItemImpl implements BallItem {

    private final String name;
    private final int value;
    private final double catchMultiplier;

    /**
     * Creates a new Ball.
     * @param name the ball name
     * @param value the ball value
     * @param catchMultiplier the ball catch multiplier
     */
    public BallItemImpl(final String name, final int value, final double catchMultiplier) {
        this.name = name;
        this.value = value;
        this.catchMultiplier = catchMultiplier;
    }

    /**
     * Constructs a new Ball based on information from BallEnum.
     * @param ball enum name
     */
    public BallItemImpl(final BallEnum ball) {
        this.name = ball.getName();
        this.value = ball.getValue();
        this.catchMultiplier = ball.getCatchRateMultiplier();
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BallItemImpl other = (BallItemImpl) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (value != other.value) {
            return false;
        }
        if (Double.doubleToLongBits(catchMultiplier) != Double.doubleToLongBits(other.catchMultiplier)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BallItemImpl [name=" + name + ", value=" + value + ", catchMultiplier=" + catchMultiplier + "]";
    }
}
