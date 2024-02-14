package it.unibo.objectmon.model.item.trademanager.api;

/**
 * This interface defines a contract for objects that can signal t
 * he start of trade sessions.
 */
public interface TradeInitiator {

    /**
     * Signals the start of a trade session.
     */
    void onTradeStart();
}
