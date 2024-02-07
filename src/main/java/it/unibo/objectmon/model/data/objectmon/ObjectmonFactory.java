package it.unibo.objectmon.model.data.objectmon;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.objectmon.model.data.api.aspect.Aspect;
import it.unibo.objectmon.model.data.api.skill.Skill;
import it.unibo.objectmon.model.data.api.statistics.StatId;
import it.unibo.objectmon.model.data.skill.SkillFactory;
import it.unibo.objectmon.model.data.statistics.BaseStats;
import com.google.gson.Gson;
/**
 * A factory of Skills.
 */
public final class ObjectmonFactory {

    private static final BaseStats ZIGZAGOON = new BaseStats(
            Map.of(
            StatId.HP, 38,
            StatId.ATK, 30,
            StatId.DEF, 41,
            StatId.SPATK, 30,
            StatId.SPDEF, 41,
            StatId.SPD, 60
            )
    );

    private static final BaseStats TREEKO = new BaseStats(
            Map.of(
            StatId.HP, 40,
            StatId.ATK, 45,
            StatId.DEF, 35,
            StatId.SPATK, 65,
            StatId.SPDEF, 55,
            StatId.SPD, 70
            )
    );

    private static final BaseStats MUDKIP = new BaseStats(
            Map.of(
                StatId.HP, 50,
                StatId.ATK, 70,
                StatId.DEF, 50,
                StatId.SPATK, 50,
                StatId.SPDEF, 50,
                StatId.SPD, 40
            )
    );

    private static final BaseStats TORCHIC = new BaseStats(
            Map.of(
                StatId.HP, 45,
                StatId.ATK, 60,
                StatId.DEF, 40,
                StatId.SPATK, 70,
                StatId.SPDEF, 50,
                StatId.SPD, 45
            )
    );

    private static final BaseStats GEODUDE = new BaseStats(
            Map.of(
            StatId.HP, 40,
            StatId.ATK, 80,
            StatId.DEF, 100,
            StatId.SPATK, 30,
            StatId.SPDEF, 30,
            StatId.SPD, 20
            )
    );

    private ObjectmonFactory() {
    }

    /**
     * Creates the Objectmons that Trainers are going to use.
     * @return Returns the complete list of all the Objectmons.
     */
    public static Set<ObjectmonImpl> createObjectmon() {
        final Set<ObjectmonImpl> objectmonSet = new HashSet<>();
        final List<Skill> skillList = SkillFactory.createSkills();
        int id = 0;
        final int level = 5;
        String name = "Zigzagoon";
        final List<Skill> skills0 = skillList.stream()
        .filter(skill -> skill.getAspect() == Aspect.NORMAL)
        .collect(Collectors.toList());
        objectmonSet.add(
            new ObjectmonImpl.Builder(
                id, name, List.of(Aspect.NORMAL), skills0, ZIGZAGOON, level
            ).build()
        );
        id++;

        name = "Treeko";
        final List<Skill> skills1 = skillList.stream()
        .filter(skill -> skill.getAspect() == Aspect.GRASS)
        .collect(Collectors.toList());
        objectmonSet.add(
            new ObjectmonImpl.Builder(
                id, name, List.of(Aspect.GRASS), skills1, TREEKO, level
            ).build()
        );
        id++;

        name = "Mudkip";
        final List<Skill> skills2 = skillList.stream()
        .filter(skill -> skill.getAspect() == Aspect.WATER)
        .collect(Collectors.toList());
        objectmonSet.add(
            new ObjectmonImpl.Builder(
                id, name, List.of(Aspect.WATER, Aspect.GROUND), skills2, MUDKIP, level
            ).build()
        );
        id++;

        name = "Torchic";
        final List<Skill> skills3 = skillList.stream()
        .filter(skill -> skill.getAspect() == Aspect.FIRE)
        .collect(Collectors.toList());
        objectmonSet.add(
            new ObjectmonImpl.Builder(
                id, name, List.of(Aspect.FIRE), skills3, TORCHIC, level
            ).build()
        );
        id++;

        name = "Geodude";
        final List<Skill> skills4 = skillList.stream()
        .filter(skill -> skill.getAspect() == Aspect.ROCK)
        .collect(Collectors.toList());
        objectmonSet.add(
            new ObjectmonImpl.Builder(
                id, name, List.of(Aspect.ROCK, Aspect.GROUND), skills4, GEODUDE, level
            ).build()
        );

        return objectmonSet;
    }

    /**
     * Converts a set of ObjectmonImpl to a json file.
     * @return Returns a json of the set of ObjectmonImpl.
     */
    public static String toJson() {
        final Gson gson = new Gson();
        return gson.toJson(createObjectmon());
    }
}
