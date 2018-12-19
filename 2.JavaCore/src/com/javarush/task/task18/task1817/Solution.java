package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        //String fileName = "C:/Vadrem/test.txt";

        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte[] buffer = new byte[fileInputStream.available()];
        int c = fileInputStream.read(buffer);
        double j = 0;
        double k = 0;
        for (int i = 0; i < c; i++){

            j++;

            if (buffer[i] == 32){
                k++;
            }
        }
        double result = 0;
        result = (k/j)*100;
        System.out.println(Math.rint(100.0 * result) / 100.0);

        fileInputStream.close();

    }
}
