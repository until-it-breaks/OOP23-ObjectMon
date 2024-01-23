package it.unibo.objectmon.model.entity.player;

import java.util.Optional;

import it.unibo.objectmon.model.entity.api.EntityImpl;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.entity.npc.NpcImpl;
import it.unibo.objectmon.model.world.Coord;

/**
 * This will be the implementation of {@link Player}.
 */
public final class PlayerImpl extends EntityImpl implements Player {

    public PlayerImpl(String name, Coord coord) {
        super(name, coord);
    }
    @Override
    public void moveUp() {
        super.setPosition(new Coord(super.getPosition().x() - 1, super.getPosition().y()));
    }
    @Override
    public void moveDown() {
        super.setPosition(new Coord(super.getPosition().x() + 1, super.getPosition().y()));
    }
    @Override
    public void moveLeft() {
        super.setPosition(new Coord(super.getPosition().x(), super.getPosition().y() - 1));
    }
    @Override
    public void moveRight() {
        super.setPosition(new Coord(super.getPosition().x(), super.getPosition().y() + 1));
    }
    @Override
    public void interact() {
        Optional<NpcImpl> targetNpc = getNPCInFront();
        if (targetNpc.isPresent()) {
            targetNpc.get().handleInteraction(this);
        }
    }

    private Optional<NpcImpl> getNPCInFront() {
        // Will probably make a class on its own for this logic.
        throw new UnsupportedOperationException("Unimplemented method 'getNPCInFront'");
    }
}
