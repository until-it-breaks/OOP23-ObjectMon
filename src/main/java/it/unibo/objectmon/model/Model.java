package it.unibo.objectmon.model;

import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.misc.collision.api.CollisionChecker;
import it.unibo.objectmon.model.misc.interaction.api.InteractionManager;

/**
 * Represents the game model, responsible for managing entities, interactions, collisions, and battles within the game.
 * The model initializes with default settings and provides access to various managers for handling different aspects of the game.
 */
public interface Model {

    /**
     * Initializes the game model with default settings, including entities and environment.
     */
    void initialize();

    /**
     * Retrieves the interaction manager responsible for managing interactions between entities in the game.
     * 
     * @return The interaction manager.
     */
    InteractionManager getInteractionManager();

    /**
     * Retrieves the collision checker responsible for detecting collisions between entities in the game.
     * 
     * @return The collision checker.
     */
    CollisionChecker getCollisionChecker();

    /**
     * Retrieves the battle manager responsible for managing battles between entities in the game.
     * 
     * @return The battle manager.
     */
    BattleManager getBattleManager();

    /**
     * Retrieves the game context containing information about the game world, players, and NPCs.
     * 
     * @return The game context.
     */
    GameContext getGameContext();
}
