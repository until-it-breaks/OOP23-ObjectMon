package it.unibo.objectmon.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import it.unibo.objectmon.controller.Controller;
import it.unibo.objectmon.model.entity.npc.AbstractNPC;
import it.unibo.objectmon.model.entity.npc.api.Healer;
import it.unibo.objectmon.model.entity.npc.api.Seller;
import it.unibo.objectmon.model.entity.npc.api.Trainer;
import it.unibo.objectmon.model.world.Coord;
import it.unibo.objectmon.view.controls.OverWorldControls;
import it.unibo.objectmon.view.utility.ImageLoader;
import it.unibo.objectmon.view.utility.ImageLoaderImpl;
import it.unibo.objectmon.view.utility.RenderingHelper;

/**
 * A JPanel responsible for rendering the overworld environment and entities during exploration mode.
 * This panel displays the game world, including the player character, NPCs, and terrain tiles,
 * providing a visual representation of the game state to the user.
 */
public final class OverWorldPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int TILE_SIZE = 48;
    private final transient Controller controller;
    private final transient ImageLoader textureLoader;

    /**
     * Constructs a new OverWorld panel, initializing its properties and attaching it to the provided controller.
     * 
     * @param controller the controller responsible for managing inputs and retrieving game data.
     */
    public OverWorldPanel(final Controller controller) {
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        this.controller = controller;
        this.textureLoader = new ImageLoaderImpl();
        this.addKeyListener(new OverWorldControls(controller));
        this.setFocusable(true);
    }

    /**
     * This method is automatically invoked by Swing to redraw the panel when necessary.
     * 
     * @param g the Graphics context in which to paint.
     */
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (g instanceof Graphics2D) {
            final Graphics2D graphics2d = (Graphics2D) g;
            final RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_RENDERING, 
            RenderingHints.VALUE_RENDER_SPEED);
            graphics2d.setRenderingHints(renderingHints);

            final int playerX = controller.getGameManager().getPlayerController().getPosition().x() * TILE_SIZE;
            final int playerY = controller.getGameManager().getPlayerController().getPosition().y() * TILE_SIZE;
            final double cameraX = RenderingHelper.getScreenCenter().getWidth() - playerX;
            final double cameraY = RenderingHelper.getScreenCenter().getHeight() - playerY;
            graphics2d.translate(cameraX, cameraY);

            drawWorld(graphics2d);
            drawNPCs(graphics2d);
            drawPlayer(graphics2d);
            graphics2d.dispose();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void drawNPCs(final Graphics2D g) {
        for (final AbstractNPC npc : controller.getGameManager().getNpcManager().getNpcs()) {
            final BufferedImage image = getNPCImage(npc);
            final int npcX = npc.getPosition().x();
            final int npcY = npc.getPosition().y();
            g.drawImage(image, npcX * TILE_SIZE, npcY * TILE_SIZE, null);
        }
    }

    private void drawPlayer(final Graphics2D g) {
        final BufferedImage image = getPlayerImage();
        final Coord playerPosition = controller.getGameManager().getPlayerController().getPosition();
        g.drawImage(image, playerPosition.x() * TILE_SIZE, playerPosition.y() * TILE_SIZE, null);
    }

    private void drawWorld(final Graphics2D g) {
        for (final var entry : controller.getGameManager().getWorld().getMap().entrySet()) {
            final BufferedImage image = textureLoader.getImage(entry.getValue().getImagePath());
            final int tileX = entry.getKey().x();
            final int tileY = entry.getKey().y();
            g.drawImage(image, tileX  * TILE_SIZE, tileY * TILE_SIZE, null);
        }
    }

    private BufferedImage getNPCImage(final AbstractNPC npc) {
        if (npc instanceof Seller) {
            return textureLoader.getImage("/npc/vendor.png");
        } else if (npc instanceof Healer) {
            return textureLoader.getImage("/npc/doctor.png");
        } else if (npc instanceof Trainer) {
            return textureLoader.getImage("/npc/trainer.png");
        } else {
            return textureLoader.getImage("/npc/default.png");
        }
    }

    private BufferedImage getPlayerImage() {
        final String imagePath; // Declare imagePath outside the switch
        switch (controller.getGameManager().getPlayerController().getDirection()) {
            case UP:
                imagePath = "/player/playerUp.png";
                break;
            case DOWN:
                imagePath = "/player/playerDown.png";
                break;
            case LEFT:
                imagePath = "/player/playerLeft.png";
                break;
            case RIGHT:
                imagePath = "/player/playerRight.png";
                break;
            default:
                throw new IllegalStateException();
        }
        return textureLoader.getImage(imagePath);
    }
}
