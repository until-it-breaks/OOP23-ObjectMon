package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.item.api.Item;

/**
 * Buy item command.
 */
public final class BuyItem implements Command {

    private final Item item;

    /**
     * Construct the item buying.
     * 
     * @param item item to be bought.
     */
    public BuyItem(final Item item) {
        this.item = item;
    }

    @Override
    public void execute(final Model model) {
        model.getTradeManager().buyItem(model.getGameContext().getPlayer().getInventory(), item);
    }
}
