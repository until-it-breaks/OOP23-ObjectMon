package it.unibo.objectmon.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.impl.BattleManagerImpl;
import it.unibo.objectmon.model.gamestate.GameStateManager;
import it.unibo.objectmon.model.gamestate.GameStateManagerImpl;
import it.unibo.objectmon.model.misc.collision.CollisionCheckerImpl;
import it.unibo.objectmon.model.misc.collision.api.CollisionChecker;
import it.unibo.objectmon.model.misc.interaction.InteractionManagerImpl;
import it.unibo.objectmon.model.misc.interaction.api.InteractionManager;

/**
 * Manages the game model logic, including entities, interactions, collisions, and battles.
 * This class initializes the game model with default settings and provides access to various managers
 * that are responsible for handling different aspects of the game.
 */
public final class ModelImpl implements Model {
    private GameContext gameContext;
    private InteractionManager interactionManager;
    private CollisionChecker collisionChecker;
    private BattleManager battleManager;
    private GameStateManager gameStateManager;

    /**
     * Constructs a ModelImpl instance,
     * and initializes the game model with default settings.
     */
    public ModelImpl() {
        initialize();
    }

    @Override
    public void initialize() {
        this.gameContext = GameContexts.createDefaultContext();
        this.collisionChecker = new CollisionCheckerImpl(this.gameContext.getWorld(), this.gameContext.getNpcManager().getNPCs());
        this.interactionManager = new InteractionManagerImpl();
        this.battleManager = new BattleManagerImpl();
        this.gameStateManager = new GameStateManagerImpl();
    }

    @Override
    public InteractionManager getInteractionManager() {
        return this.interactionManager;
    }

    @Override
    public CollisionChecker getCollisionChecker() {
        return this.collisionChecker;
    }

    @Override
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "Temporary")
    public BattleManager getBattleManager() {
        return this.battleManager;
    }

    @Override
    public GameContext getGameContext() {
        return this.gameContext;
    }

    @Override
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "It's been made sure at Controller level that it won't be misused")
    public GameStateManager getGameStateManager() {
        return this.gameStateManager;
    }
}
