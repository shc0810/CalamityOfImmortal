package com.company.method;

import com.company.Methods;
import com.company.Ui;

public class MethodSkill extends Methods {
    public MethodSkill(Ui ui) {
        super(ui);
    }

    public void doCmd(String word){
        ui.useSkill(word);
    }
}
