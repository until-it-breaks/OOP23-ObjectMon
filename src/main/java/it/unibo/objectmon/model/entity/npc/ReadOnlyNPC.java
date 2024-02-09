package it.unibo.objectmon.model.entity.npc;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.entity.api.Direction;
import it.unibo.objectmon.model.entity.api.npc.AbstractNPC;
import it.unibo.objectmon.model.world.Coord;

/**
 * Represents a read-only view of an NPC.
 * This class provides access to the NPC's information without allowing modifications to its state.
 */
@SuppressFBWarnings(
    value = "EI_EXPOSE_REP2", 
    justification = "This read-only view does not expose the internal state of AbstractNPC."
                    + "It is designed to provide only read-only access to NPC information, "
                    + "ensuring that the NPC's state remains immutable."
)
public class ReadOnlyNPC {

    private final AbstractNPC npc;

    /**
     * Constructs a read-only view of the specified NPC.
     * 
     * @param npc The NPC for which to create a read-only view.
     */
    public ReadOnlyNPC(final AbstractNPC npc) {
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
        return  npc.getName();
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
     * Checks if the NPC implements the specified interface.
     * 
     * @param interfaceClass The interface class to check.
     * @return {@code true} if the NPC implements the interface; otherwise, {@code false}.
     */
    public boolean implementsInterface(final Class<?> interfaceClass) {
        return interfaceClass.isInstance(npc);
    }
}
