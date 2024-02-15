package it.unibo.objectmon.model.ai.api;

import org.apache.commons.lang3.tuple.ImmutablePair;

import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.moves.type.Move;
/**
 * choose the move of ai to execute.
 */
public interface ChooseMove {
    /**
     * choose ai move with his algorithm.
     * @param battle the current battle.
     * @return a pair with type and index of the type.
     */
    ImmutablePair<Move, Integer> chooseAiMove(Battle battle);
}
