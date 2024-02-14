package it.unibo.objectmon.model.gamestate;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Implementation of the EndGameManager, that manages the END GameState.
 */
public final class EndGameManagerImpl implements EndGameManager {
    private final GameStateManager endGameStateManager;

    /**
     * Constructor of the class EndGameManager.
     * @param manager The manager to execute the comands. 
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP",
    justification = "Temporary")
    public EndGameManagerImpl(final GameStateManager manager) {
        this.endGameStateManager = manager;
    }

    @Override
    public void startEnd() {
        this.endGameStateManager.setGameState(GameState.END);
    }

}
