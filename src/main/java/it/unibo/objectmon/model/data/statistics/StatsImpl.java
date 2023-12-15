package it.unibo.objectmon.model.data.statistics;

import java.util.HashMap;
import java.util.Map;
import it.unibo.objectmon.api.data.statistics.StatId;
import it.unibo.objectmon.api.data.statistics.Stats;

/**
 *  Implementation of the class Stats.
 */
public class StatsImpl implements Stats {
    /**
     *  A Map containing all the battle relevant stats of the Objectmon.
     */
    private final Map<StatId, Integer> stats = new HashMap<>();

    /**
     *
     * @param hp {@see #it.unibo.objectmon.api.data.statistics.StatId}.
     * @param atk {@see #it.unibo.objectmon.api.data.statistics.StatId}.
     * @param def {@see #it.unibo.objectmon.api.data.statistics.StatId}.
     * @param spAtk {@see #it.unibo.objectmon.api.data.statistics.StatId}.
     * @param spDef {@see #it.unibo.objectmon.api.data.statistics.StatId}.
     * @param spd {@see #it.unibo.objectmon.api.data.statistics.StatId}.
     */
    public StatsImpl(
        final int hp,
        final int atk,
        final int def,
        final int spAtk,
        final int spDef,
        final int spd
        ) {
        this.stats.put(StatId.HP, hp);
        this.stats.put(StatId.ATK, atk);
        this.stats.put(StatId.DEF, def);
        this.stats.put(StatId.SPATK, spAtk);
        this.stats.put(StatId.SPDEF, spDef);
        this.stats.put(StatId.SPD, spd);
    }

    /**
     *
     * @return Returns the Map of the Stats.
     */
    @Override
    public Map<StatId, Integer> getStats() {
        return Map.copyOf(this.stats);
    }

    /**
     *
     * @param id Id of the Statistic
     * @return The value of the Statistic
     */
    @Override
    public int getSingleStat(final StatId id) {
        return getStats().get(id);
    }

    /**
     *
     * @param id Id of the Statistic to be replaced.
     * @param value New value of the Statistic.
     */
    @Override
    public void setSingleStat(final StatId id, final int value) {
        getStats().replace(id, value);
    }

    /**
     *
     * @param value New value of all the Statistics.
     */
    @Override
    public void setAllStats(final int value) {
        getStats().forEach((id, stat) -> {
            setSingleStat(id, value);
        });
    }

    /**
     *
     * @param id Id of the statistic to increase
     * @param growth Value to which increase the Statistic
     */
    @Override
    public void growSingleStat(final StatId id, final int growth) {
        getStats().replace(id, getSingleStat(id) + growth);
    }

    /**
     * 
     * @param growth Value to which increase all the Stats
     */
    @Override
    public void growAllStats(final int growth) {
        getStats().forEach((id, stat) -> {
            growSingleStat(id, growth);
        });
    }
}
