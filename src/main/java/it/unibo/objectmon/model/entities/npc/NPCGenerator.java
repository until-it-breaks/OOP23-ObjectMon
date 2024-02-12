package it.unibo.objectmon.model.entities.npc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unibo.objectmon.model.battle.api.BattleStartListener;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * A utility class for generating predefined Non-Player Characters (NPCs) in a game world.
 * NPCs include trainers, healers, and vendors.
 */
public final class NPCGenerator {

    // Predefined positions for NPCs,
    private static final Coord POSITION_1 = new Coord(5, 5);
    private static final Coord POSITION_2 = new Coord(5, 40);
    private static final Coord POSITION_3 = new Coord(44, 5);
    private static final Coord POSITION_4 = new Coord(44, 40);
    private static final Coord POSITION_5 = new Coord(44, 25);
    private static final Coord POSITION_6 = new Coord(5, 25);
    private static final Coord POSITION_7 = new Coord(24, 23);
    private static final Coord POSITION_8 = new Coord(25, 23);

    // Default level for NPC parties,
    private static final int DEFAULT_PARTY_LEVEL = 5;

    private NPCGenerator() {
    }

    /**
     * Creates a set of default NPCs.
     * 
     * @param battleStartListener The listener for handling events related to the start of battles.
     * @return A set of default NPCs.
     */
    public static Set<AbstractNPC> createDefaultNPCs(final BattleStartListener battleStartListener) {
        final Set<AbstractNPC> npcs = new HashSet<>();
        npcs.add(new TrainerNPCImpl("Trainer Bob", POSITION_1, new ArrayList<>(ObjectmonFactory.createObjectmonSet(List.of(
            ObjectmonEnum.ILLUMISE,
            ObjectmonEnum.LILEEP,
            ObjectmonEnum.NOSEPASS),
            DEFAULT_PARTY_LEVEL)), battleStartListener));
        npcs.add(new TrainerNPCImpl("Trainer Alex", POSITION_2, new ArrayList<>(ObjectmonFactory.createObjectmonSet(List.of(
            ObjectmonEnum.ANORITH,
            ObjectmonEnum.GOLDEEN),
            DEFAULT_PARTY_LEVEL + 1)), battleStartListener));
        npcs.add(new TrainerNPCImpl("Trainer Delta", POSITION_3, new ArrayList<>(ObjectmonFactory.createObjectmonSet(List.of(
            ObjectmonEnum.KECLEON), DEFAULT_PARTY_LEVEL + 2)), battleStartListener));
        npcs.add(new TrainerNPCImpl("Trainer Gamma", POSITION_4, new ArrayList<>(ObjectmonFactory.createObjectmonSet(List.of(
            ObjectmonEnum.RELICANTH,
            ObjectmonEnum.NUMEL,
            ObjectmonEnum.TROPIUS,
            ObjectmonEnum.SHROOMISH),
            DEFAULT_PARTY_LEVEL - 1)), battleStartListener));
        npcs.add(new TrainerNPCImpl("Trainer Sigma", POSITION_5, new ArrayList<>(ObjectmonFactory.createObjectmonSet(List.of(
            ObjectmonEnum.SLUGMA,
            ObjectmonEnum.GEODUDE,
            ObjectmonEnum.TORKOAL,
            ObjectmonEnum.NOSEPASS),
            DEFAULT_PARTY_LEVEL)), battleStartListener));
        npcs.add(new TrainerNPCImpl("Trainer Alpha", POSITION_6, new ArrayList<>(ObjectmonFactory.createObjectmonSet(List.of(
            ObjectmonEnum.ODDISH,
            ObjectmonEnum.ILLUMISE,
            ObjectmonEnum.GEODUDE,
            ObjectmonEnum.GEODUDE),
            DEFAULT_PARTY_LEVEL - 1)), battleStartListener));
        //Support NPCs
        npcs.add(new HealerNPCImpl("Dr. Madness", POSITION_7));
        npcs.add(new SellerNPCImpl("Item Vendor", POSITION_8));
        return npcs;
    }
}
