package com.company.method;

import com.company.Methods;
import com.company.Ui;

public class MethodAttack extends Methods {

    public MethodAttack(Ui ui){
        super(ui);
    }

    public void doCmd(String word){
        ui.attack(word);
    }

}
