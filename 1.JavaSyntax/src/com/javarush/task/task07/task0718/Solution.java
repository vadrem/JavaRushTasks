package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> aList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i =0; i < 10; i++)
        {
            String s = bufferedReader.readLine();
            aList.add(s);
        }

        int sLength = 0;
        for (int i = 0; i < aList.size(); i++)
        {
            if (sLength > aList.get(i).length()){
                System.out.println(i);
                break;
            }

            sLength = aList.get(i).length();
        }
    }
}

