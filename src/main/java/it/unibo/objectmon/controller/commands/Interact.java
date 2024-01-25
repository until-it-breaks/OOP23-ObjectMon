package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.model.Model;

public class Interact implements Command {

    @Override
    public void execute(Model model) {
        model.getInteractionManager().triggerInteraction(model.getEntities(), model.getPlayer());
    }
    
}
