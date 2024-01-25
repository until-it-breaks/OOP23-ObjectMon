package it.unibo.objectmon.api.data.skill;

/**
 * The class Skill, that gets used to make:
 * a Map of the Skill an Objectmon can learn by leveling up;
 * a Map of Skill of what an Objectmon can use (4 Skills Max).
 */
public abstract class Skill {
    private final String name;
    private final int id;
    /**
     *  Aspect of the Skill.
     *  It's used to determine if a Skill is:
     *  {@see #it.unibo.objectmon.data.skill.SkillStrenght},
     *  or if a Skill has SameAspectBoost.
     *  Can't be null
     */
    //private final Aspect aspect;
    private final int basePower;
    private final int accuracy;
    private final int maxUses;
    private int currentUses;
    private final SkillCategory category;

    /**
     * Constructor of a Skill.
     * @param name  Name of the Skill.Can't be null.
     * @param id    Id of the Skill. Can't be negative.
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
     * @param currentUses   Determines how many times the move can be used.
     *  Can be 0, can't go negative.
     * @param category Category of a skill {@see SkillCategory#getCategory()}.
     */
    public Skill(
        final String name,
        final int id,
        final int basePower,
        final int accuracy,
        final int maxUses,
        final int currentUses,
        final SkillCategory category
        ) {
        this.name = name;
        this.id = id;
        this.basePower = basePower;
        this.accuracy = accuracy;
        this.maxUses = maxUses;
        this.currentUses = currentUses;
        this.category = category;
    }

    /**
     *
     * @return Returns the Id of the Skill.
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return Returns the Accuracy of the Skill.
     * The accuracy is how likely a Skill will hit an opposing Objectmon.
     */
    public int getAccuracy() {
        return accuracy;
    }

    /**
     *
     * @return Returns the Base power of the Skill.
     * The base power is the damage a Skill would do before 
     * adding the user's Atk/SpAtk against
     * the opposing Objectmon's Def/SpDef.
     */
    public int getBasePower() {
        return basePower;
    }

    /**
     *
     * @return Returns the Max uses of a Skill.
     * A skill can't have more uses that the max uses,
     * while the minimun is 0.
     */
    public int getMaxUses() {
        return maxUses;
    }

    /**
     *
     * @return Returns the Name of the Skill.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return Returns the Current uses of the Skill.
     * Current uses varies from MaxUses to 0.
     */
    public int getCurrentUses() {
        return currentUses;
    }

    /**
     *
     * @return Returns the Category of the Skill.
     * If it's PHYS then :
     * Skill will use the user's Atk and the Def of the target Objectmon.
     * If it's SPEC then:
     * Skill will use the user's SpAtk and the SpDef of the target Objectmon. 
     * {@see #it.unibo.objectmon.api.data.skill.SkillCategory}
     */
    public SkillCategory getCategory() {
        return category;
    }
    /**
     *  Resets the value of CurrentUses to the MaxUses.
     *  Used when interacting with a healing NPC.
     */
    public void resetCurrentUses() {
        this.currentUses = this.maxUses;
    }

    /**
     *  Subtracts from Current uses one use.
     *  A check (CurrentUses > 0) needs to be done before using this method. 
     */
    public void subtractCurrentUses() {
        this.currentUses--;
    }
}
