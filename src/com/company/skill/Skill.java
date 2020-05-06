package com.company.skill;

public class Skill {
    private int damagepoints;
    private String id;
    private String description;
    private int manaCost;

    public Skill(int damagepoints, String id, String description, int manaCost) {
        this.damagepoints = damagepoints;
        this.id = id;
        this.description = description;
        this.manaCost = manaCost;
    }

    public Skill() {
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getDamagepoints() {
        return damagepoints;
    }

    public void setDamagepoints(int damagepoints) {
        this.damagepoints = damagepoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
