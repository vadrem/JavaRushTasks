package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);
        fileInputStream.close();


    }

    public void save(OutputStream outputStream) throws Exception {

        Properties p = new Properties();
        p.putAll(properties);
        p.store(outputStream, null);

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.load(inputStream);
        for (Map.Entry<Object, Object> entry : p.entrySet()){

            properties.put(entry.getKey().toString(), entry.getValue().toString());

        }
    }

    public static void main(String[] args) {

    }
}
