package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.item.api.Item;

/**
 * Sell item command.
 */
public final class SellItem implements Command {

    private final Item item;

    /**
     * Construct the item selling.
     * @param item item to be sold.
     */
    public SellItem(final Item item) {
        this.item = item;
    }

    @Override
    public void execute(final Model model) {
        model.getTradeManager().sellItem(model.getGameContext().getPlayer(), item);
    }
}
