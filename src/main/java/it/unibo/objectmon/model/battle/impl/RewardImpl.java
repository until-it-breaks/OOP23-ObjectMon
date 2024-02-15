package it.unibo.objectmon.model.battle.impl;

import it.unibo.objectmon.model.battle.api.Reward;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
/**
 * an implementation of reward.
 */
public final class RewardImpl implements Reward {
    private static final int EXP = 10;
    private static final int CREDITS = 1000;

    @Override
    public int upgradeEXP(final ObjectmonParty enemParty) {
        return enemParty.getParty().stream().mapToInt(o -> o.getLevel() * EXP).sum();
    }

    @Override
    public int getCredits() {
        return CREDITS;
    }

    @Override
    public int upgradeEXP() {
        return EXP;
    }
}
