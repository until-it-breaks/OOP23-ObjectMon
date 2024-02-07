package it.unibo.objectmon.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.entity.npc.NpcManager;
import it.unibo.objectmon.model.entity.player.PlayerManager;
import it.unibo.objectmon.model.misc.collision.CollisionCheckerImpl;
import it.unibo.objectmon.model.misc.collision.api.CollisionChecker;
import it.unibo.objectmon.model.misc.interaction.InteractionManagerImpl;
import it.unibo.objectmon.model.misc.interaction.api.InteractionManager;
import it.unibo.objectmon.model.world.World;

/**
 * Manages the model logic.
 */
public final class Model {
    private final World world;
    private final PlayerManager playerManager;
    private final NpcManager npcManager;
    private final InteractionManager interactionManager;
    private final CollisionChecker collisionChecker;

    /**
     * Creates a world with entities and environment.
     */
    public Model() {
        this.world = new World();
        this.playerManager = new PlayerManager(this);
        this.npcManager = new NpcManager();
        this.interactionManager = new InteractionManagerImpl();
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
    justification = "Temporary")
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
}
