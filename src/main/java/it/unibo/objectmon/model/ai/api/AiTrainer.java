package it.unibo.objectmon.model.ai.api;

import java.util.List;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
import it.unibo.objectmon.api.data.objectmon.ObjectmonParty;
/**
 * AI controls trainer in the battle with player.
 */
public interface AiTrainer extends AiObjectmon {
    /**
     * switch objectmon when ai think it is necessary.
     * @param team team in the battle.
     * @return team with objecmon position changed.
     */
    List<Objectmon> switchObjectmon(ObjectmonParty team);
} 
