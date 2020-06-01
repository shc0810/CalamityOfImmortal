package com.company.creature;

import com.company.Role;

public class Monster extends Creature {
    private  int experience;
    private String id;
    String currentPName;

    public String getCurrentPName() {
        return currentPName;
    }

    public void setCurrentPName(String currentPName) {
        this.currentPName = currentPName;
    }

    public void attack(){
        Role.getInstance().setHP(Role.getInstance().getHP()+this.getDamagepoints());
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Monster(int experience) {
        this.experience = experience;
    }

    public Monster(int HP, int MP, String name, int experience) {
        super(HP, MP, name);
        this.experience = experience;
    }

    public Monster() {
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
