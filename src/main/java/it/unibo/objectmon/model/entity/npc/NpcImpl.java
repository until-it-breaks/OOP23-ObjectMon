package it.unibo.objectmon.model.entity.npc;

import it.unibo.objectmon.model.entity.api.EntityImpl;
import it.unibo.objectmon.model.entity.api.Npc;
import it.unibo.objectmon.model.entity.player.PlayerImpl;
import it.unibo.objectmon.model.interaction.InteractionHandler;
import it.unibo.objectmon.model.world.Coord;

public class NpcImpl extends EntityImpl implements Npc {

    private InteractionHandler interactionHandler;

    public NpcImpl(String name, Coord coord, InteractionHandler interactionHandler) {
        super(name, coord);
        this.interactionHandler = interactionHandler;
    }

    @Override
    public void handleInteraction(PlayerImpl player) {
        if (this.interactionHandler != null) {
            interactionHandler.handleInteraction(player);
        }
    }
}
