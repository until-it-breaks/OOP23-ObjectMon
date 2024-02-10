package it.unibo.objectmon.model.data.objectmon;


import java.util.List;
import java.util.Set;
import java.util.HashSet;
import com.google.gson.Gson;

import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
/**
 * The factory of Objectmon.
 */
public final class ObjectmonFactory {
    private ObjectmonFactory() {
    }

    /**
     * Creates the Objectmons that Trainers are going to use.
     * @param objectmons The Objectmons to be created.
     * @param level Level of the Objectmon to be created.
     * @return Returns the set of Objectmon desired.
     */
    public static Set<Objectmon> createObjectmonSet(final List<ObjectmonEnum> objectmons, final int level) {
        final Set<Objectmon> objectmonSet = new HashSet<>();
        for (final ObjectmonEnum objectmon : objectmons) {
            objectmonSet.add(createObjectmon(objectmon, level));
        }
        return objectmonSet;
    }

    /**
     * Creates a set for the method toJson.
     * @return Returns the complete set of all the Objectmon.
     */
    private static Set<Objectmon> createObjectmonSet() {
        final Set<Objectmon> objectmonSet = new HashSet<>();
        final int level = 5;
        for (final var objectmon : ObjectmonEnum.values()) {
            objectmonSet.add(createObjectmon(objectmon, level));
        }
        return objectmonSet;
    }

    /**
     * Creates an Objectmon from ObjectmonEnum and level.
     * @param objectmon Objectmon to be created.
     * @param level Level of the objectmon to be created.
     * @return The objectmon desired.
     */
    private static Objectmon createObjectmon(final ObjectmonEnum objectmon, final int level) {
        for (final var objmon : ObjectmonEnum.values()) {
            if (objmon.equals(objectmon)) {
                return new ObjectmonImpl.Builder(objmon, level).build();
            }
        }
        throw new IllegalArgumentException("No such objectmon : " + objectmon);
    }

    /**
     * Converts a set of Objectmon to a json file.
     * @return Returns a json of the set of Objectmon.
     */
    public static String toJson() {
        final Gson gson = new Gson();
        return gson.toJson(createObjectmonSet());
    }
}
