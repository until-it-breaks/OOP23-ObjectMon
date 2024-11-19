package it.unibo.objectmon.model.item.trademanager.api;

/**
 * This functional interface request the start of a trading session.
 */
public interface TradeInitiator {

    /**
     * Signals the start of a trade session.
     */
    void tradeStarted();
}
