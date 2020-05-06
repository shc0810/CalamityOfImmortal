package com.company.skill;

import java.util.ArrayList;

public class SkillSet {
    private ArrayList<Skill> skills = new ArrayList<Skill>();

    public SkillSet() {
    }

    public SkillSet(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
}
