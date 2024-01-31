package it.unibo.objectmon.model.interaction;

import java.util.Set;

import it.unibo.objectmon.model.entity.PlayerManager;
import it.unibo.objectmon.model.entity.api.Direction;
import it.unibo.objectmon.model.entity.npc.AbstractNPC;
import it.unibo.objectmon.model.interaction.api.InteractionManager;
import it.unibo.objectmon.model.world.Coord;
/**
 * Models a interaction manager that triggers an npc's interaction if the npc is right in front of the player.
 */
public final class InteractionManagerImpl implements InteractionManager {
    @Override
    public void triggerInteraction(final Set<AbstractNPC> npcs, final PlayerManager playerManager) {
        final Coord positionInFront = getPositionInFront(playerManager.getPosition(), playerManager.getDirection());

        for (final AbstractNPC npc : npcs) {
            if (npc.getPosition().equals(positionInFront)) {
                npc.handleInteraction(playerManager);
                break;
            }
        }
    }

    private Coord getPositionInFront(final Coord currentPosition, final Direction currentDirection) {
        switch (currentDirection) {
            case UP:
                return new Coord(currentPosition.x(), currentPosition.y() - 1);
            case DOWN:
                return new Coord(currentPosition.x(), currentPosition.y() + 1);
            case LEFT:
                return new Coord(currentPosition.x() - 1, currentPosition.y());
            case RIGHT:
                return  new Coord(currentPosition.x() + 1, currentPosition.y());
            default:
                throw new IllegalStateException();
        }
    }
}
