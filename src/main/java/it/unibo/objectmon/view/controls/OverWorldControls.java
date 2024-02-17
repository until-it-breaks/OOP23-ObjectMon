package it.unibo.objectmon.view.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.controller.commands.Interact;
import it.unibo.objectmon.controller.commands.MoveDown;
import it.unibo.objectmon.controller.commands.MoveLeft;
import it.unibo.objectmon.controller.commands.MoveRight;
import it.unibo.objectmon.controller.commands.MoveUp;

/**
 * Handles key events for controlling the player character in the overworld.
 * This class implements the KeyListener interface to listen for key events 
 * and dispatch corresponding commands to the specified controller.
 */
public final class OverWorldControls implements KeyListener {

    private final Controller controller;

    /**
     * Hooks the key controls to controller.
     * 
     * @param controller the target controller.
     */
    public OverWorldControls(final Controller controller) {
        this.controller = controller;
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        //Unused.
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        final int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                controller.notifyCommand(new MoveUp());
                break;
            case KeyEvent.VK_A:
                controller.notifyCommand(new MoveLeft());
                break;
            case KeyEvent.VK_S:
                controller.notifyCommand(new MoveDown());
                break;
            case KeyEvent.VK_D:
                controller.notifyCommand(new MoveRight());
                break;
            case KeyEvent.VK_J:
                controller.notifyCommand(new Interact());
                break;
            default:
                // No action for other keys.
                break;
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        //Unused.
    }
}
