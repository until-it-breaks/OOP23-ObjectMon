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
     * Creates an Objectmon from ObjectmonEnum and level.
     * @param objectmon Objectmon to be created.
     * @param level Level of the objectmon to be created.
     * @return The objectmon desired.
     */
    public static Objectmon createObjectmon(final ObjectmonEnum objectmon, final int level) {
        return new ObjectmonImpl(objectmon, level);
    }
}
