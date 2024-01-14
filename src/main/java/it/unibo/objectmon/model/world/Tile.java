package it.unibo.objectmon.model.world;

import java.util.List;

public class Tile {
    private int id;
    private List<Property> properties;
    
    public List<Property> getProperties() {
        return properties;
    }
    public void setProperties(final List<Property> properties) {
        this.properties = properties;
    }
    private String type;
    
    public int getId() {
        return id;
    }
    public void setId(final int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(final String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return "Tile [id=" + id + ", type=" + type + ", " + "properties=" + properties +"]";
    }
    
}
