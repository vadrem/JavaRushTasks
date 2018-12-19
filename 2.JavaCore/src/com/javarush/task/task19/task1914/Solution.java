package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        //Возвращаем все как было
        System.setOut(consoleStream);

        //разворачиваем строку
        String zeichen = "";
        int a = 0;
        int b = 0;
        String[] stringArray = result.split(" ");
        for (String ss : stringArray){

            if (ss.equals("+")){
                zeichen = "+";
            }else if (ss.equals("-")){
                zeichen = "-";
            }else if (ss.equals("*")){
                zeichen = "*";
            }else if (ss.equals("=")){
                break;
            } else if (a != 0){
                b = Integer.parseInt(ss);
            } else{
                a = Integer.parseInt(ss);
            }

        }

        int c = 0;
        if (zeichen.equals("+")){
            c = a + b;
        } else if (zeichen.equals("-")) {
            c = a - b;
        } else {
            c = a * b;
        }

        String reverseString = a + " "+ zeichen + " " + b + " = "+c;

        //выводим ее в консоль
        System.out.println(reverseString);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

