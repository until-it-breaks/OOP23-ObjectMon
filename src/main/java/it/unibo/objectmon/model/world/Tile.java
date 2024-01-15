package it.unibo.objectmon.model.world;

import java.util.List;

public class Tile {
    private int id;
    private List<Property> properties;
    private String type;

    public List<Property> getProperties() {
        return properties;
    }
    
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return "Tile [id=" + id + ", type=" + type + ", " + "properties=" + properties +"]";
    }

    public static class Property {
        private String name;
        private boolean value;
        
        public String getName() {
            return name;
        }
    
        public boolean isValue() {
            return value;
        }
    
        @Override
        public String toString() {
            return name + "=" + value;
        }
    }
}
