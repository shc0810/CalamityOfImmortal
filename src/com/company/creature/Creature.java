package com.company.creature;

public class Creature {
    private int HP;
    private int MP;
    private String name;
    private int level;
    private int HPadd;
    private int MPadd;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHPadd(int HPadd) {
        this.HPadd = HPadd;
    }

    public void setMPadd(int MPadd) {
        this.MPadd = MPadd;
    }

    public int getLevel() {
        return level;
    }

    public int getHPadd() {
        return HPadd;
    }

    public int getMPadd() {
        return MPadd;
    }

    public Creature() {
    }

    public Creature(int HP, int MP, String name) {
        this.HP = HP;
        this.MP = MP;
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public int getMP() {
        return MP;
    }

    public String getName() {
        return name;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public void setName(String name) {
        this.name = name;
    }
}
