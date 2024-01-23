package it.unibo.objectmon.model.interaction;

import it.unibo.objectmon.model.entity.player.PlayerImpl;

public class BattleHandler implements InteractionHandler {
    @Override
    public void handleInteraction(PlayerImpl player) {
        System.out.println("Battle starts");
    }
    
}
