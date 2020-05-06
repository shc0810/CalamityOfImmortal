package com.company;

import java.util.HashMap;

public class Place {
    private String name;
    private HashMap<String,Place> exits=new HashMap<String, Place>();

    public Place(String name)
    {
        this.name = name;
    }

    public void setExit(String dir,Place place){
        exits.put(dir,place);
    }

    @Override
    public String toString()
    {
        return name;
    }

    public String getExitDirt(){
        StringBuffer ret= new StringBuffer();
        for(String dir : exits.keySet()){
            ret.append(dir);
            ret.append(" ");
        }
        return ret.toString();
    }
    public Place getExit(String direction){
        return exits.get(direction);
    }
}
