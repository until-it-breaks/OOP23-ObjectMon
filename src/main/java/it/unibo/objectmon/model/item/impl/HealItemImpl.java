package it.unibo.objectmon.model.item.impl;

import it.unibo.objectmon.model.item.HealEnum;
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

    /**
     * Constructs a new Heal based on information from HealEnum.
     * @param heal enum name
     */
    public HealItemImpl(final HealEnum heal) {
        this.name = heal.getName();
        this.value = heal.getValue();
        this.healPoint = heal.getHealPoint();
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + value;
        result = prime * result + healPoint;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }    
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        HealItemImpl other = (HealItemImpl) obj;
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
        if (healPoint != other.healPoint) {
            return false;
        }
        return true;
    }
    

}
