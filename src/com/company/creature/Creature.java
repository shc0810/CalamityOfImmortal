package com.company.creature;

import com.company.prop.Weapon;

public abstract class Creature {
    private int HP;
    Weapon currentWeapon=new Weapon();
    private int MP;
    private String name;
    private int HPadd;
    private int MPadd;
    private int damagepoints;
    private int wepondamagepoints;

    public int getWepondamagepoints() {
        return wepondamagepoints;
    }

    public void setWepondamagepoints(int wepondamagepoints) {
        this.wepondamagepoints = wepondamagepoints;
    }

    public void attack(Creature role, Creature enemy){
        enemy.setHP(enemy.getHP()+role.getDamagepoints()+role.getWepondamagepoints());
    }

    public int getDamagepoints() {
        return damagepoints;
    }

    public void setDamagepoints(int damagepoints) {
        this.damagepoints = damagepoints;
    }


    public void setHPadd(int HPadd) {
        this.HPadd = HPadd;
    }

    public void setMPadd(int MPadd) {
        this.MPadd = MPadd;
    }


    public int getHPadd() {
        return HPadd;
    }

    public int getMPadd() {
        return MPadd;
    }

    public Creature() {
    }

    public Creature(int HP, int MP, int HPadd, int MPadd, int damagepoints) {
        this.HP = HP;
        this.MP = MP;
        this.HPadd = HPadd;
        this.MPadd = MPadd;
        this.damagepoints = damagepoints;
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
