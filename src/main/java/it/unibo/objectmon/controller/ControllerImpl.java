package it.unibo.objectmon.controller;

import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Optional;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.controller.engine.GameLoop;
import it.unibo.objectmon.controller.engine.GameLoopImpl;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.ModelImpl;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.battle.api.BattleInitiator;
import it.unibo.objectmon.model.battle.impl.BattleManagerImpl;
import it.unibo.objectmon.model.core.GameContext;
import it.unibo.objectmon.model.core.GameContexts;
import it.unibo.objectmon.model.encounters.api.RandomEncounterManager;
import it.unibo.objectmon.model.encounters.impl.RandomEncounterManagerImpl;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Trainer;
import it.unibo.objectmon.model.entities.npc.EntityReadOnly;
import it.unibo.objectmon.model.entities.npc.TrainerImpl;
import it.unibo.objectmon.model.entities.player.ReadOnlyPlayer;
import it.unibo.objectmon.model.gamestate.EndGameManager;
import it.unibo.objectmon.model.gamestate.EndGameManagerImpl;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.gamestate.GameStateManager;
import it.unibo.objectmon.model.gamestate.GameStateManagerImpl;
import it.unibo.objectmon.model.item.trademanager.api.TradeManager;
import it.unibo.objectmon.model.item.trademanager.api.TradeInitiator;
import it.unibo.objectmon.model.item.trademanager.impl.TradeManagerImpl;
import it.unibo.objectmon.model.item.trademanager.impl.TradeManagerWithFreebie;
import it.unibo.objectmon.model.item.trademanager.impl.TradeManagerWithPenalty;
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
    private Model model;
    private final View view;
    private final GameLoop gameLoop;

    /**
     * Constructs the controller and initializes the model dependencies.
     */
    public ControllerImpl() {
        this.commandQueue = new ArrayBlockingQueue<>(COMMAND_LIMIT);
        this.view = new SwingViewImpl(this);
        this.gameLoop = new GameLoopImpl(view, this);
        initializeModel();
    }

    /**
     * Initializes the Model.
     */
    public void initializeModel() {
        final GameStateManager gameStateManager = new GameStateManagerImpl();
        final TradeManager tradeManager = new TradeManagerWithFreebie(3, 
            new TradeManagerWithPenalty(0.5, 
            new TradeManagerImpl()));
        final TradeInitiator tradeInitiator = () -> gameStateManager.setGameState(GameState.TRADE);
        final BattleManager battleManager = new BattleManagerImpl(gameStateManager);
        final BattleInitiator battleInitiator = (player, trainer, objectmon) -> {
            battleManager.startBattle(player, trainer, objectmon);
        };
        final GameContext gameContext = GameContexts.createDefaultContext(battleInitiator, tradeInitiator);
        final CollisionManager collisionManager = new CollisionManagerImpl(gameContext.getWorld(), gameContext.getNPCs());
        final InteractionManager interactionManager = new InteractionManagerImpl();
        final EndGameManager endGameManager = new EndGameManagerImpl(gameStateManager);
        final RandomEncounterManager randomEncounterManager = new RandomEncounterManagerImpl(gameContext, battleInitiator, 5);
        this.model = new ModelImpl(gameContext, interactionManager, collisionManager, battleManager,
        gameStateManager, tradeManager, randomEncounterManager, endGameManager);
        gameStateManager.registerObserver(this.view);
        gameStateManager.setGameState(GameState.EXPLORATION);
        gameStateManager.notifyObservers();
    }

    @Override
    @SuppressFBWarnings(value = "RV_RETURN_VALUE_IGNORED_BAD_PRACTICE", 
                        justification = "Ignoring the return value of offer() is intended in this case.")
    public void notifyCommand(final Command command) {
        this.commandQueue.offer(command);
    }

    @Override
    public Command pollCommand() {
        return this.commandQueue.poll();
    }

    @Override
    public void execute() {
        final Command command = commandQueue.poll();
        if (command != null) {
            command.execute(model);
        }
    }

    @Override
    public void restart() {
        initializeModel();
    }

    @Override
    public void startGame() {
        this.gameLoop.start();
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

    @Override
    public boolean isWin() {
        for (final var npc : this.model.getGameContext().getNPCs()) {
            if (npc instanceof Trainer) {
                final Trainer trainer = (TrainerImpl) npc;
                if (!trainer.isDefeated()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isLoss() {
        return this.model.getGameContext().getPlayer().isDefeated();
    }

    @Override
    public void shutdown() {
        this.gameLoop.stop();
    }
}
