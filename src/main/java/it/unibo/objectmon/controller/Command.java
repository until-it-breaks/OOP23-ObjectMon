package it.unibo.objectmon.controller;

import it.unibo.objectmon.model.GameState;

/**
 * Models a generic command.
 */
public interface Command {
    /**
     * 
     * @param gameState the state affected by the command.
     */
    void execute(GameState gameState);
}
