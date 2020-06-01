package com.company.prop;

public class Weapon {
    private int damagepoints;
    private String id;
    private String description;
    private  String occupation;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Weapon() {
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

    public Weapon(int damagepoints, String id) {
        this.damagepoints = damagepoints;
        this.id = id;
    }

    public Weapon(int damagepoints, String id, String description) {
        this.damagepoints = damagepoints;
        this.id = id;
        this.description = description;
    }
}
