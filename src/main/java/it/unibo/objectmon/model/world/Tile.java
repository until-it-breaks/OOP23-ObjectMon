package it.unibo.objectmon.model.world;

import java.util.Collections;
import java.util.List;

/**
 * Models a single map unit.
 */
public final class Tile {
    private final int id;
    private final List<Property> properties;
    private final String name;
    /**
     * 
     * @param id the tile identifier.
     * 
     * @param properties a list of tile properties.
     * 
     * @param name the tile name.
     */
    public Tile(final int id, final List<Property> properties, final String name) {
        this.id = id;
        this.properties = Collections.unmodifiableList(properties);
        this.name = name;
    }
    /**
     * 
     * @return an immutable list of properties.
     */
    public List<Property> getProperties() {
        return Collections.unmodifiableList(properties);
    }
    /**
     *
     * @return the tile id.
     */
    public int getId() {
        return id;
    }
    /**
     * 
     * @return the tile name.
     */
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Tile [id=" + id + ", type=" + name + ", " + "properties=" + properties + "]";
    }
    /**
     * Models a tile property.
     */
    public static final class Property {
        private final String name;
        private final boolean value;
        /**
         * Creates a property.
         * 
         * @param name the name of the property.
         * @param value whether the property is true.
         */
        public Property(final String name, final boolean value) {
            this.name = name;
            this.value = value;
        }
        /**
         * 
         * @return the property name.
         */
        public String getName() {
            return name;
        }
        /**
         * 
         * @return whether the property is true.
         */
        public boolean isValue() {
            return value;
        }
        @Override
        public String toString() {
            return name + "=" + value;
        }
    }
}
