package it.unibo.objectmon.model;

import java.util.Optional;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.impl.ReadOnlyBattle;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.core.GameContext;
import it.unibo.objectmon.model.encounters.api.RandomEncounterManager;
import it.unibo.objectmon.model.gamestate.EndGameManager;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.gamestate.GameStateManager;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogger;
import it.unibo.objectmon.model.misc.collision.api.CollisionManager;
import it.unibo.objectmon.model.misc.interaction.api.InteractionManager;

/**
 * Manages the game model logic, including entities, interactions, collisions, and battles.
 * This class initializes the game model with default settings and provides access to various managers
 * that are responsible for handling different aspects of the game.
 */
public final class ModelImpl implements Model {
    private final GameContext gameContext;
    private final InteractionManager interactionManager;
    private final CollisionManager collisionManager;
    private final BattleManager battleManager;
    private final GameStateManager gameStateManager;
    private final TradeManager tradeManager;
    private final EndGameManager endGameManager;
    private final RandomEncounterManager randomEncounterManager;

    /**
     * Constructs a ModelImpl instance with the provided dependencies.
     *
     * @param gameContext                   The game context containing information about the game world and entities.
     * @param interactionManager            The manager responsible for handling interactions within the game.
     * @param collisionManager              The manager responsible for collision detection.
     * @param battleManager                 The manager responsible for handling battles between entities.
     * @param gameStateManager              The manager responsible for managing the game state.
     * @param tradeManager                  The manager responsible for managing the trade mode.
     * @param endGameManager                The manager responsible for triggering the END game state.
     * @param randomEncounterManagerImpl    The manager responsible for triggering random encounters.
     * 
     */
    @SuppressFBWarnings(value = "EI2", justification = "Allowing mutable objects to be stored for flexibility")
    public ModelImpl(final GameContext gameContext, final InteractionManager interactionManager,
            final CollisionManager collisionManager, final BattleManager battleManager,
            final GameStateManager gameStateManager, final TradeManager tradeManager, 
            final RandomEncounterManager randomEncounterManagerImpl,
            final EndGameManager endGameManager
            ) {
        this.gameContext = gameContext;
        this.interactionManager = interactionManager;
        this.collisionManager = collisionManager;
        this.battleManager = battleManager;
        this.gameStateManager = gameStateManager;
        this.tradeManager = tradeManager;
        this.endGameManager = endGameManager;
        this.randomEncounterManager = randomEncounterManagerImpl;
    }

    @Override
    public InteractionManager getInteractionManager() {
        return this.interactionManager;
    }

    @Override
    public CollisionManager getCollisionManager() {
        return this.collisionManager;
    }

    @Override
    public Optional<Battle> getBattleStats() {
        return this.battleManager.getBattleStats().isPresent() 
        ? Optional.of(new ReadOnlyBattle(this.battleManager.getBattleStats().get()))
        : Optional.empty();
    }

    @Override
    public TradeManager getTradeManager() {
        return this.tradeManager;
    }

    @Override
    public GameContext getGameContext() {
        return this.gameContext;
    }

    @Override
    public GameState getGameState() {
        return gameStateManager.getGameState();
    }

    @Override
    public void setGameState(final GameState gameState) {
        gameStateManager.setGameState(gameState);
    }

    @Override
    public void bufferCommand(final Move move, final int index) {
        this.battleManager.bufferCommand(move, index);
    }

    @Override
    public BattleLogger getBattleLogger() {
        return this.battleManager.getLogger();
    }

    @Override
    public EndGameManager getEndGameManager() {
        return this.endGameManager;
    }

    @Override
    public RandomEncounterManager getRandomEncounterManager() {
        return this.randomEncounterManager;
    }
}
