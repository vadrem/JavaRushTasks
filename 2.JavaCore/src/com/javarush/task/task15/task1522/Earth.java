package com.javarush.task.task15.task1522;

/**
 * Created by vadrem on 06.03.2017.
 */
public class Earth implements Planet {
    private static Earth instance;

    private Earth() {
    }

    public static synchronized  Earth getInstance() {
        if( instance==null ){
            instance = new Earth();
        }
        return instance;
    }
}
