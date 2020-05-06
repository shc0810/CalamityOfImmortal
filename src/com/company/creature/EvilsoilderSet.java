package com.company.creature;

import java.util.ArrayList;

public class EvilsoilderSet {
    private ArrayList<Evilsoilder> evilsoilder=new ArrayList<Evilsoilder>();

    public EvilsoilderSet() {
    }

    public EvilsoilderSet(ArrayList<Evilsoilder> evilsoilder) {
        this.evilsoilder = evilsoilder;
    }

    public ArrayList<Evilsoilder> getEvilsoilder() {
        return evilsoilder;
    }

    public void setEvilsoilder(ArrayList<Evilsoilder> evilsoilder) {
        this.evilsoilder = evilsoilder;
    }
}
