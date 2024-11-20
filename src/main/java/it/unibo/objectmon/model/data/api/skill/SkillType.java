package it.unibo.objectmon.model.data.api.skill;

/**
 * The enum of SkillCategory.
 * <br>A Skill can be PHYS or SPEC.
 */
public enum SkillType {

    /**
     * Category of a Skill.
     * A Physical Skill calculates damage using the user's Atk against the target's Def.
     */
    PHYSICAL("Physical"),

    /**
     * Category of a Skill.
     * A Special Skill calculates damage using the user's SpAtk against the target's SpDef.
     */
    SPECIAL("Special");

    private final String name;

    /**
     * Constructor of the enum SkillCategory.
     * 
     * @param name Name of the DamageType.
     */
    SkillType(final String name) {
        this.name = name;
    }

    /**
     * Getter of the name of the SkillCategory.
     * 
     * @return Returns the name of the SkillCategory.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter of the SkillCategory.
     * 
     * @return Returns the SkillCategory.
     */
    public SkillType getCategory() {
        return this;
    }
}
