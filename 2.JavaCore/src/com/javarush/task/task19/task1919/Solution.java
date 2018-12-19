package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws Exception {

        String fileName = args[0];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        Map<String, Double> map = new TreeMap<String, Double>();

        while (bufferedReader.ready()){

            String line = bufferedReader.readLine();
            int c = line.indexOf(" ");
            String name = line.substring(0,c);
            double d = Double.parseDouble(line.substring(c+1));
            double dd = 0.0;
            if (map.containsKey(name)){
                dd =  map.get(name) + d;
            } else{
                dd = d;
            }

            map.put(name, dd);

        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.println("" + entry.getKey() + " " + entry.getValue());
        }

        bufferedReader.close();

    }
}
