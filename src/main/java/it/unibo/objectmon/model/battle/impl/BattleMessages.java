package it.unibo.objectmon.model.battle.impl;
/**
 * class with messages produced from a battle.
 */
public interface BattleMessages {
    /**
     * 
     * @param playerName The involved player.
     * @param trainerName The involved trainer.
     * @return text when battle start with trainer.
     */
    String formatBattleTrainer(String playerName, String trainerName);
    /**
     * 
     * @param playerName The involved player.
     * @param wildObjectmon The involved wild Objectmon.
     * @return text when battle start with wild objectmon.
     */
    String formatBattleWildObjectmon(String playerName, String wildObjectmon);
    /**
     * 
     * @param objectmon The Objectmon performing the attack.
     * @param target The Objectmon receiving the attack.
     * @param damage The damage dealt.
     * @return text when an objectmon use an attack.
     */
    String formatAttack(String objectmon, String target, int damage);
}
