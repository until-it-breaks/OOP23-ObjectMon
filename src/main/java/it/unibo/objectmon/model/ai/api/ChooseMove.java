package it.unibo.objectmon.model.ai.api;

import it.unibo.objectmon.model.battle.api.Battle;
/**
 * choose the move of ai to execute.
 */
public interface ChooseMove {
    /**
     * choose ai move with his algorithm.
     * @param battle the current battle.
     * @return index of that kind of move chosen.
     */
    int chooseAiMove(Battle battle);
}
