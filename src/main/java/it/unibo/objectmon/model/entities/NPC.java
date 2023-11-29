package it.unibo.objectmon.model.entities;

import it.unibo.objectmon.api.Entity;

public class NPC implements Entity{
    String name;
    int x;
    int y;

    public NPC(final String name, final int x, final int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    
    public void setY(final int y) {
        this.y = y;
    }

}
