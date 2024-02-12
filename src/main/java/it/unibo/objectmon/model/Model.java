package it.unibo.objectmon.model;

import java.util.Optional;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.core.GameContext;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogger;
import it.unibo.objectmon.model.misc.collision.api.CollisionManager;
import it.unibo.objectmon.model.misc.interaction.api.InteractionManager;

/**
 * Represents the game model.
 * It's responsible for managing entities, interactions, collisions,
 * and battles within the game.
 * The model initializes with default settings and
 * provides access to various managers for handling different aspects of the game.
 */
public interface Model {

    /**
     * Retrieves the interaction manager,
     * which is responsible for managing interactions between entities in the game.
     *
     * @return The interaction manager.
     */
    InteractionManager getInteractionManager();

    /**
     * Retrieves the collision checker
     * which is responsible for detecting collisions between entities in the game.
     *
     * @return The collision checker.
     */
    CollisionManager getCollisionManager();

    /**
     * Retrieves the game context that
     * contains information about the game world, players, and NPCs.
     *
     * @return The game context.
     */
    GameContext getGameContext();

    /**
     * Retrieves the current game state.
     * @return The game state.
     */
    GameState getGameState();

    /**
     * Updates the game state.
     * @param gameState The new game state.
     */
    void setGameState(GameState gameState);

    /**
     * informations of the battle.
     * @return contains the informations of the battle.
     */
    Optional<Battle> getBattleStats();

    /**
     * Stores a battle move.
     * @param move The move to be stored.
     * @param index The index of that move type.
     */
    void bufferCommand(Move move, int index);

    /**
     * get Battle logger.
     * @return logger of battle
     */
    BattleLogger getBattleLogger();
}
