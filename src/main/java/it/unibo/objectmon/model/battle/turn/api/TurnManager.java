package it.unibo.objectmon.model.battle.turn.api;

import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.moves.UseMoves;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogger;
/**
 * manager of turns in the battle.
 */
public interface TurnManager {
    /**
     * start a new turn.
     * @param type type move of player.
     * @param index index of a type of move
     * @param battleManager manager of battle.
     * @param useMoves execute all type of moves.
     * @param logger logger that send message.
     */
    void startTurn(Move type, int index, BattleManager battleManager, UseMoves useMoves, BattleLogger logger);
}
