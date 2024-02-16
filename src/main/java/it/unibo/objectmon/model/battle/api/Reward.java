package it.unibo.objectmon.model.battle.api;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
/**
 * reward to give to player when player win the fight.
 */
public interface Reward {
    /**
     * calculate how much xp to add to player's objectmon.
     * @param enemParty party defeated by player
     * @return the xp to add to every objectmon of player.
     */
    int upgradeEXP(ObjectmonParty enemParty);
    /**
     *  xp to add to player's objectmon.
     * @return the xp to add to every objectmon of player.
     */
    int upgradeEXP();
    /**
     * 
     * @return credits to give to the player.
     */
    int getCredits();
}
