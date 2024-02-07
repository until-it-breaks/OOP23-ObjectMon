package it.unibo.objectmon.model.data.skill;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.skill.SkillCategory;

/**
 * A factory of Skills.
 */
public final class SkillFactory {
    private static final int BASE40 = 40;
    private static final int BASE60 = 60;
    private static final int BASE100 = 100;

    private static final int MAX25 = 25;
    private static final int MAX40 = 40;
    private static final int MAX8 = 8;

    private static final int ACC100 = 100;
    private static final int ACC75 = 75;
    private static final int ACC90 = 90;

    private SkillFactory() {
    }

    /**
     * Creates the Skills that Objectmon are going to use.
     * @return Returns the complete list of all the Skills.
     */
    public static List<Skill> createSkills() {
        final List<Skill> skillList = new LinkedList<>();
        int id = 0;
        for (final Aspect aspect : Aspect.values()) {
            String name = aspect.getAspectName() + " Tackle";
            skillList.add(new Skill(name, id, aspect, BASE40, ACC100, MAX40, SkillCategory.PHYS));
            id++;
            name = aspect.getAspectName() + " Kick";
            skillList.add(new Skill(name, id, aspect, BASE60, ACC90, MAX25, SkillCategory.PHYS));
            id++;
            name = aspect.getAspectName() + " Slam";
            skillList.add(new Skill(name, id, aspect, BASE100, ACC75, MAX8, SkillCategory.PHYS));
            id++;
            name = aspect.getAspectName() + " Ray";
            skillList.add(new Skill(name, id, aspect, BASE40, ACC100, MAX40, SkillCategory.SPEC));
            id++;
            name = aspect.getAspectName() + " Spirit";
            skillList.add(new Skill(name, id, aspect, BASE60, ACC90, MAX25, SkillCategory.SPEC));
            id++;
            name = aspect.getAspectName() + " Bomb";
            skillList.add(new Skill(name, id, aspect, BASE100, ACC75, MAX8, SkillCategory.SPEC));
            id++;
        }

        return skillList;
    }

    /**
     * Converts a list of Skill to a json file.
     * @return Returns a json of the list of Skill.
     */
    public static String toJson() {
        final Gson gson = new Gson();
        return gson.toJson(createSkills());
    }
}
