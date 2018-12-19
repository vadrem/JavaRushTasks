package com.javarush.task.task34.task3411;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRE {

    public  static void main(String[] args){

        TestRE testre = new TestRE();
        testre.regEx("sin(п1.1)");
        testre.regEx("coos(g1.1)");
        testre.regEx("(tan(1.1 + 50)");
        testre.regEx("sin(45^56)");
        testre.regEx("cos(45/5)");
        testre.regEx("tan(45*56)");
        testre.regEx("sin(-1.1)))");
        testre.regEx("+cos(-1.1)----");
        testre.regEx("+tan(-1.1)---");
        testre.regEx("-sin(-45)---");
        testre.regEx("^cos(-45)---");
        testre.regEx("/tan(-45)---");

    }

    public void regEx(String s){

        Pattern p = Pattern.compile("(sin|cos|tan)\\(-?\\d+(?:\\.\\d+)?\\)");
        Matcher m = p.matcher(s);

        if(m.find()){

            System.out.println(m.group()+" " +m.start()+" "+m.end());

        }

    }

}
