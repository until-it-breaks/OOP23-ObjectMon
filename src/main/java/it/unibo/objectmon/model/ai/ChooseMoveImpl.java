package it.unibo.objectmon.model.ai;

import it.unibo.objectmon.model.ai.api.AiTrainer;
import it.unibo.objectmon.model.ai.api.ChooseMove;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.entities.api.Trainer;
import org.apache.commons.lang3.tuple.ImmutablePair;
/**
 * a class which choose the move of ai.
 */
public final class ChooseMoveImpl implements ChooseMove {

    private final AiTrainer aiTrainer;
    /**
     * constructor.
     */
    public ChooseMoveImpl() {
        this.aiTrainer = new EasyAiTrainer();
    }

    @Override
    public ImmutablePair<Move, Integer> chooseAiMove(final Battle battle) {
        if (battle.getTrainer().isPresent()) {
            final Trainer trainer = battle.getTrainer().get();
            if (trainer.getObjectmonParty().getParty().get(0).getCurrentHp() <= 0) {
                battle.setEnemyMove(Move.SWITCH_OBJECTMON);
                return new ImmutablePair<>(Move.SWITCH_OBJECTMON, this.aiTrainer.switchObjectmon(trainer.getObjectmonParty()));
            }
        }
        battle.setEnemyMove(Move.ATTACK);
        return new ImmutablePair<Move, Integer>(Move.ATTACK, this.aiTrainer.useSkill(battle.getEnemyObjectmon()));
    }
}
