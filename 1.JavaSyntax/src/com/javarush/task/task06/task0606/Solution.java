package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        for (int j = 0; j < s.length(); j++) {

            int i = Character.getNumericValue(s.charAt(j));
                if (i%2 == 0)
                {
                    even++;
                } else
                {
                    odd++;
                }
        }

        System.out.println("Even: " + even + " Odd: " + odd + "");
        //напишите тут ваш код
    }
}
