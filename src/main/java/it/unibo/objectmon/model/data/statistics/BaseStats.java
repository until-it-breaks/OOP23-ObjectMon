package it.unibo.objectmon.model.data.statistics;

import java.util.Map;

import it.unibo.objectmon.api.data.statistics.StatId;

/**
 * Extension of the class StatsImpl.
 * This implementation is used for storing the base Stats of the Objectmon
 * and so can only be read for comparison or to generate an Objectmon.
 */
public class BaseStats extends StatsImmutableImpl {

    /**
     * Constructor of the class.
     * @param stats Map of all the stats.
     */
    public BaseStats(final Map<StatId, Integer> stats) {
        super(stats);
    }

}
