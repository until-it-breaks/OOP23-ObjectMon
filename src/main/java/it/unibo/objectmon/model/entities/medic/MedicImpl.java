package it.unibo.objectmon.model.entities.medic;

import it.unibo.objectmon.model.entities.EntityImpl;
import it.unibo.objectmon.model.world.Coord;

public class MedicImpl extends EntityImpl implements Medic {

    public MedicImpl(String name, Coord coord) {
        super(name, coord);
    }

    @Override
    public void heal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'heal'");
    }
    
}
