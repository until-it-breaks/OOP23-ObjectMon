package it.unibo.objectmon.model.data.api.statistics;

import java.util.Map;

/**
 * Interface of Statistics.
 * An Objectmon has 6 Stats:
 * HP, Attack, Defense, SpecialAttack, SpecialDefense and Speed.
 * 
 * The stats of an Objectmon are modified once leveled up.
 */
public interface Stats {

    /**
     * Retrieves the map of stats.
     * 
     * @return Returns the map of stats.
     */
    Map<StatEnum, Integer> getStats();

    /**
     * Retrieves a single stat.
     * 
     * @param stat The stat of interest.
     * @return The value of the stat.
     */
    int getSingleStat(StatEnum stat);
}
