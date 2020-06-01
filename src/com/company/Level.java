package com.company;

public class Level {
    private static volatile Level instance=null;
    public int level=1;
    public int experience=0;
    private int beforeLevel=1;

    public int getBeforeLevel() {
        return beforeLevel;
    }

    public void setBeforeLevel(int beforeLevel) {
        this.beforeLevel = beforeLevel;
    }

    private Level(){}

    public  static Level getInstance(){
        if(instance==null){
            synchronized (Level.class){
                if(instance==null){
                    instance=new Level();
                }
            }
        }
        return instance;
    }

    public void addExperience(int exp){
        this.experience+=exp;
        this.setLevel(this.getExperience());
    }

    public int getExperience(){return experience;}

    public int getLevel(){
        return level;
    }

    public void setLevel(int exp){
        this.level=1+exp/100;
    }

}
