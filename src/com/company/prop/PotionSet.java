package com.company.prop;

import java.util.ArrayList;

public class PotionSet {
    private ArrayList<Potion> potions=new ArrayList<Potion>();

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public PotionSet(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public PotionSet() {
    }
    public Potion get(String id){
        Potion potion=null;
        for(Potion item:potions){
            if(true==id.equals(item.getId())){
                potion=item;
                break;
            }
        }
        return potion;
    }
}
