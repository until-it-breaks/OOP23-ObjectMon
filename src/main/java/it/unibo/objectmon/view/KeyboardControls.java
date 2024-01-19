package it.unibo.objectmon.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.controller.commands.MoveDown;
import it.unibo.objectmon.controller.commands.MoveLeft;
import it.unibo.objectmon.controller.commands.MoveRight;
import it.unibo.objectmon.controller.commands.MoveUp;

/**
 * Key controls for the player character.
 */
public final class KeyboardControls implements KeyListener {

    private final Controller controller;

    /**
     * Hooks the key controls to controller.
     * 
     * @param controller the target controller.
     */
    public KeyboardControls(final Controller controller) {
        this.controller = controller;
    }

    @Override
    public void keyTyped(final KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        final int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            controller.notifyCommand(new MoveUp());
        } else if (keyCode == KeyEvent.VK_A) {
            controller.notifyCommand(new MoveLeft());
        } else if (keyCode == KeyEvent.VK_S) {
            controller.notifyCommand(new MoveDown());
        } else if (keyCode == KeyEvent.VK_D) {
            controller.notifyCommand(new MoveRight());
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
    }
}
