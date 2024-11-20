package it.unibo.objectmon.model.data.skill;

import java.io.Serializable;
import java.util.Objects;

import it.unibo.objectmon.model.data.api.elementalType.Aspect;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.skill.SkillType;

/**
 * Implementation of the interface Skill.
 */
public class SkillImpl implements Serializable, Skill {
    private static final long serialVersionUID = 2006L;
    /**
     * The skill's name.
     */
    private final String name;
    /**
     * The skill's id.
     */
    private final int id;
    /**
     * The skill's aspect.
     */
    private final Aspect aspect;
    /**
     * The skill's base power.
     */
    private final int basePower;
    /**
     * The skill's accuracy.
     */
    private final int accuracy;
    /**
     * The skill's max uses.
     */
    private final int maxUses;
    /**
     * The skill's current uses.
     */
    private int currentUses;
    /**
     * The skill's category.
     */
    private final SkillType category;

    /**
     * Constructor of the SkillImpl.
     * 
     * @param name Name of the Skill.
     * @param id Id of the Skill.
     * @param aspect Aspect of the Skill.
     * @param basePower Base power of the Skill.
     * @param accuracy Accuracy of the Skill.
     * @param maxUses Max uses of the Skill.
     * @param category SkillCategory of the Skill.
     */
    public SkillImpl(
        final String name,
        final int id,
        final Aspect aspect,
        final int basePower,
        final int accuracy,
        final int maxUses,
        final SkillType category
        ) {
        this.name = name;
        this.id = id;
        this.aspect = aspect;
        this.basePower = basePower;
        this.accuracy = accuracy;
        this.maxUses = maxUses;
        this.currentUses = this.maxUses;
        this.category = category;
    }

    @Override
    public final int getId() {
        return this.id;
    }

    @Override
    public final Aspect getAspect() {
        return this.aspect;
    }

    @Override
    public final int getAccuracy() {
        return this.accuracy;
    }

    @Override
    public final int getBasePower() {
        return this.basePower;
    }

    @Override
    public final int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final int getCurrentUses() {
        return this.currentUses;
    }

    @Override
    public final SkillType getType() {
        return this.category;
    }

    @Override
    public final void resetCurrentUses() {
        this.currentUses = this.maxUses;
    }

    @Override
    public final void subtractCurrentUses() {
        if (getCurrentUses() > 0) {
            this.currentUses--;
        }
    }

    /**
     * Compares a Skill with another to see if they're identical.
     * If they are the same instance returns true.
     * If they have the same name and id returns true.
     * Everything else returns false.
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        } else if (this == obj) {
            return true;
        }

        final Skill skill = (Skill) obj;
        return Integer.valueOf(getId()).equals(skill.getId())
        && getName().equals(skill.getName());
    }


    /**
     * Returns the hash code value for Skill.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
