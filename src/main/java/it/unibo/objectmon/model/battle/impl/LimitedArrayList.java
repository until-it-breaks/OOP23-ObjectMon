package it.unibo.objectmon.model.battle.impl;

import java.util.ArrayList;
/**
 * A limited ArrayList which has a max size 6.
 * @param <E> the element of LimitedArrayList.
 */
public class LimitedArrayList<E> extends ArrayList<E> {
    private static final int PARTY_SIZE = 6;
    public static final long serialVersionUID = 4328743;
    @Override
    /**
     * add element only if the size is less than max size.
     * @return false if the size is achieved to max size.
     * 
     */
    public final boolean add(final E e) {
        if (this.size() < LimitedArrayList.PARTY_SIZE) {
            super.add(e);
        }
        return false;
    }
}
