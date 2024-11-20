package it.unibo.objectmon.model.data.skill;

import it.unibo.objectmon.model.data.api.elementalType.Aspect;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.skill.SkillType;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/**
 * Test of Skills.
 */
class TestSkill {
    private final Skill normal = new Skill("Tackle", 0, Aspect.NORMAL, 40, 100, 35, SkillType.PHYSICAL);
    private final Skill ground = new Skill("Earth Power", 3, Aspect.GROUND, 90, 100, 10, SkillType.SPECIAL);

    /**
     * Test of the various Skills.
     */
    @Test
    void testSkills() {
        //Check if Aspect is correct
        assertEquals(Aspect.NORMAL, normal.getElementalType());
        assertEquals(Aspect.GROUND, ground.getElementalType());

        //Check if SkillCategory is correct
        assertEquals(SkillType.PHYSICAL, normal.getType());
        assertEquals(SkillType.SPECIAL, ground.getType());

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
        final Skill skill = new Skill("Tackle",  0, Aspect.NORMAL, basePower, 100, maxUses, SkillType.PHYSICAL);

        assertEquals(normal.getId(), skill.getId());
        assertEquals(normal.getName(), skill.getName());
        assertEquals(normal.getElementalType(), skill.getElementalType());
        assertEquals(normal.getBasePower(), skill.getBasePower());
        assertEquals(normal.getAccuracy(), skill.getAccuracy());
        assertEquals(normal.getMaxUses(), skill.getMaxUses());
        assertEquals(normal.getType(), skill.getType());
    }
}
