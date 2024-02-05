package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
/**
 * Attemps to use the skill of the objectmon.
 */
public class UseSkill implements Command {
    private final int index;
    /**
     * 
     * @param index index of the skill in the List.
     */
    public UseSkill(final int index) {
        this.index = index;
    }
    @Override
    public void execute(final Model model) {
        model.getGameManager().getBattleManager().useSkill(this.index);
    }
    
}
