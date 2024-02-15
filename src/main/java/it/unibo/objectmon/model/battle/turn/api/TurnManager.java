package it.unibo.objectmon.model.battle.turn.api;

import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.moves.UseMoves;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogger;

public interface TurnManager {

    void startTurn(Move type, int index, BattleManager battleManager, UseMoves useMoves, BattleLogger logger);
}
