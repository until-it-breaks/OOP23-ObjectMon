package it.unibo.objectmon.model.entity.api;
/**
 * Enum representing all the npc types.
 */
public enum NpcType {
    /**
     * An npc with battling capabilities.
     */
    TRAINER,
    /**
     * An npc able to buy and sell items.
     */
    TRADER,
    /**
     * An npc that heals the player's party.
     */
    HEALER,
    /**
     * An npc without any particular behaviour.
     */
    GENERIC
}
