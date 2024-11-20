package it.unibo.objectmon.model.misc.ending;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.objectmon.model.gamestate.api.GameState;
import it.unibo.objectmon.model.gamestate.api.GameStateManager;

/**
 * Implementation of the EndGameManager.
 */
public final class EndGameManagerImpl implements EndGameManager {
    private final GameStateManager endGameStateManager;

    /**
     * Creates an EndGameManager.
     * 
     * @param manager The game state manager used to switch states.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "Strict usage is enforced")
    public EndGameManagerImpl(final GameStateManager manager) {
        this.endGameStateManager = manager;
    }

    @Override
    public void startEnding() {
        this.endGameStateManager.setGameState(GameState.ENDING);
    }
}
