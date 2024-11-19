package it.unibo.objectmon.model.misc.interaction;

import java.util.List;
import java.util.Set;

import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Direction;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.misc.eventlog.InteractionLoggerImpl;
import it.unibo.objectmon.model.misc.eventlog.api.InteractionLogger;
import it.unibo.objectmon.model.misc.interaction.api.InteractionManager;
import it.unibo.objectmon.model.world.api.Coord;

/**
 * Models an interaction manager that triggers interactions if the npc is right in front of the player.
 */
public final class InteractionManagerImpl implements InteractionManager {

    private final InteractionLogger logger;

    /**
     * Creates an interaction manager.
     */
    public InteractionManagerImpl() {
        this.logger = new InteractionLoggerImpl();
    }

    @Override
    public boolean triggerInteraction(final Set<AbstractNPC> npcs, final Player player) {
        final Coord positionInFront = getPositionInFront(player.getPosition(), player.getDirection());

        for (final AbstractNPC npc : npcs) {
            if (npc.getPosition().equals(positionInFront)) {
                npc.handleInteraction(player, this.logger);
                return true;
            }
        }
        return false;
    }

    private Coord getPositionInFront(final Coord currentPosition, final Direction currentDirection) {
        return new Coord(currentPosition.x() + currentDirection.getX(), currentPosition.y() + currentDirection.getY());
    }

    @Override
    public List<String> getMessages() {
        return this.logger.getMessages();
    }
}
