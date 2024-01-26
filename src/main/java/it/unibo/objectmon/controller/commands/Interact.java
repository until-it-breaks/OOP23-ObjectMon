package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.model.Model;
/**
 * Calls for an interaction check.
 */
public final class Interact implements Command {
    @Override
    public void execute(final Model model) {
        model.getInteractionManager().triggerInteraction(model.getNpcs(), model.getPlayer());
    }
}
