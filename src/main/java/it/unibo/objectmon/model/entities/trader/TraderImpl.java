package it.unibo.objectmon.model.entities.trader;

import it.unibo.objectmon.model.entities.EntityImpl;
import it.unibo.objectmon.model.world.Coord;

public class TraderImpl extends EntityImpl implements Trader {

    public TraderImpl(String name, Coord coord) {
        super(name, coord);
    }

    @Override
    public void trade() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'trade'");
    }
}
