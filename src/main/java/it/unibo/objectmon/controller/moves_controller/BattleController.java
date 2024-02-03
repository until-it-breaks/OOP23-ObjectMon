package it.unibo.objectmon.controller.moves_controller;

import it.unibo.objectmon.model.battle.api.BattleManager;

/**
 * view through this controller to choose which move to act.
 */
public interface BattleController {
    /**
     * when player choose run away the battle.
     * @param battleManager manager of the current battle
     * @return if player can run away or not.
     */
    void handleRunAway(BattleManager battleManager);
}
