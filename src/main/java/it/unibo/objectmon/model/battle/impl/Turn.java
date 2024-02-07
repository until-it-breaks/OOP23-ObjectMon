package it.unibo.objectmon.model.battle.impl;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.api.data.statistics.StatId;
import it.unibo.objectmon.model.battle.moves.api.Move;

public final class Turn {
    private StatTurn stat;
    /**
     * stat turn of.
     */
    public enum StatTurn {
        /**
         * waiting player choose a move.
         */
        IS_WAITING_MOVE,
        /**
         * AI (trainer or Objectmon) can start to execute his move.
         */
        AI_TURN,
        /**
         * player can start execute his move.
         */
        PLAYER_TURN
    }
    public Turn() {
        this.stat = StatTurn.IS_WAITING_MOVE;
    }

    public StatTurn whichFirst(
            final Move moveAI, 
            final Move movePLayer,
            final Objectmon playerObjectmon,
            final Objectmon aiObjectmon
        ) {
            return moveAI.equals(Move.ATTACK)
            ? (movePLayer.equals(Move.ATTACK)
                ? whichUseSkillFirst(playerObjectmon, aiObjectmon)
                : StatTurn.PLAYER_TURN)
            : (movePLayer.equals(Move.ATTACK)
                ? StatTurn.AI_TURN
                : StatTurn.PLAYER_TURN);
    }

    public StatTurn whichUseSkillFirst(final Objectmon playerObjectmon, final Objectmon aiObjectmon) {
        return playerObjectmon.getStats().getSingleStat(StatId.SPD) 
            >= aiObjectmon.getStats().getSingleStat(StatId.SPD)
            ? StatTurn.PLAYER_TURN
            : StatTurn.AI_TURN;
    }

    public StatTurn getStat() {
        return this.stat;
    }

    public void setTurn(final StatTurn statTurn) {
        this.stat = statTurn;
    }
}
