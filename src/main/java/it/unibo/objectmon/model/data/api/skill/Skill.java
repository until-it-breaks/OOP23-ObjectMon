package it.unibo.objectmon.model.data.api.skill;

import it.unibo.objectmon.model.data.api.aspect.Aspect;

/**
 * The interface of a Skill.
 * <br>A Skill has:
 * <br>A name;
 * <br>An id;
 * <br>An Aspect;
 * <br>Accuracy, that determines how likely the Skill will hit.
 * <br>Base Power, which is the damage that a Skill would inflict
 * before multipliers;
 * <br>Max Uses, which is the max of how much a Skill can be used;
 * <br>Current Uses, which is the remaning uses of the Skill;
 * <br>Category, which determines what Stats are used in Battle.
 */
public interface Skill {

    /**
     * Getter of the id of a Skill.
     * @return Returns the Id of the Skill.
     */
    int getId();

    /**
     * Getter of the Aspect of a Skill.
     * @return Returns the Aspect of an Objectmon.
     * {@see #it.unibo.objectmon.data.skill.SkillStrenght}
     */
    Aspect getAspect();

    /**
     * Getter of the Accuracy of a Skill.
     * @return Returns the Accuracy of the Skill.
     * The accuracy is how likely a Skill will hit an opposing Objectmon.
     */
    int getAccuracy();

    /**
     *
     * @return Returns the Base power of the Skill.
     * The base power is the damage a Skill would do before
     * adding the user's Atk/SpAtk against
     * the opposing Objectmon's Def/SpDef.
     */
    int getBasePower();

    /**
     *
     * @return Returns the Max uses of a Skill.
     * A skill can't have more uses that the max uses,
     * while the minimun is 0.
     */
    int getMaxUses();

    /**
     *
     * @return Returns the Name of the Skill.
     */
    String getName();

    /**
     *
     * @return Returns the Current uses of the Skill.
     * Current uses varies from MaxUses to 0.
     */
    int getCurrentUses();

    /**
     *
     * @return Returns the Category of the Skill.
     * If it's PHYS then :
     * Skill will use the user's Atk and the Def of the target Objectmon.
     * If it's SPEC then:
     * Skill will use the user's SpAtk and the SpDef of the target Objectmon.
     * {@see #it.unibo.objectmon.api.data.skill.SkillCategory}
     */
    SkillCategory getCategory();

    /**
     *  Resets the value of CurrentUses to the MaxUses.
     *  Used when interacting with a healing NPC.
     */
    void resetCurrentUses();

    /**
     *  Subtracts from Current uses one use.
     */
    void subtractCurrentUses();
}
