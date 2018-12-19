package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        while (true)
        {

            if (scanner.hasNextInt())
            {
                int i = scanner.nextInt();
                if (i > 0 && i < 128)
                {
                    print((short) i);
                } else if (i <= 0 || i >= 128) {
                    print(i);
                }
            } else if (scanner.hasNextDouble())
            {
                Double d = scanner.nextDouble();
                print(d);
            } else
            {
                String s = scanner.next();
                if (s.equals("exit")) break;
                else print(s);
            }


        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
