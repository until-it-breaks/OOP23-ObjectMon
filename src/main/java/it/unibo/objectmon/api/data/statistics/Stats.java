package it.unibo.objectmon.api.data.statistics;

import java.util.Map;

/**
 * Interface of Statistics.
 */
public interface Stats {

    /**
     *
     * @return Returns the Map of the stats.
     */
    Map<StatId, Integer> getStats();

    /**
     *
     * @param id Id of the Statistic
     * @return The value of the Statistic
     */
    int getSingleStat(StatId id);
}
