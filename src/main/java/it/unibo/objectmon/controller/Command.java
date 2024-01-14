package it.unibo.objectmon.controller;

import it.unibo.objectmon.model.GameState;

public interface Command {
    
    void execute(final GameState gameState);
}
