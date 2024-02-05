package it.unibo.objectmon.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.impl.BattleManagerImpl;
import it.unibo.objectmon.model.collision.CollisionCheckerImpl;
import it.unibo.objectmon.model.collision.api.CollisionChecker;
import it.unibo.objectmon.model.entity.NpcManager;
import it.unibo.objectmon.model.entity.PlayerManager;
import it.unibo.objectmon.model.interaction.InteractionManagerImpl;
import it.unibo.objectmon.model.interaction.api.InteractionManager;
import it.unibo.objectmon.model.world.World;

/**
 * Manages the model logic.
 */
public final class GameManager {
    private final World world;
    private final PlayerManager playerManager;
    private final NpcManager npcManager;
    private final InteractionManager interactionManager;
    private final CollisionChecker collisionChecker;
    private final BattleManager battleManager;

    /**
     * Creates a world with entities and environment.
     */
    public GameManager() {
        this.world = new World();
        this.playerManager = new PlayerManager(this);
        this.npcManager = new NpcManager();
        this.interactionManager = new InteractionManagerImpl();
        this.battleManager = new BattleManagerImpl();
        this.collisionChecker = new CollisionCheckerImpl(world, npcManager.getNpcs());
    }

    /**
     * 
     * @return the world.
     */
    public World getWorld() {
        return world;
    }

    /**
     * Returns an object responsible for controlling the {@link Player}.
     * @return The {@link PlayerManager}
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "Could not find a better way to avoid exposing the setters inside the controller")
    public PlayerManager getPlayerController() {
        return this.playerManager;
    }

    /**
     * Retrieves the NPC manager.
     * @return An NPC manager.
     */
    public NpcManager getNpcManager() {
        return this.npcManager;
    }

    /**
     * Retrieves the interaction manager.
     * @return The interaction manager.
     */
    public InteractionManager getInteractionManager() {
        return this.interactionManager;
    }

    /**
     * Retrieves the collision checker.
     * @return The collision checker.
     */
    public CollisionChecker getCollisionChecker() {
        return this.collisionChecker;
    }

    /**
     * 
     * @return the battle manager
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "Could not find a better way to avoid exposing the setters inside the controller")
    public BattleManager getBattleManager() {
        return this.battleManager;
    }
}
