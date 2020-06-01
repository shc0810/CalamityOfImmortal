package com.company.prop;

public class Potion {
    private int HPrecovery=0;
    private int MPrecovery=0;
    private String id;
    private int num=0;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num += num;
    }

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
