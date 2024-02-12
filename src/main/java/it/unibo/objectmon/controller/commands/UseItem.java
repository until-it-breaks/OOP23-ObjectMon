package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.battle.moves.type.Move;

/**
 * Attemps to use an item.
 */
public final class UseItem implements Command {

    private final int index;

    /**
     * Uses an item in the inventory.
     * 
     * @param index Index of the item to be used.
     */
    public UseItem(final int index) {
        this.index = index;
    }

    @Override
    public void execute(final Model model) {
        model.bufferCommand(Move.USE_ITEM, index);
    }
}
