package it.unibo.objectmon.api.data.skill;

/**
 * The class Skill, that gets used to make:
 * a Map of the Skill an Objectmon can learn by leveling up;
 * a Map of Skill of what an Objectmon can use (4 Skills Max).
 */
public abstract class Skill {
    /**
     *  Name of the Skill.
     *  Can't be null.
     */
    private final String name;
    /**
     *  Id of the Skill.
     *  Can't be negative.
     */
    private final int id;
    /**
     *  Aspect of the Skill.
     *  It's used to determine if a Skill is:
     *  {@see #it.unibo.objectmon.data.skill.SkillStrenght},
     *  or if a Skill has SameAspectBoost.
     *  Can't be null
     */
    //private final Aspect aspect;
    /**
     *  Base power of the Skill.
     *  Gets added to the offensive stat of the user to determine
     *  how much damage is inflicted.
     *  Can't be negative.
     *  Should only be 0 if it's a Status Skill.
     */
    private final int basePower;
    /**
     *  Accuracy of the Skill.
     *  Determines if a Skill will hit or not.
     * accuracy can have a value between 0 and 101:
     * 101 If it can't miss;
     * 
     * between 0 an 100 a random number is generated.
     * If the number is higher than the accuracy,
     * the Skill will fail.
     */
    private final int accuracy;
    /**
     *  Determines how many times the move can be used it total.
     *  Can't be 0 or negative.
     */
    private final int maxUses;
    /*
     *  Determines how many times the move can be used.
     *  Can be 0, can't go negative.
     */
    private int currentUses;
    /**
     *  Category of a skill {@see #it.unibo.objectmon.api.data.skill.SkillCategory}.
     */
    //private final SkillCategory category;

    /**
     * 
     * @param name
     * @param id
     * @param basePower
     * @param accuracy
     * @param maxUses
     * @param currentUses
     */
    public Skill(
        final String name,
        final int id,
        final int basePower,
        final int accuracy,
        final int maxUses,
        final int currentUses
        ) {
        this.name = name;
        this.id = id;
        this.basePower = basePower;
        this.accuracy = accuracy;
        this.maxUses = maxUses;
        this.currentUses = currentUses;
    }

    public int getId() {
        return id;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getBasePower() {
        return basePower;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public String getName() {
        return name;
    }

    public int getCurrentUses() {
        return currentUses;
    }

    public void setCurrentUses(int currentUses) {
        this.currentUses = currentUses;
    }
}
