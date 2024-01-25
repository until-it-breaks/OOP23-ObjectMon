package it.unibo.objectmon.model.entity.npc;

import it.unibo.objectmon.model.entity.api.EntityImpl;
import it.unibo.objectmon.model.entity.api.Npc;
import it.unibo.objectmon.model.entity.api.NpcType;
import it.unibo.objectmon.model.entity.api.Player;
import it.unibo.objectmon.model.interaction.BattleHandler;
import it.unibo.objectmon.model.interaction.HealHandler;
import it.unibo.objectmon.model.interaction.InteractionHandler;
import it.unibo.objectmon.model.interaction.TradeHandler;
import it.unibo.objectmon.model.world.Coord;

public class NpcImpl extends EntityImpl implements Npc {
    private NpcType npcType;
    private InteractionHandler interactionHandler;

    public NpcImpl(String name, NpcType npcType, Coord coord) {
        super(name, coord);
        this.npcType = npcType;
        switch (npcType) {
            case TRADER:
                this.interactionHandler = new TradeHandler();
                break;
            case HEALER:
                this.interactionHandler = new HealHandler();
                break;
            case TRAINER:
                this.interactionHandler = new BattleHandler();
                break;
            default:
                break;
        }
    }
    
    @Override
    public void handleInteraction(Player player) {
        if (this.interactionHandler != null) {
            interactionHandler.handleInteraction(player);
        }
    }

    public NpcType getNpcType() {
        return this.npcType;
    }
}
