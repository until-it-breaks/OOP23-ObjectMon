package it.unibo.objectmon.model.battle.moves.impl;

import java.util.Optional;

import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.api.BattleManager.Result;
import it.unibo.objectmon.model.battle.moves.api.Move;

/**
 * Player leave the battle.
 */
public class RunAway implements Move {
    @Override
    public final void action(final BattleManager battleManager) {
        if (this.runnable(battleManager.getBattle())) {
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
