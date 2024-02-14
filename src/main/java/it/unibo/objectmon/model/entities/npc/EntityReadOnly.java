package it.unibo.objectmon.model.entities.npc;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Direction;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * Represents a read-only view of an NPC.
 * This class provides access to the NPC's information without allowing modifications to its state.
 */
@SuppressFBWarnings(
    value = "EI_EXPOSE_REP2", 
    justification = "By design this provides read-only information outside of the model."
)
public class EntityReadOnly {

    private final AbstractNPC npc;

    /**
     * Constructs a read-only view of the specified NPC.
     * 
     * @param npc The NPC for which a read-only view is created.
     */
    public EntityReadOnly(final AbstractNPC npc) {
        this.npc = npc;
    }

    /**
     * Retrieves the position of the NPC.
     * 
     * @return The position of the NPC.
     */
    public Coord getPosition() {
        return npc.getPosition();
    }

    /**
     * Retrieves the name of the NPC.
     * 
     * @return The name of the NPC.
     */
    public String getName() {
        return npc.getName();
    }

    /**
     * Retrieves the direction the NPC is facing.
     * 
     * @return The direction the NPC is facing.
     */
    public Direction getDirection() {
        return npc.getDirection();
    }

    /**
     * Checks if the underlying NPC implements the specified interface.
     * 
     * @param interfaceClass The interface class to check.
     * @return {@code true} if the NPC implements the interface; {@code false} otherwise.
     */
    public boolean implementsInterface(final Class<?> interfaceClass) {
        return interfaceClass.isInstance(npc);
    }
}
