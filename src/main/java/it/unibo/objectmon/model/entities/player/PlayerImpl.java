package it.unibo.objectmon.model.entities.player;

import java.util.List;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.data.objectmon.ObjectmonPartyImpl;
import it.unibo.objectmon.model.entities.api.Direction;
import it.unibo.objectmon.model.entities.api.EntityImpl;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.misc.collision.api.CollisionChecker;
import it.unibo.objectmon.model.world.Coord;

/**
 * This will be the implementation of {@link Player}.
 */
public final class PlayerImpl extends EntityImpl implements Player {

    private final ObjectmonParty objectmonParty;
    private boolean defeatStatus;

    /**
     * Constructs a new Player.
     * 
     * @param name The name of the player.
     * @param coord The starting position of the player.
     * @param team The starting team of Objectmons.
     */
    public PlayerImpl(final String name, final Coord coord, final List<Objectmon> team) {
        super(name, coord);
        this.objectmonParty = new ObjectmonPartyImpl(team);
        this.defeatStatus = false;
    }

    @Override
    public void move(final Direction direction, final CollisionChecker collisionChecker) {
        final Coord nextPosition = new Coord(getPosition().x() + direction.getX(), getPosition().y() + direction.getY());
        this.setDirection(direction);
        if (!collisionChecker.isCollision(nextPosition)) {
            this.setPosition(nextPosition);
        }
    }

    @Override
    public boolean isDefeated() {
        return this.defeatStatus;
    }

    @Override
    public void setDefeated(final boolean defeatStatus) {
        this.defeatStatus = defeatStatus;
    }

    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "TEMPORARY")
    @Override
    public ObjectmonParty getObjectmonParty() {
        return this.objectmonParty;
    }
}
