package it.unibo.objectmon.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControls implements KeyListener {

    private boolean upPressed, downPressed, leftPressed, rightPressed;

    public boolean isUpPressed() {
        return this.upPressed;
    }

    public boolean isDownPressed() {
        return this.downPressed;
    }

    public boolean isLeftPressed() {
        return this.leftPressed;
    }

    public boolean isRightPressed() {
        return this.rightPressed;
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        /*Nothing happens*/
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            System.out.println("Moved up");
            this.upPressed = true;
        }
        if (keyCode == KeyEvent.VK_A) {
            System.out.println("Moved left");
            this.leftPressed = true;
        }
        if (keyCode == KeyEvent.VK_S) {
            System.out.println("Moved down");
            this.downPressed = true;
        }
        if (keyCode == KeyEvent.VK_D) {
            System.out.println("Moved right");
            this.rightPressed = true;
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            this.upPressed = false;
        }
        if (keyCode == KeyEvent.VK_A) {
            this.leftPressed = false;
        }
        if (keyCode == KeyEvent.VK_S) {
            this.downPressed = false;
        }
        if (keyCode == KeyEvent.VK_D) {
            this.rightPressed = false;
        }
    }
}
