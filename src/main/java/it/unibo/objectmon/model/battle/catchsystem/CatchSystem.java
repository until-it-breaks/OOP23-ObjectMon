package it.unibo.objectmon.model.battle.catchsystem;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;

/**
 * the system to calculate the probability to catch the wild objectmon.
 */
public interface CatchSystem {
    /**
     * method says if the wild objectmon is caught.
     * @param catchRateMultiplier multiplier of a ball
     * @param objectmon target to be caught
     * @return if wild objectmon is caught returns true
     */
    boolean isCaught(double catchRateMultiplier, Objectmon objectmon);
}
