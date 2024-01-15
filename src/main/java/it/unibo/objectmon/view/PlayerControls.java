package it.unibo.objectmon.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import it.unibo.objectmon.controller.MainController;
import it.unibo.objectmon.controller.MoveDown;
import it.unibo.objectmon.controller.MoveLeft;
import it.unibo.objectmon.controller.MoveRight;
import it.unibo.objectmon.controller.MoveUp;

/**
 * Key controls for the player character.
 */
public final class PlayerControls implements KeyListener {

    private final MainController controller;

    /**
     * Hooks the key controls to controller.
     * 
     * @param controller the target controller.
     */
    public PlayerControls(final MainController controller) {
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
