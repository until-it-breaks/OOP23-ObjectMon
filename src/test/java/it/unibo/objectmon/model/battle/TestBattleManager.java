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
import it.unibo.objectmon.model.gamestate.api.GameStateManager;
import it.unibo.objectmon.model.world.api.Coord;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

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
        final GameStateManager gameStateManager = mock(GameStateManager.class);
        this.battleManager = new BattleManagerImpl((gameState) -> gameStateManager.setGameState(gameState));
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
        final int hp = player.getObjectmonParty().getParty().get(0).getCurrentHp();
        final int enemyHp = trainer.getObjectmonParty().getParty().get(0).getCurrentHp();
        battleManager.startBattle(player, Optional.of(trainer), Optional.empty());
        assertTrue(battleManager.bufferCommand(Move.ATTACK, 0));
        assertTrue(hp > player.getObjectmonParty().getParty().get(0).getCurrentHp());
        assertTrue(enemyHp > trainer.getObjectmonParty().getParty().get(0).getCurrentHp());
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
        final int hp = player.getObjectmonParty().getParty().get(0).getCurrentHp();
        final int enemyHp = objectmon.getCurrentHp();
        battleManager.startBattle(player, Optional.empty(), Optional.of(objectmon));
        assertTrue(battleManager.bufferCommand(Move.ATTACK, 0));
        assertTrue(hp > player.getObjectmonParty().getParty().get(0).getCurrentHp());
        assertTrue(enemyHp > objectmon.getCurrentHp());
        assertTrue(battleManager.bufferCommand(Move.SWITCH_OBJECTMON, 1));
        assertTrue(battleManager.bufferCommand(Move.RUN_AWAY, 0));
        battleManager.startBattle(player, Optional.of(trainer), Optional.empty());
    }

    @Test
    /**
     * test when player win vs wild objectmon.
     */
    void testWinWildObj() {
        final Objectmon objectmon = ObjectmonFactory.createObjectmon(ObjectmonEnum.ANORITH, 1);
        objectmon.setCurrentHp(-objectmon.getCurrentHp() + 1);
        battleManager.startBattle(player, Optional.empty(), Optional.of(objectmon));
        assertTrue(battleManager.bufferCommand(Move.ATTACK, 0));
        //check if battle is terminated when wild objectmon is dead.
        assertTrue(battleManager.getBattleStats().isEmpty());
    }

    /**
     * test when player win vs trainer.
     */
    @Test
    void testWinWithTrainer() {
        trainer.getObjectmonParty().getParty().stream().forEach(o -> o.setCurrentHp(-o.getCurrentHp() + 1));
        battleManager.startBattle(player, Optional.of(trainer), Optional.empty());
        assertTrue(battleManager.bufferCommand(Move.ATTACK, 0));
        assertTrue(battleManager.bufferCommand(Move.SWITCH_OBJECTMON, 1));
        final int hp = player.getObjectmonParty().getParty().get(0).getCurrentHp();
        //trainer's current objectmon is dead, so his next move should switch objectmon.
        assertEquals(hp, player.getObjectmonParty().getParty().get(0).getCurrentHp());
        assertTrue(battleManager.bufferCommand(Move.ATTACK, 0));
        //trainer has no more objectmon, so the battle is terminated.
        assertTrue(battleManager.getBattleStats().isEmpty());
    }

    /**
     * test when player lose the battle.
     */
    @Test
    void testPlayerLose() {
        this.player.getObjectmonParty().getParty().stream().forEach(o -> o.setCurrentHp(-o.getCurrentHp() + 1));
        battleManager.startBattle(player, Optional.of(trainer), Optional.empty());
        while (battleManager.getBattleStats().isPresent()) {
            if (!battleManager.bufferCommand(Move.ATTACK, 0)) {
                battleManager.bufferCommand(Move.SWITCH_OBJECTMON, 1);
            }
        }
        assertEquals(0, this.player.getObjectmonParty().getParty().size());
    }
}
//CHECKSTYLE: MagicNumber ON
