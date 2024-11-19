package it.unibo.objectmon.model;

import java.util.Optional;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.core.GameContext;
import it.unibo.objectmon.model.gamestate.EndGameManager;
import it.unibo.objectmon.model.encounters.api.RandomEncounterManager;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogger;
import it.unibo.objectmon.model.misc.collision.api.CollisionManager;
import it.unibo.objectmon.model.misc.interaction.api.InteractionManager;

/**
 * Responsible for managing entities, interactions, collisions,
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
     * 
     * @return The game state.
     */
    GameState getGameState();

    /**
     * Updates the game state.
     * 
     * @param gameState The new game state.
     */
    void setGameState(GameState gameState);

    /**
     * Returns information about a battle.
     * 
     * @return The information of a battle.
     */
    Optional<Battle> getBattleStats();

    /**
     * Stores a battle related move.
     * 
     * @param move The move to be stored.
     * @param index The index indicating the move type.
     */
    void bufferCommand(Move move, int index);

    /**
     * Retrieves the battle logger.
     * 
     * @return The battle logger.
     */
    BattleLogger getBattleLogger();

    /**
     * Retrieves the trade manager.
     * 
     * @return The trade manager
     */
    TradeManager getTradeManager();

    /**
     * Retrieves the endgame manager.
     * 
     * @return Returns the end game manager.
     */
    EndGameManager getEndGameManager();

    /**
     * Retrieves the random encounter manager.
     * 
     * @return The random encounter manager.
     */
    RandomEncounterManager getRandomEncounterManager();
}
