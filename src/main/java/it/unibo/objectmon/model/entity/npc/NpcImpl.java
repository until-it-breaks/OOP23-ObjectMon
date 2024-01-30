package it.unibo.objectmon.model.entity.npc;

import it.unibo.objectmon.model.PlayerManager;
import it.unibo.objectmon.model.entity.api.EntityImpl;
import it.unibo.objectmon.model.entity.api.Npc;
import it.unibo.objectmon.model.entity.api.NpcType;
import it.unibo.objectmon.model.interaction.BattleHandler;
import it.unibo.objectmon.model.interaction.HealHandler;
import it.unibo.objectmon.model.interaction.TradeHandler;
import it.unibo.objectmon.model.interaction.api.InteractionHandler;
import it.unibo.objectmon.model.world.Coord;
import java.util.Optional;
/**
 * Models an npc with a behaviour that can be triggered on interaction.
 */
public final class NpcImpl extends EntityImpl implements Npc {
    private final NpcType npcType;
    private final Optional<InteractionHandler> interactionHandler;
    /**
     * Creates an npc and assigns its {@link InteractionHandler} based on its {@link npcType}.
     * @param name the npc name
     * @param npcType the npc type
     * @param coord the npc position
     */
    public NpcImpl(final String name, final Coord coord, final NpcType npcType) {
        super(name, coord);
        this.npcType = npcType;
        switch (npcType) {
            case TRADER:
                this.interactionHandler = Optional.of(new TradeHandler());
                break;
            case HEALER:
                this.interactionHandler = Optional.of(new HealHandler());
                break;
            case TRAINER:
                this.interactionHandler = Optional.of(new BattleHandler());
                break;
            default:
                this.interactionHandler = Optional.empty();
                break;
        }
    }
    @Override
    public void handleInteraction(final PlayerManager player) {
        if (this.interactionHandler.isPresent()) {
            this.interactionHandler.get().handleInteraction(player);
        }
    }
    @Override
    public NpcType getNpcType() {
        return this.npcType;
    }
}
