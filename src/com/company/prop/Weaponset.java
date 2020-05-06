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
}
