package it.unibo.objectmon.model.battle.moves.impl;

import java.util.Optional;

import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.api.BattleManager.Result;

/**
 * Player leave the battle.
 */
public class RunAway {
    /**
     * .
     * @param battle
     * @param battleManager
     */
    public final void action(final Battle battle, final BattleManager battleManager) {
        if (this.runnable(battle)) {
            battleManager.setResult(Result.LOSE);
        }
    }
    /**
     * if player can run away.
     * @param battle 
     * @return true if there is no trainer in the battle.
     */
    private boolean runnable(final Battle battle) {
        return battle.getTrainer().equals(Optional.empty());
    }
}
