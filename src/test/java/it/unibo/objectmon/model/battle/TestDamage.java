package it.unibo.objectmon.model.battle;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.battle.damage.DamageCalculator;
import it.unibo.objectmon.model.battle.damage.DamageCalculatorImpl;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * test damage calculator.
 */
//magic number represents a formula mathematically invented
//CHECKSTYLE: MagicNumber OFF
class TestDamage {
    private final DamageCalculator damageCalculator;
    private final Objectmon user;
    private final Objectmon target1;
    private final Objectmon target2;
    /**
     * constructor.
     */
    TestDamage() {
        user = ObjectmonFactory.createObjectmon(ObjectmonEnum.ANORITH, 0);
        target1 = ObjectmonFactory.createObjectmon(ObjectmonEnum.ANORITH, 0);
        target2 = ObjectmonFactory.createObjectmon(ObjectmonEnum.ILLUMISE, 1);
        final Skill skill = user.getSkills().get(0);
        damageCalculator = new DamageCalculatorImpl(skill);
    }
    /**
     * test the calculation.
     */
    @Test
    void testDamageCalculation() {
        assertEquals(25.5, damageCalculator.damage(user, target1));
        assertEquals(36.0, damageCalculator.damage(user, target2));
    }
}
//CHECKSTYLE: MagicNumber ON
