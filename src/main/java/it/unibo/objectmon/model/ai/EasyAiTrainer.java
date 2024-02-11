package it.unibo.objectmon.model.ai;

import it.unibo.objectmon.model.ai.api.AiTrainer;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
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
    public int switchObjectmon(final ObjectmonParty team) {
        this.index++;
        return this.index < team.getParty().size() ? this.index : -1;
    }
}
