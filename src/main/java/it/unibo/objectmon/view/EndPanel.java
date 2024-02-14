package it.unibo.objectmon.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JPanel;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.statistics.StatId;
import it.unibo.objectmon.model.gamestate.GameState;
import it.unibo.objectmon.model.world.api.Coord;
import it.unibo.objectmon.view.utility.ImageLoader;
import it.unibo.objectmon.view.utility.ImageLoaderImpl;
import it.unibo.objectmon.view.utility.RenderingUtils;

/**
 * A {@link JPanel} responsible for rendering the End screen.
 * This panel displays the including the player character and, if they won, also their party.
 */
public final class EndPanel extends JPanel {

    private static final int FONT_SIZE = 13;
    private static final long serialVersionUID = 1L;
    private static final int TILE_SIZE = 48;
    private final transient Controller controller;
    private final transient ImageLoader imageLoader;
    private final boolean isWin;

    /**
     * Constructs a new {@link EndPanel}, initializing its properties and attaching it to the provided {@link Controller}.
     *
     * @param controller The {@link Controller} responsible for managing inputs and providing game data.
     * @param endState The endstate of the game. It can be either WIN or LOSS
     */
    public EndPanel(final Controller controller, final GameState endState) {
        this.isWin = endState.equals(GameState.WIN);
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        this.controller = controller;
        this.imageLoader = new ImageLoaderImpl();
        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(final KeyEvent e) {
            }

            @Override
            public void keyPressed(final KeyEvent e) {
                final int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_ENTER) {
                    controller.restart();
                }
            }

            @Override
            public void keyReleased(final KeyEvent e) {
            }

        });
    }

    /**
     * This method is automatically invoked by Swing to redraw the panel.
     *
     * @param g The Graphics context in which to draw.
     */
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (g instanceof Graphics2D) {
            final Graphics2D graphics2d = (Graphics2D) g;
            RenderingUtils.configureRenderingHints(graphics2d);
            //Computes the offset needed to center the camera.
            final double cameraX = getWidth() / 2 - controller.getPlayer().getPosition().x() * TILE_SIZE;
            final double cameraY = getHeight() / 2 - controller.getPlayer().getPosition().y() * TILE_SIZE;
            //Centers the camera.
            graphics2d.translate(cameraX, cameraY);
            drawAll(graphics2d);
            graphics2d.dispose();
        }
    }
    /**
     *
     * @param g
     */
    private void drawAll(final Graphics2D g) {
        final List<Objectmon> objectmonList = controller.getPlayer().getObjectmonParty().getParty();
        final Coord center = controller.getPlayer().getPosition();
        final int offsetY = center.y() * TILE_SIZE;
        final int textsize = TILE_SIZE - 60;

        drawPlayer(g);
        if (!isWin) {
            final int offsetX = center.x() * TILE_SIZE - TILE_SIZE;
            g.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
            g.setColor(Color.RED);
            g.drawString("YOU LOSE !", offsetX + TILE_SIZE, offsetY - TILE_SIZE * 2);
            g.drawString("PRESS ENTER TO PLAY AGAIN", offsetX + textsize, offsetY - TILE_SIZE * 2 + FONT_SIZE);
        } else {
            final int offsetX = center.x() * TILE_SIZE - (objectmonList.size() - 1) * TILE_SIZE / 2;
            drawParty(g, offsetX, offsetY, objectmonList);
            g.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
            g.setColor(Color.WHITE);
            g.drawString("YOU WIN !", offsetX + TILE_SIZE, offsetY - TILE_SIZE * 2);
            g.drawString("PRESS ENTER TO PLAY AGAIN", offsetX + textsize, offsetY - TILE_SIZE * 2 + FONT_SIZE);
        }

    }

    private void drawPlayer(final Graphics2D g) {
        final BufferedImage image = isWin
        ? imageLoader.getImage("/player/player_up.png")
        : imageLoader.getImage("/player/player_down.png");
        final Coord playerCoord = controller.getPlayer().getPosition();
        final int playerOffset = 50;
        g.drawImage(image, playerCoord.x() * TILE_SIZE, playerCoord.y() * TILE_SIZE + playerOffset, null);
    }

    private void drawParty(final Graphics2D g, final int offsetX, final int offsetY, final List<Objectmon> objectmonList) {
        int myOffsetX = offsetX;
        for (final Objectmon objectmon : objectmonList) {
            final BufferedImage image = imageLoader.getImage("/hud/objectmons/" + objectmon.getName() + ".png");
            //Draw the objectmon portrait

            //g.drawImage(image, playerCoord.x() * TILE_SIZE, playerCoord.y() * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
            g.drawImage(image, myOffsetX, offsetY, TILE_SIZE, TILE_SIZE, null);
            g.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
            g.setColor(Color.BLACK);
            //Draw level text above the health counter
            g.drawString("Lv." + objectmon.getLevel(), myOffsetX, offsetY - TILE_SIZE / 2);
            //Draw health counter above the image
            g.drawString(objectmon.getCurrentHp() + "/" + objectmon.getStats().getSingleStat(StatId.HP),
            myOffsetX, offsetY - TILE_SIZE / FONT_SIZE);
            myOffsetX += TILE_SIZE;
        }
    }
}
