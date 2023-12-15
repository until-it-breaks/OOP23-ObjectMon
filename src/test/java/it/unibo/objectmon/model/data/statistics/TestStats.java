package it.unibo.objectmon.model.data.statistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.api.data.statistics.StatId;

/**
 * Tests on the class BaseStats.
 * A stat can be changed (on evolution) or can grow (on level up or by using an item).
 */
class TestStats {

    private static final Map<StatId, Integer> STATS = Map.of(
        StatId.HP, 50,
        StatId.ATK, 50,
        StatId.DEF, 50,
        StatId.SPATK, 50,
        StatId.SPDEF, 50,
        StatId.SPD, 50
    );
    private final StatsImpl base = new BaseStats(STATS);

    /**
     * Check that all the stats are assigned correcly.
     */
    @Test
    void testValues() {
        assertEquals(STATS.get(StatId.HP), base.getSingleStat(StatId.HP));
        assertEquals(STATS.get(StatId.ATK), base.getSingleStat(StatId.ATK));
        assertEquals(STATS.get(StatId.DEF), base.getSingleStat(StatId.DEF));
        assertEquals(STATS.get(StatId.SPATK), base.getSingleStat(StatId.SPATK));
        assertEquals(STATS.get(StatId.SPDEF), base.getSingleStat(StatId.SPDEF));
        assertEquals(STATS.get(StatId.SPD), base.getSingleStat(StatId.SPD));
    }
}
