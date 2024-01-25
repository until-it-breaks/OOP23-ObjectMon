package it.unibo.objectmon.model.interaction;

import java.util.Set;
import it.unibo.objectmon.model.entity.api.Npc;
import it.unibo.objectmon.model.entity.api.Player;

public class InteractionManager {
    /**
     * Upon calling an interaction a check is performed and if there is an npc above the player the npc behaviour is triggered.
     */
    public void triggerInteraction(Set<Npc> npcs, Player player) {
        for (Npc npc : npcs) {
            if (npc.getPosition().equals(player.getPosition())) {
                npc.handleInteraction(player);
                break;
            }
        }
    }
}
