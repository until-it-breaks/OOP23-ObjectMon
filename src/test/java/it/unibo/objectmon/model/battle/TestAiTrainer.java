package it.unibo.objectmon.model.battle;

import org.junit.jupiter.api.Test;

import it.unibo.objectmon.model.ai.EasyAiTrainer;
import it.unibo.objectmon.model.ai.api.AiTrainer;
import it.unibo.objectmon.model.data.api.objectmon.ObjectmonParty;
import it.unibo.objectmon.model.data.objectmon.ObjectmonEnum;
import it.unibo.objectmon.model.data.objectmon.ObjectmonFactory;
import it.unibo.objectmon.model.data.objectmon.ObjectmonPartyImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

/**
 * test ai trainer.
 */
class TestAiTrainer {
    private static final int MAX_NUM_SKILLS = 4;
    private final AiTrainer ai;
    private final ObjectmonParty objectmonParty;

    /**
     * constructor.
     */
    TestAiTrainer() {
        ai = new EasyAiTrainer();
        objectmonParty = new ObjectmonPartyImpl(
            List.of(ObjectmonFactory.createObjectmon(ObjectmonEnum.ANORITH, 0),
                ObjectmonFactory.createObjectmon(ObjectmonEnum.GEODUDE, 0))
        );
    }

    /**
     * test ai switch and use skill functions.
     */
    @Test
    void testAiTrainer() {
        final int index = ai.useSkill(objectmonParty.getParty().get(0));
        //test index is within available skills
        assertTrue(index >= 0 && index < MAX_NUM_SKILLS);
        //test index of switch
        assertEquals(1, ai.switchObjectmon(objectmonParty));
        assertEquals(0, ai.switchObjectmon(objectmonParty));
    }
}
