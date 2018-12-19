package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

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

        double max = 0.0;
        for (Map.Entry entry : map.entrySet()) {
            if (max < (double)entry.getValue()) max = (double) entry.getValue();
        }

        for (Map.Entry entry : map.entrySet()) {
            if (max == (double)entry.getValue())System.out.println("" + entry.getKey()+"");
        }

        bufferedReader.close();

    }
}
