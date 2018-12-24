package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.male.MaleFactory;

public class Solution {

    public static void main(String[] args) {
        MaleFactory mF = new MaleFactory();
        Human h1 = mF.getPerson(99);
        Human h2 = mF.getPerson(4);
        Human h3 = mF.getPerson(15);

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
    }

}
