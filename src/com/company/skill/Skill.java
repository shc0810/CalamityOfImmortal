package com.company.skill;

public class Skill {
    private int damagepoints;
    private String id;
    private String description;
    private int manaCost;
    private String occupation;
    private String attackRange;
    private int HpTreat;

    public Skill(String id,int damagepoints, int manaCost) {
        this.damagepoints = damagepoints;
        this.manaCost = manaCost;
        this.id=id;
    }

    public Skill(String id, int manaCost, String occupation, String attackRange, int hpTreat) {
        this.id = id;
        this.manaCost = manaCost;
        this.occupation = occupation;
        this.attackRange = attackRange;
        HpTreat = hpTreat;
    }

    public int getHpTreat() {
        return HpTreat;
    }

    public void setHpTreat(int hpTreat) {
        HpTreat = hpTreat;
    }


    public Skill(int damagepoints, String id, int manaCost, String occupation, String attackRange) {
        this.damagepoints = damagepoints;
        this.id = id;
        this.manaCost = manaCost;
        this.occupation = occupation;
        this.attackRange = attackRange;
    }

    public String getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(String attackRange) {
        this.attackRange = attackRange;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

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
