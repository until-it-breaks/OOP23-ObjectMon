package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.battle.moves.type.Move;

/**
 * Attemps to switch objectmon in the battle.
 */
public final class SwitchObjectmon implements Command {

    private final int index;

    /**
     * Constructs the command with an index.
     * 
     * @param index index of objectmon to be switched to fight.
     */
    public SwitchObjectmon(final int index) {
        this.index = index;
    }
    @Override
    public void execute(final Model model) {
        model.bufferCommand(Move.SWITCH_OBJECTMON, index);
    }
}
