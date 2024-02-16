package it.unibo.objectmon.model.battle.turn.api;

import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.api.LoggerAction;
import it.unibo.objectmon.model.battle.moves.UseMoves;
import it.unibo.objectmon.model.battle.moves.type.Move;
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
     * @param count current number of turn in the current battle
     */
    void startTurn(Move type, int index, BattleManager battleManager, UseMoves useMoves, LoggerAction logger, int count);
}
