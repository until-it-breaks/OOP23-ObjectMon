package it.unibo.objectmon.model.data.api.objectmon;

import java.util.List;

/**
 * An Objectmon party to be used by player and trainer in the battle.
 * the party can add, remove and switch position of objecmons
 */
public interface ObjectmonParty {

    /**
     * add an objectmon to the party.
     * 
     * @param objectmon objectmon to be added
     * @return is objectmon is added correctly
     */
    boolean add(Objectmon objectmon);

    /**
     * remove an objectmon from the party.
     * 
     * @param objectmon objectmon to be removed
     * @return is objectmon is removed correctly
     */
    boolean remove(Objectmon objectmon);

    /**
     * change position of 2 objecmon in the party.
     * 
     * @param objectmon1 an objectmon in the party
     * @param objectmon2 another objectmon in the party
     */
    void switchPosition(Objectmon objectmon1, Objectmon objectmon2);

    /**
     * get an unmodifiable list of objectmon party.
     * 
     * @return unmodifiable list of objecmon
     */
    List<Objectmon> getParty();
}
