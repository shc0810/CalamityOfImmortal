package com.company.method;

import com.company.Methods;
import com.company.Ui;

public class MethodCheck extends Methods {

    public MethodCheck(Ui ui) {
        super(ui);
    }

    public void doCmd(String word){
        if(word.equals("bag")){
            ui.printBag();
        }
        else if(word.equals("role")){
            ui.roleCondition();
        }
        else if(word.equals("skill")){
            ui.printSkill();
        }
        else{
            System.out.println("未命名命令，无法有效执行");
        }
    }
}
