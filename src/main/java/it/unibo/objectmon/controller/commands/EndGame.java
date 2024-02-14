package it.unibo.objectmon.controller.commands;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.core.GameContext;
import it.unibo.objectmon.model.entities.api.AbstractNPC;
import it.unibo.objectmon.model.entities.api.Trainer;
import it.unibo.objectmon.model.entities.npc.TrainerImpl;
import it.unibo.objectmon.model.gamestate.GameState;

/**
 * Calls for a check if the game is over.
 */
public final class EndGame implements Command {
    @Override
    public void execute(final Model model) {
        final GameContext gc = model.getGameContext();
        final boolean isLoss = gc.getPlayer().getObjectmonParty().getParty().size() == 0;
        boolean isWin = true;
        for (final AbstractNPC npc : gc.getNPCs()) {
            if (npc instanceof Trainer) {
                final TrainerImpl trainer = (TrainerImpl) npc;
                isWin = isWin ? trainer.getObjectmonParty().getParty().size() == 0 : isWin;
            }
        }
        if (isLoss) {
            model.setGameState(GameState.LOSS);
        } else if (isWin) {
            model.setGameState(GameState.WIN);
        }
    }
}
