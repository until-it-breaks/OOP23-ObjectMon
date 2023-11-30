package it.unibo.objectmon.model.environment;

public enum Tile {
    GRASS("grass"),
    WATER("water"),
    STONE("stone");

    private final String name;

    private Tile(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
