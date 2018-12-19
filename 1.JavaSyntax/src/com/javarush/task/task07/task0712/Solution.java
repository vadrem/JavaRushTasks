package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> aList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int min = 0;

        for (int i =0; i < 10; i++)
        {
            String s = bufferedReader.readLine();
            if (s.length() > max)
            {
                max = s.length();
            }

            if (min == 0 || s.length() < min){
                min = s.length();
            }
            aList.add(s);
        }

        for (int i = 0; i < 10; i++)
        {
            if (aList.get(i).length() == max || aList.get(i).length() == min)
            {
                System.out.println(aList.get(i));
                break;
            }
        }

    }
}
