package it.unibo.objectmon.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import it.unibo.objectmon.controller.GameController;
import it.unibo.objectmon.controller.MoveDown;
import it.unibo.objectmon.controller.MoveLeft;
import it.unibo.objectmon.controller.MoveRight;
import it.unibo.objectmon.controller.MoveUp;

public final class PlayerControls implements KeyListener {

    private GameController controller;

    public PlayerControls(final GameController controller) {
        this.controller = controller;
    }

    @Override
    public void keyTyped(final KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        int keyCode = e.getKeyCode();
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
