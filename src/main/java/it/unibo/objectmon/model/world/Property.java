package it.unibo.objectmon.model.world;

public class Property {
    private String name;
    private boolean value;
    
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(final boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name + "=" + value;
    }
}
