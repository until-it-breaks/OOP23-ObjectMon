package it.unibo.objectmon.model.battle.moves.impl;

import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.api.BattleManager.Result;
import it.unibo.objectmon.model.battle.moves.api.Move;

/**
 * Player leave the battle.
 */
public class RunAway implements Move {
    private final BattleManager battleManager;
    /**
     * constructor that RunAway has to use battleManager to end the battle.
     * @param battleManager
     */
    public RunAway(final BattleManager battleManager) {
        this.battleManager = battleManager;
    }
    @Override
    public final void action() {
        this.battleManager.setResult(Result.LOSE);
    }
}
