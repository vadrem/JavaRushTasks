package com.javarush.task.task15.task1530;

/**
 * Created by vadrem on 07.03.2017.
 */
public abstract class DrinkMaker {

    abstract void getRightCup(); //выбрать подходящую чашку
    abstract void putIngredient(); //положить ингредиенты
    abstract void pour(); //залить жидкостью

    public void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
