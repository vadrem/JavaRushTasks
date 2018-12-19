package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        int[] kArray = new int[15];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < kArray.length; i++) {

            String s = bufferedReader.readLine();
            int k = Integer.parseInt(s);
            kArray[i] = k;
        }

        int cNuber = 0;
        int ncNumber = 0;

        for (int i = 0; i < kArray.length; i++)
        {
            if (i == 0 || i%2 == 0)
            {
                cNuber+=kArray[i];
            }
            else
            {
                ncNumber+=kArray[i];
            }
        }

        if (cNuber > ncNumber)
        {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        else
        {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }

    }
}
