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
        StatId.HP, 20,
        StatId.ATK, 30,
        StatId.DEF, 100,
        StatId.SPATK, 150,
        StatId.SPDEF, 40,
        StatId.SPD, 55
    );

    private static final Map<StatId, Integer> ONELEVEL = Map.of(
        StatId.HP, 25,
        StatId.ATK, 34,
        StatId.DEF, 101,
        StatId.SPATK, 151,
        StatId.SPDEF, 43,
        StatId.SPD, 57
    );

    private static final Map<StatId, Integer> TWOLEVELS = Map.of(
        StatId.HP, 29,
        StatId.ATK, 37,
        StatId.DEF, 102,
        StatId.SPATK, 152,
        StatId.SPDEF, 46,
        StatId.SPD, 59
    );

    private static final Map<StatId, Integer> SEVENLEVELS = Map.of(
        StatId.HP, 51,
        StatId.ATK, 55,
        StatId.DEF, 109,
        StatId.SPATK, 159,
        StatId.SPDEF, 61,
        StatId.SPD, 67
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

        //7 levels
        final int sevenLevel = 7;
        growStats = growStats.calcNewStats(sevenLevel);
        growStats.getStats().forEach((id, stat) -> {
            assertEquals(SEVENLEVELS.get(id), stat);
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
