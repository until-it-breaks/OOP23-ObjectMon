package it.unibo.objectmon.model.data.skill;

import java.io.Serializable;
import java.util.Objects;

import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.skill.SkillCategory;

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
    private final SkillCategory category;

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
        final SkillCategory category
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

    /**
     * Constructor of Skill using a builder.
     * 
     * @param builder The builder.
     */
    private SkillImpl(final Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.aspect = builder.aspect;
        this.basePower = builder.basePower;
        this.accuracy = builder.accuracy;
        this.maxUses = builder.maxUses;
        this.currentUses = builder.currentUses;
        this.category = builder.category;
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
    public final SkillCategory getCategory() {
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

    /**
     * Builder of a Skill.
     * Used to generate a Skill.
     */
    public static class Builder {
        private final String name;
        private final int id;
        private final Aspect aspect;
        private final int basePower;
        private final int accuracy;
        private final int maxUses;
        private final int currentUses;
        private final SkillCategory category;

        /**
         * Constructor of a Skill.
         * 
         * @param name  Name of the Skill.Can't be null.
         * @param id    Id of the Skill. Can't be negative.
         *
         * @param aspect Aspect of the Skill.
         *  It's used to determine if a Skill is:
         *  {@see #it.unibo.objectmon.data.skill.SkillStrenght},
         *  or if a Skill has SameAspectBoost.
         *  Can't be null.
         *
         * @param basePower Base power of the Skill.
         *  Gets added to the offensive stat of the user to determine
         *  how much damage is inflicted.
         *  Can't be negative.
         *  Should only be 0 if it's a Status Skill.
         * @param accuracy  Accuracy of the Skill.
         *  Determines if a Skill will hit or not.
         *  accuracy can have a value between 0 and 101:
         *  101 If it can't miss;
         *  between 0 an 100 a random number is generated.
         *  If the number is higher than the accuracy,
         *  the Skill will fail.
         * @param maxUses   Determines how many times the move can be used it total.
         *  Can't be 0 or negative.
         * @param category Category of a skill {@see SkillCategory#getCategory()}.
         */
        public Builder(
            final String name,
            final int id,
            final Aspect aspect,
            final int basePower,
            final int accuracy,
            final int maxUses,
            final SkillCategory category
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

        /**
         * Method that builds the Skill.
         * 
         * @return Returns the Skill that was built.
         */
        public Skill build() {
            return new SkillImpl(this);
        }
    }
}
