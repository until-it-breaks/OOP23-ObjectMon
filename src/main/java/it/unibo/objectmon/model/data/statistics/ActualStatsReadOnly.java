package it.unibo.objectmon.model.data.statistics;

import java.util.Collections;
import java.util.Map;

import it.unibo.objectmon.model.data.api.statistics.StatId;
import it.unibo.objectmon.model.data.api.statistics.Stats;

/**
 * A {@link ActualStats} wrapper that only expose getters.
 */
public final class ActualStatsReadOnly implements Stats {

    private final ActualStats actualStats;

    /**
     * The {@link ActualStats} to be made read-only.
     * 
     * @param actualStats The ActualStats to be wrapped.
     */
    public ActualStatsReadOnly(final ActualStats actualStats) {
        this.actualStats = actualStats;
    }

    @Override
    public Map<StatId, Integer> getStats() {
        return Collections.unmodifiableMap(actualStats.getStats());
    }

    @Override
    public int getSingleStat(final StatId id) {
        return actualStats.getSingleStat(id);
    }
}
