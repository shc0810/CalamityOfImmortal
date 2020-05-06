package com.company;

import com.company.creature.*;
import com.company.method.*;

import java.util.HashMap;
import java.util.Scanner;

public class Ui {
    public Place currentPlace;
    private HashMap<String,Methods> methods = new HashMap<String, Methods>();


    public void Ui(){
        createPlace();
        methods.put("go",new MethodGo());
        methods.put("attack",new MerhodAttack());
        methods.put("exit",new MerhodExit());
        methods.put("chat",new MethodChat());
        methods.put("use",new MerhodUse());
        methods.put("change",new MerhodChange());
    }

    public void Scenario_1(Person person){
        System.out.println("异人" + person.getName() + "突然出现在了此处，自称为昆仑之人。" +
                "他就此开始了一段荡气回肠，可歌可泣的传奇旅途。\n");
    }

    public void createPlace(){
        Place tongytianRiver,ImpregnablePass,nanjiangCity,anCity,immortalTrunk,immortalCrown,taibaiVolcano;

        tongytianRiver=new Place("通天河");
        ImpregnablePass=new Place("通天河天关");
        nanjiangCity=new Place("南江城");
        anCity=new Place("安城");
        immortalCrown=new Place("不死树冠");
        immortalTrunk=new Place("不死树干");
        taibaiVolcano=new Place("太白火山");

        tongytianRiver.setExit("north",anCity);
        tongytianRiver.setExit("south",ImpregnablePass);
        ImpregnablePass.setExit("north",tongytianRiver);
        ImpregnablePass.setExit("south",nanjiangCity);
        nanjiangCity.setExit("north",ImpregnablePass);
        nanjiangCity.setExit("west",taibaiVolcano);
        taibaiVolcano.setExit("east",nanjiangCity);
        anCity.setExit("east",immortalTrunk);
        immortalTrunk.setExit("west",anCity);
        immortalCrown.setExit("down",immortalTrunk);
        immortalTrunk.setExit("up",immortalCrown);
        currentPlace=nanjiangCity;

    }


    public void openingI() {
        System.out.println("【从古自今，人类都在追求长生，意欲超脱宿命的轮回。】\n");
        System.out.println("【从高高在上的帝皇，到碌碌无为的流浪汉。无论是谁都在渴求，并从古老的典籍，山野的传说，莫测的预言和祭祀的结果中寻找得到它的方法。】\n");
        System.out.println("【传闻，建木耸灵丘之上，蟠桃生巨海之侧，神木有果，服之不死。】\n");
        System.out.println("【时光如梭，沧海桑田。】\n");
        System.out.println("【唯人心‘不易’。】\n");
        System.out.println("【终有一日，神木既成，不死已至。】\n");
        System.out.println("【但灾祸与动乱的时代，也随之而来。】\n");
        System.out.println("【安朝永宁十九年，厉王暴虐无道，率兽食人！百家举义，天下皆反】\n");
        System.out.println("【谁人能安乱世？】\n");
        System.out.println("【不死之劫】\n\n");
        System.out.println("请选择你的角色：\n");
        System.out.println("1.剑侠 2.牧师 3.法师\n");

    }

    public void createMonster(){
        Archmage archmage = new Archmage();
        archmage.setExperience(20000);
        archmage.setHP(2000);
        archmage.setMP(500000);
        archmage.setName("国师");
        Devil devil=new Devil();
        devil.setExperience(10000);
        devil.setHP(5000);
        devil.setMP(5000);
        devil.setName("安桀帝");
        Evilgeneral red=new Evilgeneral();
        

    }
    public void play() {

        openingI();
        createMonster();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if (line.equals("1")){
            Chivalrous_swordsman role =new Chivalrous_swordsman();
            System.out.println("请输入你的名字：");
            Scanner input = new Scanner(System.in);
            String name=input.nextLine();
            role.setName(name);
            System.out.println("少侠请开始你的传奇！");

            while(true){
                String sentence=input.nextLine();
                String[] words=sentence.split(" ");
                String value="";
                Methods way=methods.get(words[0]);
                if(sentence.length()>1)
                    value=words[1];
                if(way!=null)
                    way.doCmd(value);
            }
        }
        if(line.equals("2")){
            Minister role =new Minister();
            System.out.println("请输入你的名字：");
            Scanner input = new Scanner(System.in);
            String name=input.nextLine();
            role.setName(name);
            System.out.println("少侠请开始你的传奇！");

            while(true){
                String sentence=input.nextLine();
                String[] words=sentence.split(" ");
                String value="";
                Methods way=methods.get(words[0]);
                if(sentence.length()>1)
                    value=words[1];
                if(way!=null)
                    way.doCmd(value);
            }
        }
        if(line.equals("3")){
            Master role =new Master();
            System.out.println("请输入你的名字：");
            Scanner input = new Scanner(System.in);
            String name=input.nextLine();
            role.setName(name);
            System.out.println("少侠请开始你的传奇！");

            while(true){
                String sentence=input.nextLine();
                String[] words=sentence.split(" ");
                String value="";
                Methods way=methods.get(words[0]);
                if(sentence.length()>1)
                    value=words[1];
                if(way!=null)
                    way.doCmd(value);
            }
        }


    }
}
