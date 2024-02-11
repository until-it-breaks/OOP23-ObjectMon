package it.unibo.objectmon.model.ai.api;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;

/**
 * objectmon control by AI.
 */
public interface AiObjectmon {
    /**
     * which skill to be used chosen by AI.
     * @param objectmon use skill of this objectmon.
     * @return index of skill to be used.
     */
    int useSkill(Objectmon objectmon);
}
