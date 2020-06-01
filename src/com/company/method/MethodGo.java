package com.company.method;

import com.company.Methods;
import com.company.Ui;

public class MethodGo extends Methods {
    public  MethodGo(Ui ui){
        super(ui);
    }
    public void doCmd(String word){ui.goPlace(word);}
}
