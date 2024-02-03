package it.unibo.objectmon.controller.moves;

import it.unibo.objectmon.model.battle.api.BattleManager;

/**
 * view through this controller to choose which move to act.
 */
public interface BattleController {
    /**
     * when player choose run away the battle.
     * @param battleManager manager of the current battle
     */
    void handleRunAway(BattleManager battleManager);
}
