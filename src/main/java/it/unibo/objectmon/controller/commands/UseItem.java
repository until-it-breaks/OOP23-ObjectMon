package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.battle.moves.type.Move;
import it.unibo.objectmon.model.item.api.BallItem;
import it.unibo.objectmon.model.item.api.HealItem;

/**
 * Attemps to use an item.
 */
public final class UseItem implements Command {

    private final int index;

    /**
     * Saves the index of the item to be used.
     * 
     * @param index Index of the item to be used.
     */
    public UseItem(final int index) {
        this.index = index;
    }

    @Override
    public void execute(final Model model) {
        model.getBattleStats().ifPresent(
            b -> b.getPlayer().getInventory().getItems().keySet()
            .stream().skip(index).findFirst().ifPresent(
                item -> {
                    if (item instanceof HealItem) {
                        model.bufferCommand(Move.USE_HEAL, index);
                    } else if (item instanceof BallItem) {
                        model.bufferCommand(Move.USE_BALL, index);
                    } else {
                        throw new IllegalStateException();
                    }
                }
            )
        );
    }
}
