package com.company.creature;

import java.util.ArrayList;

public class MonsterSet {
    private ArrayList<Monster> monsters=new ArrayList<Monster>();

    public MonsterSet() {
    }
    public Monster get(String id){
        Monster monster=null;
        for (Monster item: monsters){
            if(true==id.equals(item.getId())){
                monster=item;
                break;
            }
        }
        return monster;
    }

    public MonsterSet(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }
}
