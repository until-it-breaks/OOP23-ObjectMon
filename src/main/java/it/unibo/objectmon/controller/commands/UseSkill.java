package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.battle.moves.type.Move;

/**
 * Attemps to use the skill of the objectmon.
 */
public final class UseSkill implements Command {
    private final int index;

    /**
     * Saves the index of the skill to be used.
     * 
     * @param index index of the skill in the List.
     */
    public UseSkill(final int index) {
        this.index = index;
    }
    @Override
    public void execute(final Model model) {
        model.bufferCommand(Move.ATTACK, index);
    }
}
