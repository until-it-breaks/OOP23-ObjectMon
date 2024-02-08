package it.unibo.objectmon.model.battle.impl;

import java.util.Optional;

import it.unibo.objectmon.model.ai.EasyAiTrainer;
import it.unibo.objectmon.model.ai.api.AiTrainer;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.data.api.statistics.StatId;
import it.unibo.objectmon.model.data.objectmon.ObjectmonPartyImpl;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.api.npc.Trainer;
/**
 * A simple battle that implements Battle.
 */
public final class BattleImpl implements Battle {
    private final Player player;
    private final Optional<Trainer> trainer;
    private final Optional<Objectmon> wildObjectmon;
    private final AiTrainer aiTrainer;
    private Move playerMove;
    private Move enemyMove;
    /**
     * 
     * @param player player in the battle.
     * @param trainer trainer to be defeated by player
     * @param objectmon wild objectmon
     */
    public BattleImpl(final Player player, final Optional<Trainer> trainer, final Optional<Objectmon> objectmon) {
        this.player = player;
        this.trainer = trainer;
        this.wildObjectmon = objectmon;
        this.aiTrainer = new EasyAiTrainer();
        this.playerMove = Move.NOT_IN_FIGHT;
        this.enemyMove = Move.NOT_IN_FIGHT;
    }
    /**
     * constructor of battle between the player and trainer.
     * @param player player in the battle
     * @param trainer trainer to be defeated by player
     */
    public BattleImpl(final Player player, final Trainer trainer) {
        this(player, Optional.of(trainer), Optional.empty());
    }
    /**
     * constructor of battle between the player and wild objectmon.
     * @param player player in the battle 
     * @param objectmon wild objectmon
     */
    public BattleImpl(final Player player, final Objectmon objectmon) {
        this(player, Optional.empty(), Optional.of(objectmon));
    }

    @Override
    public boolean isWin() {
        return this.trainer.get().isDefeated() && !this.player.isDefeated() 
        || this.wildObjectmon.get().getStats().getSingleStat(StatId.HP) <= 0;
    }

    @Override
    public Move getPlayerMove() {
        return this.playerMove;
    }

    @Override
    public void setPlayerMove(final Move move) {
        this.playerMove = move;
    }

    @Override
    public void setEnemyMove() {
        if (this.wildObjectmon.get().getCurrentHp() <= 0) {
            this.trainer.ifPresent(t -> {
                this.aiTrainer.switchObjectmon(t.getObjectmonParty());
                this.enemyMove = Move.SWITCH_OBJECTMON;
            });
        }
        this.aiTrainer.useSkill(getEnemyObjectmon());
        this.enemyMove = Move.ATTACK;
    }

    @Override
    public Move getEnemyMove() {
        return this.enemyMove;
    }

    @Override
    public Objectmon getCurrentObjectmon() {
        return this.player.getObjectmonParty().getParty().get(0);
    }

    @Override
    public Objectmon getEnemyObjectmon() {
        return this.trainer.isEmpty() 
        ? this.wildObjectmon.get() 
        : this.trainer.get().getObjectmonParty().getParty().get(0);
    }
    @Override
    public Optional<Trainer> getTrainer() {
        return this.trainer;
    }
    @Override
    public Optional<ObjectmonParty> getTrainerTeam() {
        return this.trainer.isPresent()
            ? Optional.of(this.trainer.get().getObjectmonParty())
            : Optional.empty();
    }

    @Override
    public ObjectmonParty getPlayerTeam() {
        return new ObjectmonPartyImpl(this.player.getObjectmonParty().getParty());
    }
}
