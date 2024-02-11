package it.unibo.objectmon.model.item;

import java.util.*;

import org.apache.commons.collections4.set.CompositeSet.SetMutator;

import it.unibo.objectmon.model.item.api.BallItem;
import it.unibo.objectmon.model.item.api.HealItem;
import it.unibo.objectmon.model.item.api.Item;
import it.unibo.objectmon.model.item.impl.BallItemImpl;
import it.unibo.objectmon.model.item.impl.HealItemImpl;

public class ItemSet {
    
    private final Set<HealItem> HealItemSet;
    private final Set<BallItem> BallItemSet;

    public ItemSet() {
        this.HealItemSet = new HashSet<>();
        this.BallItemSet = new HashSet<>();
        init();
    }

    public Set<HealItem> getHealItemSet(){
        return this.HealItemSet;
    }

    public Set<BallItem> getBallItemSet(){
        return this.BallItemSet;
    }


    private void init(){

        HealItemSet.add(new HealItemImpl("small heal", 50, 20));
        HealItemSet.add(new HealItemImpl("medium heal", 100, 40));
        HealItemSet.add(new HealItemImpl("large heal", 200, 60));

        BallItemSet.add(new BallItemImpl("Object Ball", 100, 1.0));
        BallItemSet.add(new BallItemImpl("Mega Ball", 200, 1.5));
        BallItemSet.add(new BallItemImpl("Ultra Ball", 400, 2.0));

        /*BallItemSet.add(new BallItem() {

            @Override
            public String getName() {
                return "Objectball";
            }

            @Override
            public int getValue() {
                return 50;
            }

            @Override
            public double getCatchMultiplier() {
                return 3.0;
            }
            
        });*/
    }
    
    public static void main(String[] args) {
        ItemSet itemset = new ItemSet();
        for (var Item : itemset.getBallItemSet()) {
            System.out.println(Item.getValue());
        }

    }
}
