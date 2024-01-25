package it.unibo.objectmon.model.entity.api;

public interface Npc extends Entity{

    void handleInteraction(Player player);

    NpcType getNpcType();
}