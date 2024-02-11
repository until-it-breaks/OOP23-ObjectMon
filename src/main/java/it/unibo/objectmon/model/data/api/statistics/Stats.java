package it.unibo.objectmon.model.data.api.statistics;

import java.util.Map;

/**
 * Interface of Statistics.
 * <br>An Objectmon has 6 Stats:
 * <br>Hp, that determines the max Heal Points of an Objectmon;
 * <br>Atk, that determines the attack of an Objectmon;
 * <br>Def, that determines the defense of an Objectmon;
 * <br>SpAtk, that determines the special attack of an Objectmon;
 * <br>SpDef, that determines the special defense of an Objectmon;
 * <br>Spd, that determines the speed of an Objectmon.
 * <br>
 * <br>The Stats of an Objectmon are modified when leveling up.
 * <br>An Objectmon levels up when their Exp reaches 100 or more.
 * <br>When they do, each stat is multiplied by the STATGROWTHVARIATION.
 */
public interface Stats {

    /**
     * Getter of the Map of the Stats.
     * @return Returns the Map of the stats.
     */
    Map<StatId, Integer> getStats();

    /**
     * Getter of a single stat of Stats.
     * @param id Id of the Statistic
     * @return The value of the Statistic
     */
    int getSingleStat(StatId id);
}
