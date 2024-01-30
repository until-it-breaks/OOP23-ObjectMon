package it.unibo.objectmon.model.item.api;

/**
 * Models a tool used to catch objectMons.
 */
public interface BallItem extends Item {
    
    /**
     * returns the catch multiplier rate.
     * @return catchRate
     */
    double getCatchMultiplier();
    
}
