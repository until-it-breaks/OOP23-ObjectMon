package it.unibo.objectmon.model.battle.catchsystem;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.statistics.StatId;
/**
 * a first version of catch system.
 */
public final class CatchSystemImpl implements CatchSystem {
    private final double random = Math.random();

    @Override
    public boolean isCaught(final double catchRateMultiplier, final Objectmon objectmon) {
        return random <= calculateCatchProbability(
                catchRateMultiplier, 
                objectmon.getCurrentHp(), 
                objectmon.getStats().getSingleStat(StatId.HP)
            );
    }

    private double calculateCatchProbability(final double catchRateMultiplier, final int currentHp, final int maxHp) {
        return (1 - currentHp / maxHp) * catchRateMultiplier;
    }
}
