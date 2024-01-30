package it.unibo.objectmon.model.item.api;

/**
 * Models tool to heal objectMons.
 */
public interface HealItem extends Item {

    /**
     * returns the amount of HP that it can restore.
     * @return healPoint
     */
    int getHealPoints();

}
