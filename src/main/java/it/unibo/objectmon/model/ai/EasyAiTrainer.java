package it.unibo.objectmon.model.ai;
import java.util.List;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.api.data.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.ai.api.AiTrainer;
/**
 * an implementation of ai trainer, 
 * which change the objectmon only if the current fighting objectmon is dead.
 */
public final class EasyAiTrainer extends EasyAiObjectmon implements AiTrainer {
    private int index;
    /**
     * Constructor.
     */
    public EasyAiTrainer() {
        this.index = 1;
    }

    @Override
    public List<Objectmon> switchObjectmon(final ObjectmonParty team) {
        team.switchPosition(team.getParty().get(0), team.getParty().get(this.index++));
        return team.getParty();
    }
}
