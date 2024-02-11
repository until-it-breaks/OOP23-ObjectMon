package it.unibo.objectmon.controller;

import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.controller.engine.GameLoop;
import it.unibo.objectmon.controller.engine.GameLoopImpl;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.ModelImpl;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.npc.ReadOnlyNPC;
import it.unibo.objectmon.model.entities.player.ReadOnlyPlayer;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.world.api.World;
import it.unibo.objectmon.view.View;
import it.unibo.objectmon.view.ViewImpl;

/**
 * Models the controller of the application.
 */
public final class ControllerImpl implements Controller {

    private static final int COMMAND_LIMIT = 16;
    private final Queue<Command> commandQueue;
    private final Model model;
    private final View view;

    /**
     * Constructs the controller.
     */
    public ControllerImpl() {
        this.model = new ModelImpl();
        this.view = new ViewImpl(this);
        this.commandQueue = new ArrayBlockingQueue<>(COMMAND_LIMIT);
        this.model.getGameStateManager().registerObserver(view);
        this.model.getGameStateManager().setGameState(GameState.EXPLORATION);
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
    public Set<ReadOnlyNPC> getNPCSet() {
    return model.getGameContext().getNPCs().stream()
            .map(ReadOnlyNPC::new)
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
    public List<String> getMessageLog() {
        return model.getInteractionManager().getMessages();
    }

    @Override
    public GameState getGameState() {
        return model.getGameStateManager().getGameState();
    }
}
