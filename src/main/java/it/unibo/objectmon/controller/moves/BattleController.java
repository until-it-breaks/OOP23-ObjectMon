package it.unibo.objectmon.controller.moves;

import it.unibo.objectmon.api.data.skill.Skill;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;

/**
 * view through this controller to choose which move to act.
 */
public interface BattleController {
    /**
     * when player choose run away the battle.
     * @param battleManager manager of the current battle
     * @param battle the current battle
     */
    void handleRunAway(BattleManager battleManager, Battle battle);
    /**
     * when player or enemy choose a skill to attack the target.
     * @param skill to attack target
     */
    void handleAttack(Skill skill);
}
