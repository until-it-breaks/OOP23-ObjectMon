package it.unibo.objectmon.model.entity.npc;

import java.util.Set;
import it.unibo.objectmon.model.entity.api.npc.AbstractNPC;
import it.unibo.objectmon.model.world.Coord;
import java.util.HashSet;
import java.util.List;

/**
 * A factory of NPC sets.
 */
public final class NPCFactory {
    private static final Coord POSITION_1 = new Coord(5, 5);
    private static final Coord POSITION_2 = new Coord(44, 5);
    private static final Coord POSITION_3 = new Coord(5, 44);
    private static final Coord POSITION_4 = new Coord(44, 44);
    private static final Coord POSITION_5 = new Coord(24, 20);
    private static final Coord POSITION_6 = new Coord(25, 20);

    private NPCFactory() {
    }

    /**
     * Creates a set of default NPCs.
     * 
     * @return A set of default NPCs.
     */
    public static Set<AbstractNPC> createDemoNPCs() {
        final Set<AbstractNPC> npcs = new HashSet<>();
        npcs.addAll(createJustTrainers());
        npcs.addAll(createSupportNPCsOnly());
        return npcs;
    }

    /**
     * Creates a set of default NPCs.
     * 
     * @return A set of default NPCs.
     */
    public static Set<AbstractNPC> createJustTrainers() {
        final Set<AbstractNPC> npcs = new HashSet<>();
        npcs.add(new TrainerNPCImpl("Trainer Bob", POSITION_1, List.of()));
        npcs.add(new TrainerNPCImpl("Trainer Alex", POSITION_2, List.of()));
        npcs.add(new TrainerNPCImpl("Trainer Delta", POSITION_3, List.of()));
        npcs.add(new TrainerNPCImpl("Trainer Alpha", POSITION_4, List.of()));
        return npcs;
    }

    /**
     * Creates a set of default NPCs.
     * 
     * @return A set of default NPCs.
     */
    public static Set<AbstractNPC> createSupportNPCsOnly() {
        final Set<AbstractNPC> npcs = new HashSet<>();
        npcs.add(new HealerNPCImpl("Doctor Madness", POSITION_5));
        npcs.add(new SellerNPCImpl("Street Vendor", POSITION_6));
        return npcs;
    }
}
