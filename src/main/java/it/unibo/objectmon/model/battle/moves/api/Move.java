package it.unibo.objectmon.model.battle.moves.api;

import it.unibo.objectmon.model.battle.api.BattleManager;

/**
 * Move represents a possible move in the battle.
 */
public interface Move {
    /**
     * start the action of move selected.
     * @param battleManager which is managing the battle
     */
    void action(BattleManager battleManager);
}
