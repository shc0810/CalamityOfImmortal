package com.company.creature;

import java.util.ArrayList;

public class EvilgeneralSet {
    private ArrayList<Evilgeneral> evilgenerals = new ArrayList<Evilgeneral>();

    public EvilgeneralSet() {
    }

    public EvilgeneralSet(ArrayList<Evilgeneral> evilgenerals) {
        this.evilgenerals = evilgenerals;
    }

    public ArrayList<Evilgeneral> getEvilgenerals() {
        return evilgenerals;
    }

    public void setEvilgenerals(ArrayList<Evilgeneral> evilgenerals) {
        this.evilgenerals = evilgenerals;
    }
}
