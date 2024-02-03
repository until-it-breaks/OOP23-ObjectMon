package it.unibo.objectmon.model.battle.moves.api;

import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;

/**
 * Move represents a possible move in the battle.
 */
public interface Move {
    /**
     * start the action of move selected.
     * @param battle the current battle.
     * @param battleManager which is managing the battle
     */
    void action(Battle battle, BattleManager battleManager);
}
