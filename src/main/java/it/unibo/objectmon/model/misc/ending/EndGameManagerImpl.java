package it.unibo.objectmon.model.gamestate;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

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
    public void startEnd() {
        this.endGameStateManager.setGameState(GameState.ENDING);
    }
}
