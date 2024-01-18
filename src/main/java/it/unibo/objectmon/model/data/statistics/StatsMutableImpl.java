package it.unibo.objectmon.model.data.statistics;

import java.util.HashMap;
import java.util.Map;

import it.unibo.objectmon.api.data.statistics.StatId;
import it.unibo.objectmon.api.data.statistics.Stats;

/**
 * Abstract class that implements Stats. Used because the classes BaseStats and ActualStats share a lot of similarities.
 */
public abstract class StatsMutableImpl implements Stats {

    /**
     *  A Map containing all the battle relevant stats of the Objectmon.
     */
    private final Map<StatId, Integer> stats = new HashMap<>();

    /**
     * Constructor of the class.
     * @param stats Map of all the stats.
     */
    public StatsMutableImpl(final Map<StatId, Integer> stats) {
        this.stats.put(StatId.HP, stats.get(StatId.HP));
        this.stats.put(StatId.ATK, stats.get(StatId.ATK));
        this.stats.put(StatId.DEF, stats.get(StatId.DEF));
        this.stats.put(StatId.SPATK, stats.get(StatId.SPATK));
        this.stats.put(StatId.SPDEF, stats.get(StatId.SPDEF));
        this.stats.put(StatId.SPD, stats.get(StatId.SPD));
    }

    /**
     *
     * @return Returns the Map of the Stats.
     */
    //TODO make this mutable
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

}

