package it.unibo.objectmon.model.ai.api;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;

/**
 * AI controls trainer in the battle with player.
 */
public interface AiTrainer extends AiObjectmon {
    /**
     * switch objectmon when ai think it is necessary.
     * @param team team of the battle
     */
    void switchObjectmon(ObjectmonParty team);
} 
