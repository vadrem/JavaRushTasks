package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.massIndex(weight, height);
    }

    public static class Body {
        public static void massIndex(double weight, double height) {

            double index = weight / (height * height);
            String s = "";
            if (index < 18.5)
            {
                s = "Недовес: меньше чем 18.5";
            }
            else if (index >= 18.5 && index <= 24.9)
            {
                s = "Нормальный: между 18.5 и 24.9";
            }
            else if (index >= 25 && index <= 29.9)
            {
                s = "Избыточный вес: между 25 и 29.9";
            } else
            {
                s = "Ожирение: 30 или больше";
            }

            System.out.println(s);
            //напишите тут ваш код
        }
    }
}
