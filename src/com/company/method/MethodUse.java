package com.company.method;

import com.company.Methods;
import com.company.Ui;

public class MethodUse extends Methods {
    public MethodUse(Ui ui){
        super(ui);
    }

    public void doCmd(String word){
        ui.usePotion(word);
    }
}
