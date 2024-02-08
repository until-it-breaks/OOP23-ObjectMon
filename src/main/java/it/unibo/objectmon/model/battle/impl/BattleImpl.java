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
    private final Optional<Objectmon> objectmon;
    private final AiTrainer aiTrainer;
    private int objectmonHP;
    private int enemyHP;
    private Move playerMove;
    private Move enemyMove;
    /**
     * constructor of battle between the player and trainer.
     * @param player player in the battle
     * @param trainer trainer to be defeated by player
     */
    public BattleImpl(final Player player, final Trainer trainer) {
        this.player = player;
        this.trainer = Optional.of(trainer);
        this.objectmon = Optional.of(trainer.getObjectmonParty().getParty().get(0));
        this.objectmonHP = player.getObjectmonParty().getParty().get(0).getStats().getSingleStat(StatId.HP);
        this.enemyHP = trainer.getObjectmonParty().getParty().get(0).getStats().getSingleStat(StatId.HP);
        this.aiTrainer = new EasyAiTrainer();
    }
    /**
     * constructor of battle between the player and wild objectmon.
     * @param player player in the battle 
     * @param objectmon wild objectmon
     */
    public BattleImpl(final Player player, final Objectmon objectmon) {
        this.player = player;
        this.objectmon = Optional.of(objectmon);
        this.trainer = Optional.empty();
        this.aiTrainer = new EasyAiTrainer();
    }

    @Override
    public boolean isWin() {
        return this.trainer.get().isDefeated() && !this.player.isDefeated() 
        || this.objectmon.get().getStats().getSingleStat(StatId.HP) <= 0;
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
        if (this.getEnemyHP() <= 0) {
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
        ? this.objectmon.get() 
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
    public ObjectmonParty getTeam() {
        return new ObjectmonPartyImpl(this.player.getObjectmonParty().getParty());
    }
    @Override
    public int getObjectmonHP() {
        return this.objectmonHP;
    }
    @Override
    public int getEnemyHP() {
        return this.enemyHP;
    }
    @Override
    public void setObjectomHP(final int hp) {
        this.objectmonHP = hp;
    }
    @Override
    public void setEnemyHP(final int hp) {
        this.enemyHP = hp;
    }
}
