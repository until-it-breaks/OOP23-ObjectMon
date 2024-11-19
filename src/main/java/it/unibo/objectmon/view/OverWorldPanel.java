package it.unibo.objectmon.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.model.data.api.objectmon.Objectmon;
import it.unibo.objectmon.model.data.api.statistics.StatEnum;
import it.unibo.objectmon.model.entities.api.Healer;
import it.unibo.objectmon.model.entities.api.Seller;
import it.unibo.objectmon.model.entities.api.Trainer;
import it.unibo.objectmon.model.entities.npc.EntityReadOnly;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.misc.eventlog.InteractionLoggerImpl;
import it.unibo.objectmon.model.world.api.Coord;
import it.unibo.objectmon.view.controls.OverWorldControls;
import it.unibo.objectmon.view.utility.ImageLoader;
import it.unibo.objectmon.view.utility.ImageLoaderImpl;
import it.unibo.objectmon.view.utility.RenderingUtils;

/**
 * A {@link JPanel} responsible for rendering the overworld.
 * This panel displays the game world, including the player character, NPCs, and terrain tiles.
 */
public final class OverWorldPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int TILE_SIZE = 48;
    private static final int INVENTORY_X_OFFSET = 20;
    private static final int INVENTORY_Y_OFFSET = 20;
    private static final int FPS_Y_OFFSET = 20;
    private static final int FPS_X_OFFSET = 60;
    private static final int FONT_SIZE = 13;
    private static final String FONT_NAME = "Arial";
    private final transient Controller controller;
    private final transient ImageLoader imageLoader;

    /**
     * Constructs a new {@link OverWorldPanel}, initializing its properties and attaching it to the provided {@link Controller}.
     * 
     * @param controller The {@link Controller} responsible for managing inputs and providing game data.
     */
    public OverWorldPanel(final Controller controller) {
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        this.controller = controller;
        this.imageLoader = new ImageLoaderImpl();
        this.addKeyListener(new OverWorldControls(controller));
        this.setFocusable(true);
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
            // Computes the offset needed to center the camera.
            final int playerX = controller.getPlayer().getPosition().x() * TILE_SIZE;
            final int playerY = controller.getPlayer().getPosition().y() * TILE_SIZE;
            final double cameraX = getWidth() / 2 - playerX;
            final double cameraY = getHeight() / 2 - playerY;
            // Centers the camera.
            graphics2d.translate(cameraX, cameraY);
            drawWorld(graphics2d);
            drawNPCs(graphics2d);
            drawPlayer(graphics2d);
            // Reverts to the previous position.
            graphics2d.translate(-cameraX, -cameraY);
            drawHUD(graphics2d);
            graphics2d.dispose();
        }
    }

    private void drawHUD(final Graphics2D g) {
        drawInventory(g);
        drawEventLog(g);
        drawParty(g);
        drawFPS(g);
    }

    private void drawNPCs(final Graphics2D g) {
        for (final EntityReadOnly npc : controller.getNPCSet()) {
            final BufferedImage image = getNPCImage(npc);
            g.drawImage(image, npc.getPosition().x() * TILE_SIZE, npc.getPosition().y() * TILE_SIZE, null);
        }
    }

    private void drawPlayer(final Graphics2D g) {
        final BufferedImage image = getPlayerImage();
        final Coord playerCoord = controller.getPlayer().getPosition();
        g.drawImage(image, playerCoord.x() * TILE_SIZE, playerCoord.y() * TILE_SIZE, null);
    }

    private void drawWorld(final Graphics2D g) {
        for (final var entry : controller.getWorld().getMap().entrySet()) {
            final BufferedImage image = imageLoader.getImage(entry.getValue().getImagePath());
            final int tileX = entry.getKey().x();
            final int tileY = entry.getKey().y();
            g.drawImage(image, tileX  * TILE_SIZE, tileY * TILE_SIZE, null);
        }
    }

    private void drawEventLog(final Graphics2D g) {
        final List<String> messages = controller.getInteractionLog();
        final int lineHeight = 20;
        final int boxHeight = InteractionLoggerImpl.LIMIT * lineHeight;
        // Calculates the position and size of the black box at the bottom left of the panel.
        final int boxX = 0;
        final int boxY = getHeight() - boxHeight;
        final int boxWidth = getWidth() / 2; // Adjusted to cover half of the panel width.
        // Draws the border.
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(boxX, boxY, boxWidth, boxHeight);
        // Fills the black box.
        g.setColor(Color.BLACK);
        g.fillRect(boxX + 1, boxY + 1, boxWidth - 1, boxHeight - 1);
        g.setColor(Color.WHITE);
        g.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        // Adjustment to draw the text a little higher.
        final int startY = boxY + lineHeight - 5; 
        // Draws messages from the top to the bottom.
        for (int i = 0; i < messages.size(); i++) {
            final String message = messages.get(i);
            g.drawString(message, boxX + 10, startY + (i * lineHeight));
        }
    }

    private void drawParty(final Graphics2D g) {
        final List<Objectmon> objectmonList = controller.getPlayer().getObjectmonParty().getParty();
        int offsetX = getWidth() - (objectmonList.size() * TILE_SIZE);
        final int offsetY = getHeight() - TILE_SIZE;

        for (final Objectmon objectmon : objectmonList) {
            final BufferedImage image = imageLoader.getImage("/hud/objectmons/" + objectmon.getName() + ".png");
            // Draws the objectmon portrait.
            g.drawImage(image, offsetX, offsetY, TILE_SIZE, TILE_SIZE, null);
            g.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
            g.setColor(Color.WHITE);
            // Draws the level above the health counter.
            g.drawString("Lv." + objectmon.getLevel(), offsetX, offsetY - TILE_SIZE / 2);
            // Draws the health counter above the image.
            g.drawString(objectmon.getCurrentHp() + "/" + objectmon.getStats().getSingleStat(StatEnum.HP),
            offsetX, offsetY - TILE_SIZE / FONT_SIZE);
            offsetX += TILE_SIZE;
        }
    }

    private void drawInventory(final Graphics2D g) {
        final Map<Item, Integer> inventory = controller.getPlayer().getInventory().getItems();
        final int offsetX = INVENTORY_X_OFFSET;
        int offsetY = INVENTORY_Y_OFFSET;
        for (final var entry : inventory.entrySet()) {
            final Item item = entry.getKey();
            g.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
            g.setColor(Color.WHITE);
            g.drawString(item.getName() + ": " + entry.getValue(), offsetX, offsetY);
            offsetY += FONT_SIZE;
        }
    }

    private void drawFPS(final Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        g.drawString("FPS: " + controller.getFPS(), getWidth() - FPS_X_OFFSET, FPS_Y_OFFSET);
    }

    private BufferedImage getNPCImage(final EntityReadOnly npc) {
        if (npc.implementsInterface(Seller.class)) {
            return imageLoader.getImage("/npc/vendor.png");
        } else if (npc.implementsInterface(Healer.class)) {
            return imageLoader.getImage("/npc/doctor.png");
        } else if (npc.implementsInterface(Trainer.class)) {
            return imageLoader.getImage("/npc/trainer.png");
        } else {
            return imageLoader.getImage("/npc/default.png");
        }
    }

    private BufferedImage getPlayerImage() {
        final String imagePath;
        switch (controller.getPlayer().getDirection()) {
            case UP:
                imagePath = "/player/player_up.png";
                break;
            case DOWN:
                imagePath = "/player/player_down.png";
                break;
            case LEFT:
                imagePath = "/player/player_left.png";
                break;
            case RIGHT:
                imagePath = "/player/player_right.png";
                break;
            default:
                imagePath = "/player/player_down.png";
        }
        return imageLoader.getImage(imagePath);
    }
}
