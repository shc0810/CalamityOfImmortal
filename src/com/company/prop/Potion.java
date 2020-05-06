package com.company.prop;

public class Potion {
    private int HPrecovery;
    private int MPrecovery;
    private String id;

    public int getHPrecovery() {
        return HPrecovery;
    }

    public void setHPrecovery(int HPrecovery) {
        this.HPrecovery = HPrecovery;
    }

    public int getMPrecovery() {
        return MPrecovery;
    }

    public void setMPrecovery(int MPrecovery) {
        this.MPrecovery = MPrecovery;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Potion() {
    }

    public Potion(int HPrecovery, int MPrecovery, String id) {
        this.HPrecovery = HPrecovery;
        this.MPrecovery = MPrecovery;
        this.id = id;
    }
}
