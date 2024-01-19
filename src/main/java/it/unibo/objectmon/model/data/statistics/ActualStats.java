package it.unibo.objectmon.model.data.statistics;

import java.util.Map;
import java.util.HashMap;
import it.unibo.objectmon.api.data.statistics.StatId;

/**
 * Extension of the class StatsImpl.
 * This implementation is used to store the change of stats of the Objectmon
 * (through evolution or level up).
 * The changes need to be saved in a new Map of Stats,
 * because leveling should be an action that rarely happens and
 * so creating a new object shouldn't be too taxing on the program.
 */
public class ActualStats extends StatsImpl {

    /**
     * Constructor of the class.
     * @param stats Map of all the stats.
     */
    public ActualStats(final Map<StatId, Integer> stats) {
        super(stats);
    }

     /**
     * Grows a single stat by adding it to the previous value.
     * It's an utility method.
     * @param id Id of the statistic to increase.
     * @param growth Value to which increase the Statistic.
     * @return Returns the new singleStat, which is the sum of the base and the growth.
     */
    public int growSingleStat(final StatId id, final int growth) {
        return getSingleStat(id) + growth;
    }

    /**
     * Grows all the Stats.
     * Should only be called when an Objectmon levels up.
     * @param growths A Map containing the Stats that are going to be added.
     * @return Returns the new Stats of the Objectmon after level up.
     */
    public ActualStats growAllStats(final Map<StatId, Integer> growths) {
        final Map<StatId, Integer> newStats = new HashMap<>();
        getStats().forEach((id, stat) -> {
            newStats.put(id, growSingleStat(id, growths.get(id)));
        });
        return new ActualStats(newStats);
    }
}
