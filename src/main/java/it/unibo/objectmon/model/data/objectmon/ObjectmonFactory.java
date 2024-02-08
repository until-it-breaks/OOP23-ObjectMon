package it.unibo.objectmon.model.data.objectmon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.google.gson.Gson;
/**
 * A factory of Skills.
 */
public final class ObjectmonFactory {
    private ObjectmonFactory() {
    }

    /**
     * Creates the Objectmons that Trainers are going to use.
     * @param names Names of the objectmon to be created.
     * @param level Level of the Objectmon to be created.
     * @return Returns the set of Objectmon desired.
     */
    public static Set<ObjectmonImpl> createObjectmonSet(final List<String> names, final int level) {
        final Set<ObjectmonImpl> objectmonSet = new HashSet<>();
        for (final String name : names) {
            objectmonSet.add(createObjectmon(name, level));
        }
        return objectmonSet;
    }

    /**
     * Creates a set for the method toJson.
     * @return Returns the complete set of all the Objectmon.
     */
    private static Set<ObjectmonImpl> createObjectmonSet() {
        final Set<ObjectmonImpl> objectmonSet = new HashSet<>();
        final int level = 5;
        for (final var objectmon : ObjectmonEnum.values()) {
            objectmonSet.add(createObjectmon(objectmon.getName(), level));
        }
        return objectmonSet;
    }

    /**
     *
     * @param name Name of the objectmon to be created.
     * @param level Level of the objectmon to be created.
     * @return The objectmon desired.
     */
    private static ObjectmonImpl createObjectmon(final String name, final int level) {
        for (final var objmon : ObjectmonEnum.values()) {
            if (objmon.getName().equals(name)) {
                return new ObjectmonImpl.Builder(objmon, level).build();
            }
        }
        throw new IllegalArgumentException("No such objectmon : " + name);
    }

    /**
     * Converts a set of ObjectmonImpl to a json file.
     * @return Returns a json of the set of ObjectmonImpl.
     */
    public static String toJson() {
        final Gson gson = new Gson();
        return gson.toJson(createObjectmonSet());
    }
}
