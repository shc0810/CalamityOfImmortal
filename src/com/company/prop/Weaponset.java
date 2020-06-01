package com.company.prop;

import java.util.ArrayList;

public class Weaponset {
    private ArrayList<Weapon> weapons=new ArrayList<Weapon>();

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Weaponset() {
    }

    public Weaponset(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
    public Weapon get(String id){
        Weapon weapon=null;
        for(Weapon item:weapons){
            if(true==id.equals(item.getId())){
                weapon=item;
                break;
            }
        }
        return weapon;
    }
}
