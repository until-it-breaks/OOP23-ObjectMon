package it.unibo.objectmon.model;

import java.util.HashSet;
import java.util.Set;
import it.unibo.objectmon.model.entity.api.Npc;
import it.unibo.objectmon.model.entity.api.NpcType;
import it.unibo.objectmon.model.entity.npc.NpcImpl;
import it.unibo.objectmon.model.entity.player.PlayerImpl;
import it.unibo.objectmon.model.interaction.InteractionManager;
import it.unibo.objectmon.model.world.Coord;
import it.unibo.objectmon.model.world.World;

/**
 * Models the master model of the application.
 */
public final class Model {
    private World world;
    private PlayerImpl player;
    private Set<Npc> npcs;
    private InteractionManager interactionManager;
    /**
     * Creates a world with entities and environment.
     */
    public Model() {
        init();
    }

    private void init() {
        this.world = new World();
        this.player = new PlayerImpl("Player", new Coord(world.getWidth() / 2, world.getHeight() / 2));
        this.npcs = new HashSet<>();
        this.npcs.add(new NpcImpl("Bob", NpcType.TRADER, new Coord(5, 5)));
        this.npcs.add(new NpcImpl("Madness", NpcType.HEALER, new Coord(8,8)));
        this.npcs.add(new NpcImpl("Frenchman", NpcType.TRAINER, new Coord(1, 1)));
        this.npcs.add(new NpcImpl("Mr.Generic", NpcType.GENERIC, new Coord(1, 2)));
        this.interactionManager = new InteractionManager();
    }
    /**
     * 
     * @return the world.
     */
    public World getWorld() {
        return world;
    }
    /**
     * 
     * @return the player.
     */
    public PlayerImpl getPlayer() {
        return player;
    }

    public Set<Npc> getEntities() {
        return this.npcs;
    }

    public InteractionManager getInteractionManager() {
        return this.interactionManager;
    }
}
