package it.unibo.objectmon.model.entities.trainer;

import it.unibo.objectmon.model.entities.EntityImpl;
import it.unibo.objectmon.model.world.Coord;

public class TrainerImpl extends EntityImpl implements Trainer {

    public TrainerImpl(String name, Coord coord) {
        super(name, coord);
    }

    @Override
    public void challenge() {
        throw new UnsupportedOperationException("Unimplemented method 'challenge'");
    }

    @Override
    public boolean isDefeated() {
        throw new UnsupportedOperationException("Unimplemented method 'isDefeated'");
    }
}
