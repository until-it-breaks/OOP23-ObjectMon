package it.unibo.objectmon.model.entity.api;

import it.unibo.objectmon.model.entity.player.PlayerImpl;

public interface Npc {

    void handleInteraction(PlayerImpl player);

}