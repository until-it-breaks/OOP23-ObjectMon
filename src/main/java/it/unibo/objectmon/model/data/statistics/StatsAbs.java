package it.unibo.objectmon.model.data.statistics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import it.unibo.objectmon.model.data.api.statistics.StatEnum;
import it.unibo.objectmon.model.data.api.statistics.Stats;

/**
 * Abstract class of the interface Stats.
 */
public abstract class StatsAbs implements Stats {

    private static final int BASE_VALUE = 50;

    /**
     * A Map containing all the battle relevant stats of the Objectmon.
     */
    private final Map<StatEnum, Integer> stats = new HashMap<>();

    /**
     * Constructor of the class.
     * 
     * @param stats Map of all the stats.
     */
    public StatsAbs(final Map<StatEnum, Integer> stats) {
        this.stats.put(StatEnum.HP, stats.get(StatEnum.HP));
        this.stats.put(StatEnum.ATK, stats.get(StatEnum.ATK));
        this.stats.put(StatEnum.DEF, stats.get(StatEnum.DEF));
        this.stats.put(StatEnum.SPATK, stats.get(StatEnum.SPATK));
        this.stats.put(StatEnum.SPDEF, stats.get(StatEnum.SPDEF));
        this.stats.put(StatEnum.SPD, stats.get(StatEnum.SPD));
    }

    /**
     * Constructor for the class for serialization.
     */
    public StatsAbs() {
        final int defaultStats = BASE_VALUE;
        this.stats.put(StatEnum.HP, defaultStats);
        this.stats.put(StatEnum.ATK, defaultStats);
        this.stats.put(StatEnum.DEF, defaultStats);
        this.stats.put(StatEnum.SPATK, defaultStats);
        this.stats.put(StatEnum.SPDEF, defaultStats);
        this.stats.put(StatEnum.SPD, defaultStats);
    }

    /**
     * Returns a map of stats.
     * 
     * @return Returns the Map of the Stats.
     */
    @Override
    public Map<StatEnum, Integer> getStats() {
        return Collections.unmodifiableMap(stats);
    }

    /**
     * Returns a single specific stat.
     * @param stat Id of the Statistic
     * @return The value of the Statistic
     */
    @Override
    public int getStat(final StatEnum stat) {
        return this.stats.get(stat);
    }
}
