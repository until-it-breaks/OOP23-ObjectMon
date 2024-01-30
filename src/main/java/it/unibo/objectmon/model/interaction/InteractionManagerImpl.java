package it.unibo.objectmon.model.interaction;

import java.util.Set;

import it.unibo.objectmon.model.PlayerController;
import it.unibo.objectmon.model.entity.api.Npc;
import it.unibo.objectmon.model.interaction.api.InteractionManager;
/**
 * Models a interaction manager that triggers an npc's interaction if the npc is right in front of the player.
 */
public final class InteractionManagerImpl implements InteractionManager {
    @Override
    public void triggerInteraction(final Set<Npc> npcs, final PlayerController player) {
        for (final Npc npc : npcs) {
            if (npc.getPosition().equals(player.getPosition())) {
                npc.handleInteraction(player);
                break;
            }
        }
    }
}
