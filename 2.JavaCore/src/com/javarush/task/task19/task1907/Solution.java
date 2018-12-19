package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        int k = 0;

        while (fileReader.ready())
        {
            String[] s = fileReader.readLine().replaceAll("\\p{Punct}", " ").split(" ");
            for (String ss : s)
                if (ss.equals("world")) k++;
        }

        System.out.println(k);

        fileReader.close();
        bufferedReader.close();
    }
}
