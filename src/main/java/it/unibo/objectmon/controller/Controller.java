package it.unibo.objectmon.controller;

import java.util.List;
import java.util.Set;
import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.npc.ReadOnlyNPC;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.world.api.World;
import java.util.Optional;

/**
 * The Controller interface.
 * It defines methods for managing game commands,
 * controlling game state, retrieving game entities.
 */
public interface Controller {

    /**
     * Notifies the controller of a new Command.
     *
     * @param command The Command to be added to the command queue.
     */
    void notifyCommand(Command command);

    /**
     * Polls a command.
     *
     * @return A command from the queue.
     */
    Command pollCommand();

    /**
     * Starts the game.
     */
    void startGame();

    /**
     * Returns the npcs in the game.
     *
     * @return The npc in the game.
     */
    Set<ReadOnlyNPC> getNPCSet();

    /**
     * Returns the world in the game.
     *
     * @return The world in the game.
     */
    World getWorld();

    /**
     * Retrieves a read only wrapper of the Player.
     *
     * @return A read only wrapper of the Player.
     */
    Player getPlayer();

    /**
     * Returns messages originating from interaction in EXPLORATION MODE.
     *
     * @return A list of messages.
     */
    List<String> getMessageLog();

    /**
     * informations of the battle.
     * @return contains the informations of the battle.
     */
    Optional<Battle> getBattleStats();
    /**
     * Retrieves the current game state.
     * @return The game state.
     */
    GameState getGameState();
}
