package it.unibo.objectmon.model.entity.player;

import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.data.objectmon.ObjectmonPartyImpl;
import it.unibo.objectmon.model.entity.api.Direction;
import it.unibo.objectmon.model.entity.api.EntityImpl;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.world.Coord;

/**
 * This will be the implementation of {@link Player}.
 */
public final class PlayerImpl extends EntityImpl implements Player {

    private final ObjectmonParty objectmonParty;
    private boolean isDefeated;

    /**
     * Constructs a new Player.
     * @param name The name of the player.
     * @param coord The starting position of the player.
     * @param team The starting team of Objectmons.
     */
    public PlayerImpl(final String name, final Coord coord, final List<Objectmon> team) {
        super(name, coord);
        this.objectmonParty = new ObjectmonPartyImpl(team);
        this.isDefeated = false;
    }

    @Override
    public void moveUp() {
        super.setPosition(new Coord(super.getPosition().x(), super.getPosition().y() - 1));
        this.setDirection(Direction.UP);
    }

    @Override
    public void moveDown() {
        super.setPosition(new Coord(super.getPosition().x(), super.getPosition().y() + 1));
        this.setDirection(Direction.DOWN);
    }

    @Override
    public void moveLeft() {
        super.setPosition(new Coord(super.getPosition().x() - 1, super.getPosition().y()));
        this.setDirection(Direction.LEFT);
    }

    @Override
    public void moveRight() {
        super.setPosition(new Coord(super.getPosition().x() + 1, super.getPosition().y()));
        this.setDirection(Direction.RIGHT);
    }

    @Override
    public void setDefeated(final boolean isDefeated) {
        this.isDefeated = isDefeated;
    }

    @Override
    public boolean isDefeated() {
        return this.isDefeated;
    }

    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "TEMPORARY")
    @Override
    public ObjectmonParty getObjectmonParty() {
        return this.objectmonParty;
    }
}
