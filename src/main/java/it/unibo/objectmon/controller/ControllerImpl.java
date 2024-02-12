package it.unibo.objectmon.controller;

import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;
import java.util.Optional;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.controller.engine.GameLoop;
import it.unibo.objectmon.controller.engine.GameLoopImpl;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.ModelImpl;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.api.BattleStartListener;
import it.unibo.objectmon.model.battle.impl.BattleManagerImpl;
import it.unibo.objectmon.model.core.GameContext;
import it.unibo.objectmon.model.core.GameContexts;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.npc.EntityReadOnly;
import it.unibo.objectmon.model.entities.player.ReadOnlyPlayer;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.gamestate.GameStateManager;
import it.unibo.objectmon.model.gamestate.GameStateManagerImpl;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogger;
import it.unibo.objectmon.model.misc.collision.CollisionManagerImpl;
import it.unibo.objectmon.model.misc.collision.api.CollisionManager;
import it.unibo.objectmon.model.misc.interaction.InteractionManagerImpl;
import it.unibo.objectmon.model.misc.interaction.api.InteractionManager;
import it.unibo.objectmon.model.world.api.World;
import it.unibo.objectmon.view.View;
import it.unibo.objectmon.view.SwingViewImpl;

/**
 * Models the controller of the application.
 */
public final class ControllerImpl implements Controller {

    private static final int COMMAND_LIMIT = 16;
    private final Queue<Command> commandQueue;
    private final Model model;
    private final View view;

    /**
     * Constructs the controller and initializes the model dependencies.
     */
    public ControllerImpl() {
        this.commandQueue = new ArrayBlockingQueue<>(COMMAND_LIMIT);

        // Create and initialize necessary dependencies
        final GameStateManager gameStateManager = new GameStateManagerImpl();
        final BattleManager battleManager = new BattleManagerImpl(gameStateManager);
        final BattleStartListener battleStartListener = (player, trainer, objectmon) -> {
            battleManager.startBattle(player, trainer, objectmon);
        };
        final GameContext gameContext = GameContexts.createDefaultContext(battleStartListener);
        final CollisionManager collisionManager = new CollisionManagerImpl(gameContext.getWorld(), gameContext.getNPCs());
        final InteractionManager interactionManager = new InteractionManagerImpl();

        // Create the model with initialized dependencies
        this.model = new ModelImpl(gameContext, interactionManager, collisionManager, battleManager, gameStateManager);

        // Initialize the view
        this.view = new SwingViewImpl(this);
        gameStateManager.registerObserver(view);
        gameStateManager.setGameState(GameState.EXPLORATION);
    }

    @Override
    public void notifyCommand(final Command command) {
        this.commandQueue.add(command);
    }

    @Override
    public Command pollCommand() {
        return this.commandQueue.poll();
    }

    @Override
    public void startGame() {
        final GameLoop gameLoop = new GameLoopImpl(model, view, this);
        gameLoop.start();
    }

    @Override
    public Set<EntityReadOnly> getNPCSet() {
    return model.getGameContext().getNPCs().stream()
            .map(EntityReadOnly::new)
            .collect(Collectors.toSet());
    }

    @Override
    public World getWorld() {
        return model.getGameContext().getWorld();
    }

    @Override
    public Player getPlayer() {
        return new ReadOnlyPlayer(model.getGameContext().getPlayer());
    }

    @Override
    public List<String> getInteractionLog() {
        return model.getInteractionManager().getMessages();
    }

    @Override
    public GameState getGameState() {
        return model.getGameState();
    }

    @Override
    public Optional<Battle> getBattleStats() {
        return model.getBattleStats();
    }

    @Override
    public BattleLogger getBattleLogger() {
        return model.getBattleLogger();
    }
}
