package it.unibo.objectmon.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.controller.engine.GameLoop;
import it.unibo.objectmon.controller.readonly.ReadOnlyNPC;
import it.unibo.objectmon.controller.readonly.ReadOnlyPlayer;
import it.unibo.objectmon.model.Model;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.npc.AbstractNPC;
import it.unibo.objectmon.model.world.World;
import it.unibo.objectmon.view.api.View;

/**
 * Models the controller of the application.
 */
public final class Controller {

    private static final int COMMAND_LIMIT = 16;
    private final Queue<Command> commandQueue;
    private final Model model;
    private final View view;

    /**
     * Constructs the controller.
     * 
     * @param model the model from which information is retrieved.
     * @param view  the view on which to render and from which inputs are received.
     */
    public Controller(final Model model, final View view) {
        this.model = model;
        this.view = view;
        this.commandQueue = new ArrayBlockingQueue<>(COMMAND_LIMIT);
    }

    /**
     * Notifies the controller of a new Command.
     * 
     * @param command the command to be added to the command queue.
     */
    public void notifyCommand(final Command command) {
        this.commandQueue.add(command);
    }

    /**
     * Polls a command.
     * 
     * @return a command from the queue.
     */
    public Command pollCommand() {
        return this.commandQueue.poll();
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        final GameLoop gameLoop = new GameLoop(model, view, this);
        gameLoop.startLoop();
    }

    /**
     * Returns the npcs in the game.
     * 
     * @return the npc in the game.
     */
    public Set<ReadOnlyNPC> getNPCs() {
        final Set<AbstractNPC> npcs = model.getGameContext().getNpcManager().getNPCs();
        final Set<ReadOnlyNPC> out = new HashSet<>();
        for (final AbstractNPC readOnlyNPC : npcs) {
            out.add(new ReadOnlyNPC(readOnlyNPC));
        }
        return out;
    }

    /**
     * Returns the world in the game.
     * 
     * @return the world in the game.
     */
    public World getWorld() {
        return model.getGameContext().getWorld();
    }

    /**
     * Retrieves a read only wrapper of the Player.
     * 
     * @return a read only wrapper of the Player.
     */
    public Player getPlayer() {
        return new ReadOnlyPlayer(model.getGameContext().getPlayer());
    }

    /**
     * Returns messages originating from interaction in EXPLORATION MODE.
     * 
     * @return A list of messages.
     */
    public List<String> getMessageLog() {
        return model.getInteractionManager().getMessages();
    }
}
