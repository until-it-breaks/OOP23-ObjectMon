package it.unibo.objectmon.model.data.api.statistics;

import java.util.Map;

/**
 * Interface of Statistics.
 * An Objectmon has 7 Stats:
 * Hp;
 * Atk;
 * Def;
 * SpAtk;
 * SpDef;
 * Spd.
 * {@see it.unibo.objectmon.api.data.statistics.StatId}
 *
 * The Stats of an Objectmon are modified when leveling up or upon evolution.
 * An Objectmon levels up when their Exp reaches 100.
 * When they do, each stat is multiplied by
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
