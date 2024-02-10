package it.unibo.objectmon.model.data.skill;

import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.skill.SkillCategory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/**
 * Test of Skills.
 */
class TestSkill {
    private final Skill normal = new SkillImpl("Tackle", 0, Aspect.NORMAL, 40, 100, 35, SkillCategory.PHYS);
    private final Skill ground = new SkillImpl("Earth Power", 3, Aspect.GROUND, 90, 100, 10, SkillCategory.SPEC);

    /**
     * Test of the various Skills.
     */
    @Test
    void testSkills() {
        //Check if Aspect is correct
        assertEquals(Aspect.NORMAL, normal.getAspect());
        assertEquals(Aspect.GROUND, ground.getAspect());

        //Check if SkillCategory is correct
        assertEquals(SkillCategory.PHYS, normal.getCategory());
        assertEquals(SkillCategory.SPEC, ground.getCategory());

        //Check if methods that use currentUses work correctly
        for (int i = 0; i < ground.getMaxUses() + 1; i++) {
            ground.subtractCurrentUses();
        }

        final int expectedUses = 0;
        assertEquals(expectedUses, ground.getCurrentUses());
        ground.resetCurrentUses();
        assertEquals(ground.getMaxUses(), ground.getCurrentUses());
    }

    @Test
    void testSkillBuilder() {
        final int basePower = 40;
        final int maxUses = 35;
        final Skill skill = new SkillImpl.Builder("Tackle",  0, Aspect.NORMAL, basePower, 100, maxUses, SkillCategory.PHYS)
        .build();

        assertEquals(normal.getId(), skill.getId());
        assertEquals(normal.getName(), skill.getName());
        assertEquals(normal.getAspect(), skill.getAspect());
        assertEquals(normal.getBasePower(), skill.getBasePower());
        assertEquals(normal.getAccuracy(), skill.getAccuracy());
        assertEquals(normal.getMaxUses(), skill.getMaxUses());
        assertEquals(normal.getCategory(), skill.getCategory());
    }
}
