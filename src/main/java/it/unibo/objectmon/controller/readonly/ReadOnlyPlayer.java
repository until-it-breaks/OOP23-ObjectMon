package it.unibo.objectmon.controller.readonly;

import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.entities.api.Direction;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.misc.collision.api.CollisionChecker;
import it.unibo.objectmon.model.world.Coord;

/**
 * Represents a read-only view of a {@link Player} instance.
 * This class wraps a {@link Player} object and provides read-only access to its properties,
 * while preventing modifications to its state.
 */
public final class ReadOnlyPlayer implements Player {
    private final Player player;

    /**
     * Constructs a new read-only player instance that wraps the given {@link Player} object.
     *
     * @param player The player instance to wrap.
     */
    public ReadOnlyPlayer(final Player player) {
        this.player = player;
    }

    @Override
    public void setPosition(final Coord coord) {
        throw new UnsupportedOperationException("Unimplemented method 'setPosition'");
    }

    @Override
    public Coord getPosition() {
        return player.getPosition();
    }

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public Direction getDirection() {
        return player.getDirection();
    }

    @Override
    public void setDirection(final Direction direction) {
        throw new UnsupportedOperationException("Unimplemented method 'setDirection'");
    }

    @Override
    public boolean isDefeated() {
        return player.isDefeated();
    }

    @Override
    public ObjectmonParty getObjectmonParty() {
        return player.getObjectmonParty();
    }

    @Override
    public void move(final Direction direction, final CollisionChecker collisionChecker) {
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public void setDefeated(final boolean defeatStatus) {
        throw new UnsupportedOperationException("Unimplemented method 'setDefeated'");
    }
}
