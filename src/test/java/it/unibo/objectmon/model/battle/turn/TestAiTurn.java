package it.unibo.objectmon.model.battle.turn;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.battle.api.Battle;
import it.unibo.objectmon.model.battle.api.BattleManager;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;
import it.unibo.objectmon.model.entities.api.Player;
import it.unibo.objectmon.model.entities.api.Trainer;
import java.util.Optional;

class TestAiTurn {

    @Test
    void testExecute() {
        final BattleManager battleManager = mock(BattleManager.class);
        final Player player = mock(Player.class);
        final Trainer trainer = mock(Trainer.class);
        final Battle battle = mock(Battle.class);
        final ObjectmonParty playerParty = mock(ObjectmonParty.class);
        final ObjectmonParty aiParty = mock(ObjectmonParty.class);
        when(player.getObjectmonParty()).thenReturn(playerParty);
        when(trainer.getObjectmonParty()).thenReturn(aiParty);
        when(aiParty.getParty().size()).thenReturn(2);
        when(playerParty.getParty().size()).thenReturn(2);
        when(aiParty.getParty().get(0)).thenReturn(ObjectmonFactory.createObjectmon(ObjectmonEnum.ANORITH, 0));
        when(aiParty.getParty().get(1)).thenReturn(ObjectmonFactory.createObjectmon(ObjectmonEnum.GEODUDE, 0));
        when(playerParty.getParty().get(0)).thenReturn(ObjectmonFactory.createObjectmon(ObjectmonEnum.GOLDEEN, 0));
        when(playerParty.getParty().get(1)).thenReturn(ObjectmonFactory.createObjectmon(ObjectmonEnum.ILLUMISE, 0));
        when(battleManager.getBattleStats()).thenReturn(Optional.of(battle));
    }
}
