package com.javarush.task.task08.task0818;

import java.util.*;


/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> nMap = new HashMap<String, Integer>();
        nMap.put("Kolya", 400);
        nMap.put("Petya", 500);
        nMap.put("Vasya", 600);
        nMap.put("Olya", 700);
        nMap.put("Vadim", 300);
        nMap.put("Olesya", 1000);
        nMap.put("Alesha", 200);
        nMap.put("Dima", 100);
        nMap.put("Sergey", 1500);
        nMap.put("Vanya", 499);

        return nMap;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> nMap = new HashMap<String, Integer>();

        Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            nMap.put(entry.getKey(), entry.getValue());
        }
        Iterator<Map.Entry<String, Integer>> entries1 = nMap.entrySet().iterator();
        while (entries1.hasNext()) {
            Map.Entry<String, Integer> entry = entries1.next();
            if (entry.getValue() < 500) map.remove(entry.getKey());
        }
    }

    public static void main(String[] args) {

    }
}