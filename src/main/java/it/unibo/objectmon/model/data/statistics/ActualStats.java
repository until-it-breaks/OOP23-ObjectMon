package it.unibo.objectmon.model.data.statistics;

import java.util.Map;

import it.unibo.objectmon.api.data.statistics.StatId;

/**
 * Extension of the class StatsImpl.
 * This implementation is used to store the change of stats of the Objectmon
 * (through evolution, an item or level up).
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
     * Sets one stat to the new value.
     * Should never be called directly by a user.
     * @param id Id of the Statistic to be replaced.
     * @param value New value of the Statistic.
     */
    protected void setSingleStat(final StatId id, final int value) {
        getStats().replace(id, value);
    }

    /**
     * Sets all the Stats to their new values.
     * Should only be used when an Objectmon evolves.
     * @param newStats A Map containing the new Stats to replace the current ones.
     */
    public void setAllStats(final Map<StatId, Integer> newStats) {
        getStats().forEach((id, stat) -> {
            setSingleStat(id, newStats.get(id));
        });
    }

    /**
     * Grows a single stat by adding it to the previous value.
     * Can be called directly by the user,
     * but only when using an Item that permits it.
     * @param id Id of the statistic to increase
     * @param growth Value to which increase the Statistic
     */
    public void growSingleStat(final StatId id, final int growth) {
        getStats().replace(id, getSingleStat(id) + growth);
    }

    /**
     * Grows all the Stats.
     * Should only be called when an Objectmon levels up.
     * @param growths A Map containing the Stats that are going to be added.
     */
    public void growAllStats(final Map<StatId, Integer> growths) {
        getStats().forEach((id, stat) -> {
            growSingleStat(id, growths.get(id));
        });
    }
}
