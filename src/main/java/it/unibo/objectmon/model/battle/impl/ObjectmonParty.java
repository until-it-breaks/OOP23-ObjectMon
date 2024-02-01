package it.unibo.objectmon.model.battle.impl;

import it.unibo.objectmon.api.data.objectmon.Objectmon;
/**
 * An Objectmon party to be used by player and trainer in the battle.
 */
public interface ObjectmonParty {
    /**
     * add an objectmon to the party.
     * @param objectmon objectmon to be added
     * @return is objectmon is added correctly
     */
    boolean add(Objectmon objectmon);
    /**
     * remove an objectmon from the party.
     * @param objectmon objectmon to be removed
     * @return is objectmon is removed correctly
     */
    boolean remove(Objectmon objectmon);
    /**
     * switch from new objectmon to the position of old Objectmon in the party.
     * @param newObjectmon objectmon to be swap-in in the party
     * @param oldObjectmon objectmon to be swap-out from the party 
     */
    void replace(Objectmon newObjectmon, Objectmon oldObjectmon);
}
