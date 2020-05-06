package com.company.creature;

import java.util.ArrayList;

public class CentipedeSet {
    private ArrayList<Centipede> centipedes=new ArrayList<Centipede>();

    public CentipedeSet() {
    }

    public CentipedeSet(ArrayList<Centipede> centipedes) {
        this.centipedes = centipedes;
    }

    public ArrayList<Centipede> getCentipedes() {
        return centipedes;
    }

    public void setCentipedes(ArrayList<Centipede> centipedes) {
        this.centipedes = centipedes;
    }
}
