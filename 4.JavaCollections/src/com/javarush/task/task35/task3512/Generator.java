package com.javarush.task.task35.task3512;

public class Generator<T> {

    public Class<T> tClass;

    public Generator(Class<T> tClass){
        this.tClass  = tClass;
    }

    T newInstance() throws InstantiationException, IllegalAccessException {
        return this.tClass.newInstance();
    }
}
