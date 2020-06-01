package com.company;

import com.company.creature.*;
import com.company.method.*;
import com.company.prop.Potion;
import com.company.prop.PotionSet;
import com.company.prop.Weapon;
import com.company.prop.Weaponset;
import com.company.skill.Skill;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Ui {
    private Place currentPlace;
    private HashMap<String,Methods> methods = new HashMap<String, Methods>();
    private Devil devil=new Devil();
    private Archmage archmage = new Archmage();
    private MonsterSet monsters=new MonsterSet();
    private PotionSet dropPotion=new PotionSet();
    private Weaponset dropWeapon=new Weaponset();
    boolean newcity=true;
    boolean newcrown=true;
    boolean newtrunk=true;

    public PotionSet getPotionDrop(){return dropPotion;}
    public Weaponset getWeponDrop(){return dropWeapon;}

    public MonsterSet getMonsters(){return monsters;}
    public String rollAttackMethod(){
        String Id="";
        int ran=rollAttacknum();
        if(ran>0 && ran<=1){
            Id="戮剑御雷";
        }
        else if(ran>1 && ran<=3){
            Id="万化十四剑";
        }
        else if(ran>3 && ran<=6){
            Id="五雷正法";
        }
        else if(ran>6 && ran<=10){
            Id="御五极神雷真法";
        }

        return Id;
    }

    public int rollAttacknum(){
        int max=10,min=1;
        int ran=(int)(Math.random()*(max-min)+min);

        return ran;
    }

    public void createCrown(Place place){
        Place immortalCrown;
        immortalCrown=new Place("不死树冠");

        immortalCrown.setExit("down",place);
        place.setExit("up",immortalCrown);

    }

    public void createTrunk(Place place){
        Place immortalTrunk;
        immortalTrunk=new Place("不死树干");

        immortalTrunk.setExit("west",place);
        place.setExit("east",immortalTrunk);

    }

    public void createCity(Place place){
        Place anCity;
        anCity=new Place("安城");


        anCity.setExit("south",place);
        place.setExit("north",anCity);
    }

    public void createNewScence(){
        int river=0,city=0,trunk=0;
        for(Monster item:monsters.getMonsters()){
            if(item.getCurrentPName().equals("安城")){
                city+=1;
            }
            else if(item.getCurrentPName().equals("通天河")){
                river+=1;
            }
            else if(item.getCurrentPName().equals("不死树干")){
                trunk+=1;
            }
        }
        if(newcity &&river==0) {
            createCity(currentPlace);
            newcity=false;
        }
        else if (newtrunk && city==0) {
            createTrunk(currentPlace);
            newtrunk=false;
        }
        else if (newcrown && trunk==0) {
            createCrown(currentPlace);
            newcrown=false;
        }
    }


    public int roll(){
        int max=100;
        int min=1;
        int ran=(int)(Math.random()*(max-min)+min);
        return ran;
    }

    public void createDropThings(){
        Potion hpPill=new Potion();
        Potion mpPill=new Potion();
        Potion immortalPill=new Potion();
        hpPill.setHPrecovery(50);
        hpPill.setNum(1);
        hpPill.setId("hppill");
        hpPill.setDescription("红丸补血丹");
        mpPill.setMPrecovery(50);
        mpPill.setNum(1);
        mpPill.setId("mppill");
        mpPill.setDescription("乌丸补气散");
        immortalPill.setNum(1);
        immortalPill.setId("immortalpill");
        this.getPotionDrop().getPotions().add(hpPill);
        this.getPotionDrop().getPotions().add(mpPill);
        this.getPotionDrop().getPotions().add(immortalPill);
        Weapon centipdeSword=new Weapon();
        centipdeSword.setOccupation("剑侠");
        centipdeSword.setId("cSword");
        centipdeSword.setDescription("净水蜈蚣刺");
        centipdeSword.setDamagepoints(-15);
        Weapon centipdeStaff=new Weapon();
        centipdeStaff.setOccupation("法师");
        centipdeStaff.setId("cStaff");
        centipdeStaff.setDescription("水蜈之杖");
        centipdeStaff.setDamagepoints(-10);
        Weapon centipdeFlail=new Weapon();
        centipdeFlail.setOccupation("牧师");
        centipdeFlail.setId("cFlail");
        centipdeFlail.setDescription("净水连枷");
        centipdeFlail.setDamagepoints(-15);
        this.getWeponDrop().getWeapons().add(centipdeFlail);
        this.getWeponDrop().getWeapons().add(centipdeStaff);
        this.getWeponDrop().getWeapons().add(centipdeSword);
    }

    public void drop(Creature creature){
        int num=roll();
        createDropThings();
        if(creature.getName().equals("净水之蜈")){
            if(num>0 &&num<=30){
                System.out.println("掉落 乌丸补气散（恢复MP50）");
                Bag.getInstance().getPotions().getPotions().add(this.getPotionDrop().get("mppill"));
            }
            else if(num>30 &&num<=60){
                System.out.println("掉落 红丸补血丹（恢复HP50）");
                Bag.getInstance().getPotions().getPotions().add(this.getPotionDrop().get("hppill"));
            }
            else if(num>60 && num<=65){
                System.out.println("掉落 净水蜈蚣刺");
                Bag.getInstance().getWeapons().getWeapons().add(this.getWeponDrop().get("cSword"));
            }
            else if(num>65 && num<=70){
                System.out.println("掉落 水蜈之杖");
                Bag.getInstance().getWeapons().getWeapons().add(this.getWeponDrop().get("cStaff"));
            }
            else if(num>70 && num<=75){
                System.out.println("掉落 净水连枷");
                Bag.getInstance().getWeapons().getWeapons().add(this.getWeponDrop().get("cFlail"));
            }
            else{
                System.out.println("掉落，无");
            }
        }
        else {
            if(num==1 || num==100){
                System.out.println("掉落 不死药");
                Bag.getInstance().getPotions().getPotions().add(this.getPotionDrop().get("immortalpill"));
            }
        }

    }

    public void upgrade(){
        if(Level.getInstance().getLevel()>Level.getInstance().getBeforeLevel()){
            int difference=Level.getInstance().getLevel()-Level.getInstance().getBeforeLevel();
            Role.getInstance().setHPmax(Role.getInstance().getHPmax()+Role.getInstance().getHPadd()*difference);
            Role.getInstance().setHP(Role.getInstance().getHPmax());
            Role.getInstance().setMPmax(Role.getInstance().getMPmax()+Role.getInstance().getMPadd()*difference);
            Role.getInstance().setMP(Role.getInstance().getMPmax());
            Level.getInstance().setBeforeLevel(Level.getInstance().getLevel());
        }
    }


    public void getSuperWeapon(){
        if(currentPlace.isHasSuperWeapon() && Level.getInstance().getLevel()>=15){
            System.out.println("神兵‘灭度之刃’出现在了你的面前，神兵择主，似乎你就是它所选择的兵主！");
            Weapon sp=new Weapon();
            sp.setDamagepoints(-75);
            sp.setDescription("灭度之刃");
            sp.setId("divineTroops");
            sp.setOccupation("全职业");
            Bag.getInstance().getWeapons().getWeapons().add(sp);
            currentPlace.setHasSuperWeapon(false);
        }
    }

    public void attack(String enemyId){
            Role.getInstance().attack(this.getMonsters().get(enemyId));
            monsters.get(enemyId).attack();
            monsterDie(enemyId);
    }

    public void monsterDie(String enemyId){
        if(monsters.get(enemyId).getHP()<=0){
            drop(monsters.get(enemyId));
            Level.getInstance().addExperience(monsters.get(enemyId).getExperience());
            System.out.println("敌将 "+monsters.get(enemyId).getId()+" 已被讨伐！");
            Iterator<Monster> iterator=monsters.getMonsters().iterator();
            while(iterator.hasNext()){
                Monster it=iterator.next();
                if(it.getId().equals(enemyId)){
                    iterator.remove();
                }
            }
        }

    }

    public void MonsterDisplay(Place place){
        int numbers=0;
        System.out.println("这里的怪物有:");
        for(Monster item:monsters.getMonsters()){
            if(item.getCurrentPName().equals(currentPlace.getName())){
                System.out.println(item.getName()+" id:"+item.getId()+" HP:"+item.getHP());
                numbers+=1;
            }
        }
        if(numbers==0){
            System.out.println("此地无怪物出没");
        }
    }



    public Ui(){
        methods.put("go",new MethodGo(this));
        methods.put("attack",new MethodAttack(this));
        methods.put("exit",new MethodExit(this));
        methods.put("chat",new MethodChat(this));
        methods.put("use",new MethodUse(this));
        methods.put("change",new MethodChange(this));
        methods.put("check",new MethodCheck(this));
        methods.put("skill",new MethodSkill(this));
        createPlace();
    }

    public void printHelp(){
        System.out.println("可用指令 change，attack，go，use,exit,skill");
        System.out.println("go: 例如 go east");
        System.out.println("attack: attack  敌人id");
        System.out.println("use（释放技能）: use 技能");
        System.out.println("change weaponid 改变当前武器");
        System.out.println("skill 技能Id 释放技能");
        System.out.println("exit 退出");

    }

    public void printBag(){
        System.out.println("武器：");
        for(Weapon item:Bag.getInstance().getWeapons().getWeapons()){
            System.out.println("名字:"+item.getDescription()+" 职业需求:"+item.getOccupation()+" Id:"+item.getId()+" 伤害数值:"+item.getDamagepoints());
        }
        System.out.println("药品:");
        if(Bag.getInstance().getPotions().getPotions().size()!=0)
            for(Potion item:Bag.getInstance().getPotions().getPotions())
                System.out.println(item.getDescription()+" Id:"+item.getId()+" num:"+item.getNum());
        else{
            System.out.println("暂无药品");
        }

    }

    public void printSkill(){
        for(Skill item:Role.getInstance().getSkills().getSkills()){
            if(item.getOccupation().equals(Role.getInstance().getOccupation())) {
                if (!item.getAttackRange().equals("treatment")) {
                    System.out.println("Id:" + item.getId() + " occupation:" + item.getOccupation() + " manacost:" + item.getManaCost() + " damage:" + item.getDamagepoints() + " attackRange:" + item.getAttackRange());
                }
                else {
                    System.out.println("Id:" + item.getId() + " occupation:" + item.getOccupation() + " manacost:" + item.getManaCost() + " hpTreat:" + item.getHpTreat());
                }
            }
        }
    }

    public void goPlace(String direction){
        Place nextPlace =currentPlace.getExit(direction);

        if(nextPlace==null){
            System.out.println("那里不能前进！");
        }
        else{
            currentPlace=nextPlace;
        }
    }

    public void printExit(){
        System.out.println("你现在在："+currentPlace);
        System.out.println("你可以去的地方有：");
        System.out.println(currentPlace.getExitDirt());
    }

    public void Scenario_1(){
        System.out.println("异人" + Role.getInstance().getName() + "突然出现在了此处，自称为昆仑之人。" +
                "他就此开始了一段荡气回肠，可歌可泣的传奇旅途。\n");
    }

    public void roleCondition(){
        System.out.println("-------角-色-状-态-----------------");
        System.out.println("name:"+Role.getInstance().getName());
        System.out.println("level:"+Level.getInstance().getLevel());
        System.out.println("HP:"+Role.getInstance().getHP());
        System.out.println("MP"+Role.getInstance().getMP());
        System.out.println("damagepoints:"+(Role.getInstance().getDamagepoints()+Role.getInstance().getCurrentWeapon().getDamagepoints()));
    }

    public void createPlace(){
        Place tongytianRiver,ImpregnablePass,nanjiangCity,taibaiVolcano;


        tongytianRiver=new Place("通天河");
        ImpregnablePass=new Place("通天河天关");
        nanjiangCity=new Place("南江城");
        taibaiVolcano=new Place("太白火山");

        taibaiVolcano.setHasSuperWeapon(true);

        tongytianRiver.setExit("south",ImpregnablePass);
        ImpregnablePass.setExit("north",tongytianRiver);
        ImpregnablePass.setExit("south",nanjiangCity);
        nanjiangCity.setExit("north",ImpregnablePass);
        nanjiangCity.setExit("west",taibaiVolcano);
        taibaiVolcano.setExit("east",nanjiangCity);
        currentPlace=nanjiangCity;

    }

    public void bossSkillAttackPerRound(){
        String method=rollAttackMethod();
        System.out.println("国师对你使出了 "+method);
        for(Skill item:archmage.getSkills().getSkills()){
            if(method.equals(item.getId())){
                Role.getInstance().setHP(Role.getInstance().getHP()+item.getDamagepoints());
            }
        }

    }

    public void game(){
        System.out.println("请输入你的名字：");
        Scanner input = new Scanner(System.in);
        String name=input.nextLine();
        Role.getInstance().setName(name);
        System.out.println("少侠请开始你的传奇！\n\n");
        Scenario_1();

        while(true){
            createNewScence();
            upgrade();
            roleCondition();
            printExit();
            MonsterDisplay(currentPlace);
            getSuperWeapon();
            String sentence=input.nextLine();
            String[] words=sentence.split(" ");
            String value="";
            Methods way=methods.get(words[0]);
            if(sentence.length()>1)
                value=words[1];
            if(words[0].equals("help")){
                printHelp();
            }
            if(way!=null) {
                way.doCmd(value);
                if(way.isExit()){
                    break;
                }
            }
            if(currentPlace.getName().equals("不死树冠"))
                bossSkillAttackPerRound();
            if(Role.getInstance().getHP()<=0){
                System.out.println("异人“"+Role.getInstance().getName()+"”的传奇戛然而止，魔潮的来临并未阻挡，未来又在何方呢！");
                break;
            }
        }

    }

    public void createRole(String line){
        if (line.equals("1")){
            Role.getInstance().setOccupation("剑侠");
            Role.getInstance().setHP(75);
            Role.getInstance().setHPmax(75);
            Role.getInstance().setMP(200);
            Role.getInstance().setMPmax(200);
            Role.getInstance().setHPadd(25);
            Role.getInstance().setMPadd(100);
            Role.getInstance().setDamagepoints(-75);
            Weapon intialWeapon=new Weapon();
            intialWeapon.setId("iW");
            intialWeapon.setDescription("木剑");
            intialWeapon.setDamagepoints(-5);
            intialWeapon.setOccupation("剑侠");
            Role.getInstance().setCurrentWeapon(intialWeapon);
            Bag.getInstance().getWeapons().getWeapons().add(intialWeapon);
        }
        else if(line.equals("2")){
            Role.getInstance().setOccupation("牧师");
            Role.getInstance().setHP(200);
            Role.getInstance().setHPmax(200);
            Role.getInstance().setMP(100);
            Role.getInstance().setMPmax(100);
            Role.getInstance().setHPadd(75);
            Role.getInstance().setMPadd(50);
            Role.getInstance().setDamagepoints(-30);
            Weapon intialWeapon=new Weapon();
            intialWeapon.setId("iW");
            intialWeapon.setDescription("木连枷");
            intialWeapon.setDamagepoints(-5);
            intialWeapon.setOccupation("牧师");
            Role.getInstance().setCurrentWeapon(intialWeapon);
            Bag.getInstance().getWeapons().getWeapons().add(intialWeapon);
        }
        else if(line.equals("3")){
            Role.getInstance().setOccupation("法师");
            Role.getInstance().setHP(100);
            Role.getInstance().setHPmax(100);
            Role.getInstance().setMP(200);
            Role.getInstance().setMPmax(200);
            Role.getInstance().setHPadd(30);
            Role.getInstance().setMPadd(70);
            Role.getInstance().setDamagepoints(-30);
            Weapon intialWeapon=new Weapon();
            intialWeapon.setId("iW");
            intialWeapon.setDescription("木杖");
            intialWeapon.setDamagepoints(-5);
            intialWeapon.setOccupation("法师");
            Role.getInstance().setCurrentWeapon(intialWeapon);
            Bag.getInstance().getWeapons().getWeapons().add(intialWeapon);
        }
        else{
            System.out.println("无此选项，请重新选择：");
            Scanner it = new Scanner(System.in);
            String choose=it.nextLine();
            createRole(choose);
        }

    }

    public void openingI() {
        System.out.println("【从古自今，人类都在追求长生，意欲超脱宿命的轮回。】");
        System.out.println("【从高高在上的帝皇，到碌碌无为的流浪汉。无论是谁都在渴求，并从古老的典籍，山野的传说，莫测的预言和祭祀的结果中寻找得到它的方法。】");
        System.out.println("【传闻，建木耸灵丘之上，蟠桃生巨海之侧，神木有果，服之不死。】");
        System.out.println("【时光如梭，沧海桑田。】");
        System.out.println("【唯人心‘不易’。】");
        System.out.println("【终有一日，神木既成，不死已至。】");
        System.out.println("【但灾祸与动乱的时代，也随之而来。】");
        System.out.println("【安朝永宁十九年，厉王暴虐无道，率兽食人！百家举义，天下皆反】");
        System.out.println("【谁人能安乱世？】");
        System.out.println("【不死之劫】\n");
        System.out.println("请选择你的角色：");
        System.out.println("1.剑侠  HP:75 MP:200 Damage:75");
        System.out.println("2.牧师  HP:200 MP:100 Damage:30");
        System.out.println("3.法师  HP:100 MP:100 Damage:30");

    }

    public int rollnum(){
        int max=10;
        int min=5;
        int ran=(int)(Math.random()*(max-min)+min);
        return ran;
    }

    public void createMonster(){
        archmage.setId("archmage");
        archmage.setName("国师");
        archmage.setExperience(20000);
        archmage.setHP(2000);
        archmage.setMP(500000);
        archmage.setDamagepoints(-50);
        archmage.setCurrentPName("不死树冠");
        monsters.getMonsters().add(archmage);
        devil.setId("devil");
        devil.setName("安桀帝");
        devil.setExperience(10000);
        devil.setHP(5000);
        devil.setMP(5000);
        devil.setDamagepoints(-30);
        devil.setCurrentPName("不死树干");
        monsters.getMonsters().add(devil);
        Evilgeneral red=new Evilgeneral();
        Evilgeneral green=new Evilgeneral();
        Evilgeneral purple=new Evilgeneral();
        Evilgeneral blue=new Evilgeneral();
        red.setId("red");
        red.setName("魔礼红");
        red.setExperience(500);
        red.setHP(400);
        red.setMP(2000);
        red.setCurrentPName("安城");
        red.setDamagepoints(-10);
        green.setId("green");
        green.setName("魔礼青");
        green.setExperience(500);
        green.setHP(500);
        green.setMP(1000);
        green.setCurrentPName("安城");
        green.setDamagepoints(-10);
        purple.setId("purple");
        purple.setName("魔礼紫");
        purple.setExperience(500);
        purple.setHP(2000);
        purple.setMP(1000);
        purple.setCurrentPName("安城");
        purple.setDamagepoints(-10);
        blue.setId("blue");
        blue.setName("魔礼蓝");
        blue.setExperience(500);
        blue.setHP(500);
        blue.setMP(500);
        blue.setCurrentPName("安城");
        blue.setDamagepoints(-10);
        monsters.getMonsters().add(blue);
        monsters.getMonsters().add(purple);
        monsters.getMonsters().add(red);
        monsters.getMonsters().add(green);
        for(int i=1;i<rollnum();i++){
            Evilsoilder soilder=new Evilsoilder();
            soilder.setId("soilder"+i);
            soilder.setName("魔兵");
            soilder.setExperience(20);
            soilder.setHP(200);
            soilder.setMP(50);
            soilder.setCurrentPName("安城");
            soilder.setDamagepoints(-3);
            monsters.getMonsters().add(soilder);
        }
        for(int i=1;i<rollnum();i++){
            Centipede centipede=new Centipede();
            centipede.setId("centipde"+i);
            centipede.setName("净水之蜈");
            centipede.setExperience(20);
            centipede.setHP(150);
            centipede.setMP(0);
            centipede.setCurrentPName("通天河");
            centipede.setDamagepoints(-5);
            monsters.getMonsters().add(centipede);
        }
    }

    public void change(String word){
        boolean exist=true;
        for(Weapon item:Bag.getInstance().getWeapons().getWeapons()){
            if (item.getId().equals(word)){
                if(Role.getInstance().getOccupation().equals(item.getOccupation())) {
                    Role.getInstance().setCurrentWeapon(item);
                }
                else if(item.getOccupation().equals("全职业")){
                    Role.getInstance().setCurrentWeapon(item);
                }
                else{
                    System.out.println("职业不符");
                }
                exist=false;
                break;
            }
        }
        if (exist){
            System.out.println("无此武器");
        }
    }


    public void usePotion(String word){
        boolean exist=true;
        for(Potion item:Bag.getInstance().getPotions().getPotions()){
            if(item.getId().equals(word)){
                if(item.getHPrecovery()+Role.getInstance().getHP()>Role.getInstance().getHPmax())
                    Role.getInstance().setHP(Role.getInstance().getHPmax());
                else
                    Role.getInstance().setHP(Role.getInstance().getHP() + item.getHPrecovery());
                if(item.getMPrecovery()+Role.getInstance().getMP()>Role.getInstance().getMPmax())
                    Role.getInstance().setMP(Role.getInstance().getMPmax());
                else
                    Role.getInstance().setMP(Role.getInstance().getMP() + item.getMPrecovery());
                exist=false;
                break;
            }
        }
        Iterator<Potion> iterator=Bag.getInstance().getPotions().getPotions().iterator();
        while(iterator.hasNext()){
            Potion it=iterator.next();
            if(it.getId().equals(word)){
                iterator.remove();
                break;
            }
        }
        if(exist){
            System.out.println("无此药品");
        }
    }

    public void useSkill(String word){
        boolean exist=false;
        for(Skill item:Role.getInstance().getSkills().getSkills()){
            if(word.equals(item.getId())){
                if(Role.getInstance().getOccupation().equals(item.getOccupation())) {
                    if (Role.getInstance().getMP() + item.getManaCost() >= 0) {
                        System.out.println("你使出了"+item.getId());
                        Role.getInstance().setMP(Role.getInstance().getMP() + item.getManaCost());
                        if ("groupAttack".equals(item.getAttackRange())) {
                            for (Monster object : monsters.getMonsters()) {
                                if (currentPlace.getName().equals(object.getCurrentPName())) {
                                    object.setHP(object.getHP() + item.getDamagepoints());
                                }
                            }
                            for (int i = 0; i < monsters.getMonsters().size(); i++) {
                                for (Monster nObject : monsters.getMonsters()) {
                                    if (nObject.getHP() <= 0) {
                                        monsterDie(nObject.getId());
                                        break;
                                    }
                                }
                            }
                        } else if ("singleAttack".equals(item.getAttackRange())) {
                            System.out.println("输入敌人ID");
                            Scanner id = new Scanner(System.in);
                            String enemyId = id.nextLine();
                            for (Monster object : monsters.getMonsters()) {
                                if (enemyId.equals(object.getId())) {
                                    object.setHP(object.getHP() + item.getDamagepoints());
                                    if(object.getHP()>0){
                                        Role.getInstance().setHP(Role.getInstance().getHP()+object.getDamagepoints());
                                    }
                                }
                            }
                            for (int i = 0; i < monsters.getMonsters().size(); i++) {
                                for (Monster nObject : monsters.getMonsters()) {
                                    if (nObject.getHP() <= 0) {
                                        monsterDie(nObject.getId());
                                        break;
                                    }
                                }
                            }
                        } else if ("treatment".equals(item.getAttackRange())) {
                            if (item.getHpTreat() + Role.getInstance().getHP() > Role.getInstance().getHPmax()) {
                                Role.getInstance().setHP(Role.getInstance().getHPmax());
                            } else {
                                Role.getInstance().setHP(item.getHpTreat() + Role.getInstance().getHP());
                            }
                        }

                    }
                    else{
                        System.out.println("法力值不足,无法释放!");
                    }
                }
                else {
                    exist = true;
                }
            }
            else{
                exist=true;
            }
        }
        if(!exist){
            System.out.println("此技能不存在!");
        }

    }

    public void createSkill(){
        Skill skill1=new Skill(-100,"天倾",-200,"剑侠","groupAttack");
        Skill skill2=new Skill(-300,"剑极",-20,"剑侠","singleAttack");
        Skill skill3=new Skill("低级治疗术",-20,"牧师","treatment",100);
        Skill skill4=new Skill("高级治疗术",-80,"牧师","treatment",200);
        Skill skill5=new Skill(-80,"神说，要有光！",-100,"牧师","groupAttack");
        Skill skill6=new Skill("治愈灵符",-30,"法师","treatment",100);
        Skill skill7=new Skill(-100,"灵符",-5,"法师","singleAttack");
        Skill skill8=new Skill(-150,"流星火雨",-150,"法师","groupAttack");
        Role.getInstance().getSkills().getSkills().add(skill1);
        Role.getInstance().getSkills().getSkills().add(skill2);
        Role.getInstance().getSkills().getSkills().add(skill3);
        Role.getInstance().getSkills().getSkills().add(skill4);
        Role.getInstance().getSkills().getSkills().add(skill5);
        Role.getInstance().getSkills().getSkills().add(skill6);
        Role.getInstance().getSkills().getSkills().add(skill7);
        Role.getInstance().getSkills().getSkills().add(skill8);
        Skill skill9=new Skill("御五极神雷真法",-100,-50);
        Skill skill10=new Skill("五雷正法",-200,-50);
        Skill skill11=new Skill("万化十四剑",-300,-100);
        Skill skill12=new Skill("戮剑御雷",-400,-100);
        archmage.getSkills().getSkills().add(skill9);
        archmage.getSkills().getSkills().add(skill10);
        archmage.getSkills().getSkills().add(skill11);
        archmage.getSkills().getSkills().add(skill12);
    }

    public void play() {
        createMonster();
        createSkill();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        createRole(line);
        game();
        in.close();
    }

}
