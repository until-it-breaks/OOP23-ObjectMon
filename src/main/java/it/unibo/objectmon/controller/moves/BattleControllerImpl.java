package it.unibo.objectmon.controller.moves;

import it.unibo.objectmon.api.data.skill.Skill;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.moves.api.Move;
import it.unibo.objectmon.model.battle.moves.impl.RunAway;

/**
 * an implementation of BattleController.
 */
public class BattleControllerImpl implements BattleController {

    @Override
    public final void handleRunAway(final BattleManager battleManager, final Battle battle) {
        final Move runAway = new RunAway();
        runAway.action(battle, battleManager);
    }

    @Override
    public void handleAttack(final Skill skill) {
    }
}
