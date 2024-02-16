package it.unibo.objectmon.model.battle;

import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.battle.api.BattleInitiator;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.api.BattleManager.Result;
import it.unibo.objectmon.model.battle.impl.BattleManagerImpl;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Trainer;
import it.unibo.objectmon.model.entities.npc.TrainerImpl;
import it.unibo.objectmon.model.entities.player.PlayerImpl;
import it.unibo.objectmon.model.gamestate.GameStateManagerImpl;
import it.unibo.objectmon.model.world.api.Coord;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Optional;
/**
 * test battle manager if it can start battle correctly and receive command from user.
 */
//magic number are not important for battle manager test.
//CHECKSTYLE: MagicNumber OFF
class TestBattleManager {
    private final BattleManager battleManager;
    private final Player player;
    private final Trainer trainer;
    private final Objectmon objectmon;
    /**
     * constructor.
     */
    TestBattleManager() {
        this.battleManager = new BattleManagerImpl(new GameStateManagerImpl());
        final Coord position = new Coord(5, 5);
        player = new PlayerImpl(
            "yous",
            new Coord(5, 6), 
            new ArrayList<>(ObjectmonFactory.createObjectmonSet(List.of(
                    ObjectmonEnum.ANORITH,
                    ObjectmonEnum.KECLEON,
                    ObjectmonEnum.MUDKIP,
                    ObjectmonEnum.GOLDEEN
                ), 
            3)));
        final BattleInitiator battleInitiator = (player, trainer, objectmon) -> {
            battleManager.startBattle(player, trainer, objectmon);
        };
            trainer = new TrainerImpl(
                "Trainer Bob", 
                position, 
                new ArrayList<>(ObjectmonFactory.createObjectmonSet(List.of(
                    ObjectmonEnum.ILLUMISE,
                    ObjectmonEnum.LILEEP),
                    10)),
                battleInitiator
            );
        objectmon = ObjectmonFactory.createObjectmon(ObjectmonEnum.KECLEON, 0);
    }
    /**
     * test battle with a trainer.
     */
    @Test
    void testBattlerWithTrainer() {
        battleManager.startBattle(player, Optional.of(trainer), Optional.empty());
        assertTrue(battleManager.bufferCommand(Move.ATTACK, 0));
        assertFalse(battleManager.bufferCommand(Move.RUN_AWAY, 0));
        assertTrue(battleManager.bufferCommand(Move.SWITCH_OBJECTMON, 1));
        assertFalse(battleManager.bufferCommand(Move.SWITCH_OBJECTMON, 0));
        assertThrows(IllegalStateException.class, () -> {
            battleManager.startBattle(player, Optional.empty(), Optional.of(objectmon));
        });
        battleManager.setResult(Result.END);
        battleManager.endBattleAction();
    }
    /**
     * test battle with a wild objectmon.
     */
    @Test
    void testBattleWithWildObj() {
        battleManager.startBattle(player, Optional.empty(), Optional.of(objectmon));
        assertTrue(battleManager.bufferCommand(Move.ATTACK, 0));
        assertTrue(battleManager.bufferCommand(Move.SWITCH_OBJECTMON, 1));
        assertTrue(battleManager.bufferCommand(Move.RUN_AWAY, 0));
    }
}
//CHECKSTYLE: MagicNumber ON
