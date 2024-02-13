package it.unibo.objectmon.model.data.statistics;

import java.util.HashMap;
import java.util.Map;
import it.unibo.objectmon.model.data.api.statistics.StatId;
import it.unibo.objectmon.model.data.api.statistics.Stats;

/**
 * Abstract class of the interface Stats.
 */
public abstract class StatsImpl implements Stats {

    /**
     * A Map containing all the battle relevant stats of the Objectmon.
     */
    private final Map<StatId, Integer> stats = new HashMap<>();

    /**
     * Constructor of the class.
     * 
     * @param stats Map of all the stats.
     */
    public StatsImpl(final Map<StatId, Integer> stats) {
        this.stats.put(StatId.HP, stats.get(StatId.HP));
        this.stats.put(StatId.ATK, stats.get(StatId.ATK));
        this.stats.put(StatId.DEF, stats.get(StatId.DEF));
        this.stats.put(StatId.SPATK, stats.get(StatId.SPATK));
        this.stats.put(StatId.SPDEF, stats.get(StatId.SPDEF));
        this.stats.put(StatId.SPD, stats.get(StatId.SPD));
    }

    /**
     * Constructor for the class for serialization.
     */
    public StatsImpl() {
        final int defaultStats = 50;
        this.stats.put(StatId.HP, defaultStats);
        this.stats.put(StatId.ATK, defaultStats);
        this.stats.put(StatId.DEF, defaultStats);
        this.stats.put(StatId.SPATK, defaultStats);
        this.stats.put(StatId.SPDEF, defaultStats);
        this.stats.put(StatId.SPD, defaultStats);
    }

    /**
     * Returns a map of stats.
     * 
     * @return Returns the Map of the Stats.
     */
    @Override
    public Map<StatId, Integer> getStats() {
        return Map.copyOf(this.stats);
    }

    /**
     * Returns a single specific stat.
     * @param id Id of the Statistic
     * @return The value of the Statistic
     */
    @Override
    public int getSingleStat(final StatId id) {
        return getStats().get(id);
    }

}
