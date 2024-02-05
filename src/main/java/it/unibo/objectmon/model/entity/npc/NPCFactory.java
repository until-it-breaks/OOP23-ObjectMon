package it.unibo.objectmon.model.entity.npc;

import java.util.Set;
import it.unibo.objectmon.model.world.Coord;
import java.util.HashSet;

/**
 * A factory of NPC sets.
 */
public final class NPCFactory {
    private static final Coord TRAINER1_COORD = new Coord(5, 5);
    private static final Coord TRAINER2_COORD = new Coord(44, 5);
    private static final Coord TRAINER3_COORD = new Coord(5, 44);
    private static final Coord TRAINER4_COORD = new Coord(44, 44);
    private static final Coord HEALER1_COORD = new Coord(24, 20);
    private static final Coord SELLER1_COORD = new Coord(25, 20);

    private NPCFactory() {
    }

    /**
     * Creates a set of default NPCs.
     * 
     * @return A set of default NPCs.
     */
    public static Set<AbstractNPC> createDefaultNPCs() {
        final Set<AbstractNPC> npcs = new HashSet<>();
        npcs.add(new TrainerNpc("Trainer 1", TRAINER1_COORD, Set.of()));
        npcs.add(new TrainerNpc("Trainer 2", TRAINER2_COORD, Set.of()));
        npcs.add(new TrainerNpc("Trainer 3", TRAINER3_COORD, Set.of()));
        npcs.add(new TrainerNpc("Trainer 4", TRAINER4_COORD, Set.of()));
        npcs.add(new HealerNPC("Healer 1", HEALER1_COORD));
        npcs.add(new SellerNPC("Seller 1", SELLER1_COORD));
        return npcs;
    }
}
