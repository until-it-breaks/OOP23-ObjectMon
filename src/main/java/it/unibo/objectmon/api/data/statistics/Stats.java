package it.unibo.objectmon.api.data.statistics;

import java.util.Map;

/**
 * Interface of Statistics.
 */
public interface StatisticsImpl {

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

    /**
     *
     * @param id Id of the Statistic to be replaced.
     * @param value New value of the Statistic.
     */
    void setSingleStat(StatId id, int value);

    /**
     *
     * @param value New value of all the Statistics.
     */
    void setAllStats(int value);

    /**
     *
     * @param id Id of the statistic to increase
     * @param growth Value to which increase the Statistic
     */
    void growSingleStat(StatId id, int growth);

    /**
     * 
     * @param growth Value to which increase all the Stats
     */
    void growAllStats(int growth);

}
