package com.company.creature;

public class Monster extends Creature {
    private  int experience;

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
