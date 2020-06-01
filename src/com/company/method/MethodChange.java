package com.company.method;

import com.company.Methods;
import com.company.Ui;

public class MethodChange extends Methods {
    public MethodChange(Ui ui){
        super(ui);
    }
    public void doCmd(String word){
        ui.change(word);
    }
}
