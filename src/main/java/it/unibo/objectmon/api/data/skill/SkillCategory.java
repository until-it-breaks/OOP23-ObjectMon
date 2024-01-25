package it.unibo.objectmon.api.data.skill;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public enum SkillCategory {
    /**
     *Category of a Skill.
     A Physical Skill calculates damage using the user's Atk
     against the target's Def.
     */
    PHYS(0, "Physical"),
    /**
     *Category of a Skill.
     A Special Skill calculates damage using the user's SpAtk
     against the target's SpDef.
     */
    SPEC(1, "Special"),
    /**
     *Category of a Skill.
     A Status Skill doesn't do damage, but can apply a status to the user or the target.
     */
    STUS(2, "Status");

    private final Map<Integer, String> category = new HashMap<>();

    /**
     *
     * @param id Id of the DamageType.
     * @param name Name of the DamageType.
     */
    SkillCategory(final int id, final String name) {
        this.category.put(id, name);
    }

    /**
     *
     * @return Returns the category.
     */
    public Map<Integer, String> getCategory() {
        return Map.copyOf(this.category);
    }

    /**
     * @param key Id of the category.
     * @return Returns the name of the DamageType of the Skill.
     */
    public String getName(final int key) {
        return getCategory().get(key);
    }
}
