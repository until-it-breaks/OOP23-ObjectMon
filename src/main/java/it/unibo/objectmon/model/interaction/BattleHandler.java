package it.unibo.objectmon.model.interaction;

import it.unibo.objectmon.model.entity.api.Player;

public class BattleHandler implements InteractionHandler {
    @Override
    public void handleInteraction(Player player) {
        System.out.println("Battle starts");
    }
    
}
