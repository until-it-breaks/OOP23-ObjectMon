package it.unibo.objectmon.model.data.statistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.data.api.statistics.StatId;

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

    private static final Map<StatId, Integer> ONELEVEL = Map.of(
        StatId.HP, 60,
        StatId.ATK, 60,
        StatId.DEF, 60,
        StatId.SPATK, 60,
        StatId.SPDEF, 60,
        StatId.SPD, 60
    );

    private static final Map<StatId, Integer> TWOLEVELS = Map.of(
        StatId.HP, 72,
        StatId.ATK, 72,
        StatId.DEF, 72,
        StatId.SPATK, 72,
        StatId.SPDEF, 72,
        StatId.SPD, 72
    );

    private static final Map<StatId, Integer> EVOLUTION = Map.of(
        StatId.HP, 100,
        StatId.ATK, 120,
        StatId.DEF, 70,
        StatId.SPATK, 70,
        StatId.SPDEF, 90,
        StatId.SPD, 30
    );

    private final BaseStats base = new BaseStats(STATS);

    /**
     * Check that all the stats are assigned correcly.
     */
    @Test
    void testValues() {
        //baseStat test
        for (final var singleStat : StatId.values()) {
            assertEquals(STATS.get(singleStat), base.getSingleStat(singleStat));
        }

        //ActualStats test
        ActualStats growStats = new ActualStats(STATS);

        //One level
        int level = 1;
        growStats = growStats.calcNewStats(level);
        growStats.getStats().forEach((id, stat) -> {
            assertEquals(ONELEVEL.get(id), stat);
        });

        //reset
        growStats = new ActualStats(STATS);

        //2 levels
        level = 2;
        growStats = growStats.calcNewStats(level);
        growStats.getStats().forEach((id, stat) -> {
            assertEquals(TWOLEVELS.get(id), stat);
        });

        //Evolution test
        ActualStats evolution = new ActualStats(STATS);
        for (final var singleStat : StatId.values()) {
            assertEquals(STATS.get(singleStat), evolution.getSingleStat(singleStat));
        }
        evolution = new ActualStats(EVOLUTION);
        for (final var singleStat : StatId.values()) {
            assertEquals(EVOLUTION.get(singleStat), evolution.getStats().get(singleStat));
        }
    }
}
