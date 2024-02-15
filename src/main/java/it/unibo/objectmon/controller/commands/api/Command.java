package it.unibo.objectmon.controller.commands.api;

import it.unibo.objectmon.model.Model;

/**
 * Models a generic command that interacts with the model.
 */
public interface Command {

    /**
     * The tasks to be executed.
     * @param model the model on which to execute.
     */
    void execute(Model model);
}
