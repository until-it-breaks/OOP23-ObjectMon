package it.unibo.objectmon.controller;

import java.util.List;
import java.util.Set;
import it.unibo.objectmon.controller.commands.api.Command;
import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.npc.EntityReadOnly;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.misc.battlelog.api.BattleLogger;
import it.unibo.objectmon.model.world.api.World;
import java.util.Optional;

/**
 * Defines methods for managing game commands,
 * controlling game state and retrieving game entities.
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
     * Immediately execute a command in the queue, if present.
     */
    void execute();

    /**
     * Starts the game.
     */
    void startGame();

    /**
     * Retrieves the npcs in the game.
     *
     * @return The npc in the game.
     */
    Set<EntityReadOnly> getNPCSet();

    /**
     * Retrieves the world in the game.
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
    List<String> getInteractionLog();

    /**
     * Retrieves informations of the battle.
     * 
     * @return contains the informations of the battle.
     */
    Optional<Battle> getBattleStats();

    /**
     * Retrieves the current game state.
     * 
     * @return The game state.
     */
    GameState getGameState();

    /**
     * Returns the battle logger.
     * 
     * @return The battle logger.
     */
    BattleLogger getBattleLogger();

    /**
     * Inizializes a new game.
     */
    void restart();

    /**
     * Checks if the player has won the game.
     * 
     * @return true if all Trainers have been defeated, false otherwise.
     */
    boolean gameWon();

    /**
     * Checks if the player has lost the game.
     * 
     * @return true if all the Player's Objectmon are dead. false otherwise.
     */
    boolean gameLost();

    /**
     * Shuts down the game.
     */
    void shutdown();

    /**
     * Retrieves the frames per second from the game engine.
     * 
     * @return The frames per second.
     */
    int getFPS();
}
