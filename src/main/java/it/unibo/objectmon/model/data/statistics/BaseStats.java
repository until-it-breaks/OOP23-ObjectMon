package it.unibo.objectmon.model.data.statistics;

import java.util.Map;
import it.unibo.objectmon.model.data.api.statistics.StatId;

/**
 * Extension of the class StatsImpl.
 * This implementation is used for storing the base Stats of the Objectmon
 * and so can only be read for comparison or to generate an Objectmon.
 */
public class BaseStats extends ActualStats {
    private static final long serialVersionUID = 2005L;

    /**
     * Constructor of the class.
     * @param stats Map of all the stats.
     */
    public BaseStats(final Map<StatId, Integer> stats) {
        super(stats);
    }

    /**
     * This method should not be used.
     * @param level {@link #it.unibo.objectmon.model.data.statistics.ActualStats}
     * @return Returns an error.
     */
    @Deprecated
    @Override
    public ActualStats calcNewStats(final int level) {
        throw new UnsupportedOperationException();
    }


}
