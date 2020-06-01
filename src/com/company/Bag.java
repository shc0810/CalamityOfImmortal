package com.company;

import com.company.prop.PotionSet;
import com.company.prop.Weaponset;

public class Bag {
    Weaponset weapons=new Weaponset();
    PotionSet potions=new PotionSet();

    private static volatile Bag instance=null;

    private Bag(){}

    public static Bag getInstance(){
        if(instance==null){
            synchronized (Bag.class){
                if(instance==null){
                    instance=new Bag();
                }
            }
        }
        return instance;
    }

    public Weaponset getWeapons() {
        return weapons;
    }

    public void setWeapons(Weaponset weapons) {
        this.weapons = weapons;
    }

    public PotionSet getPotions() {
        return potions;
    }

    public void setPotions(PotionSet potions) {
        this.potions = potions;
    }
}
