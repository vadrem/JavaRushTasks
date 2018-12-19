package com.javarush.task.task34.test;

import java.io.Console;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToDoubleBiFunction;

public class WaterBottle {

    private int count;

    public void WaterBottle() {
        count = 4;
    }
    public static void main(String[] args) {

        WaterBottle w = new WaterBottle();
        System.out.println(w.count);

        StringBuilder sb = new StringBuilder("test");
        System.out.println(sb);

        List<String> aList = new ArrayList<>();
        aList.add("test");
        aList.add("tes2");

        String[] s = aList.toArray(new String[1]);
        System.out.println(s.length);



    }

}