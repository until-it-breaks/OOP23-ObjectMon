package it.unibo.objectmon.model.battle.impl;
/**
 * class with messages produced from a battle.
 */
public interface BattleMessages {
    /**
     * 
     * @param playerName
     * @param trainerName
     * @return text when battle start with trainer.
     */
    String formatBattleTrainer(String playerName, String trainerName);
    /**
     * 
     * @param playerName
     * @param wildObjectmon
     * @return text when battle start with wild objectmon.
     */
    String formatBattleWildObjectmon(String playerName, String wildObjectmon);
    /**
     * 
     * @param objectmon
     * @param target
     * @param damage
     * @return text when an objectmon use an attack.
     */
    String formatAttack(String objectmon, String target, int damage);
}
