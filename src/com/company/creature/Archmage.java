package com.company.creature;

import com.company.skill.SkillSet;

public class Archmage extends Monster {
    //初始设定集
//    Skill skill1=new Skill(150,"戮剑御雷","以气御剑，剑随心意.",200);
//    Skill skill2=new Skill(400,"五雷正法","东三南二北一西四，此大数之祖而中央五焉。",500);
//    Skill skill3=new Skill(600,"御五极神雷真法","以气御剑，剑随心意.",1000);
//    Skill skill4=new Skill(1000,"万化十四剑","以气御剑，剑随心意.",10000);
    SkillSet skills=new SkillSet();

    public SkillSet getSkills() {
        return skills;
    }

    public void setSkills(SkillSet skills) {
        this.skills = skills;
    }
}
