package it.unibo.objectmon.model.item.impl;

import java.util.Objects;

import it.unibo.objectmon.model.item.api.HealingItemEnum;
import it.unibo.objectmon.model.item.api.HealingItem;

/**
 * Models a healing item used by the player.
 */
public final class HealingItemImpl implements HealingItem {

    private final String name;
    private final int value;
    private final int hp;

    /**
     * Creates a new healing item.
     * 
     * @param name The name of the healing item.
     * @param value The value of the healing item.
     * @param hp The amount of HP healed by the item.
     */
    public HealingItemImpl(final String name, final int value, final int hp) {
        this.name = name;
        this.value = value;
        this.hp = hp;
    }

    /**
     * Creates a new healing based on information from HealingItemEnum.
     * 
     * @param healingItem The healing item to be created.
     */
    public HealingItemImpl(final HealingItemEnum healingItem) {
        this.name = healingItem.getName();
        this.value = healingItem.getValue();
        this.hp = healingItem.getHealingAmount();
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
    public int getHealedHPs() {
        return this.hp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + value;
        result = prime * result + hp;
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
        final HealingItemImpl other = (HealingItemImpl) obj;
        return hp == other.hp
            && value == other.value
            && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "HealItemImpl [name=" + name + ", value=" + value + ", healPoint=" + hp + "]";
    }
}
