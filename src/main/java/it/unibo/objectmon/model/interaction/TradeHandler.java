package it.unibo.objectmon.model.interaction;

import it.unibo.objectmon.model.entity.api.Player;

public class TradeHandler implements InteractionHandler {
    @Override
    public void handleInteraction(Player player) {
        System.out.println("Trade started");
    }
    
}
