package it.unibo.objectmon.model.misc.interaction;

import java.util.Set;
import it.unibo.objectmon.model.entity.api.Direction;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.api.npc.AbstractNPC;
import it.unibo.objectmon.model.misc.interaction.api.InteractionManager;
import it.unibo.objectmon.model.world.Coord;

/**
 * Models a interaction manager that triggers an npc's interaction if the npc is right in front of the player.
 */
public final class InteractionManagerImpl implements InteractionManager {
    @Override
    public void triggerInteraction(final Set<AbstractNPC> npcs, final Player player) {
        final Coord positionInFront = getPositionInFront(player.getPosition(), player.getDirection());

        for (final AbstractNPC npc : npcs) {
            if (npc.getPosition().equals(positionInFront)) {
                npc.handleInteraction(player);
                break;
            }
        }
    }

    private Coord getPositionInFront(final Coord currentPosition, final Direction currentDirection) {
        return new Coord(currentPosition.x() + currentDirection.getX(), currentPosition.y() + currentDirection.getY());
    }
}
