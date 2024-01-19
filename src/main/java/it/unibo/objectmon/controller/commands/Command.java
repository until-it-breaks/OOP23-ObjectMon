package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.model.Model;

/**
 * Models a generic command.
 */
public interface Command {
    /**
     * The tasks to be executed.
     * @param model the target on which to execute.
     */
    void execute(Model model);
}
