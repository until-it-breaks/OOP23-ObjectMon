package it.unibo.objectmon.model.data.statistics;

import java.util.Map;
import it.unibo.objectmon.model.data.api.statistics.StatEnum;

/**
 * Extension of the class StatsImpl.
 * This implementation is used for storing the base Stats of the Objectmon
 * and so can only be read for comparison or to generate an Objectmon.
 */
public class BaseStats extends StatsAbs {

    /**
     * Constructor of the class.
     * 
     * @param stats Map of all the stats.
     */
    public BaseStats(final Map<StatEnum, Integer> stats) {
        super(stats);
    }
}
