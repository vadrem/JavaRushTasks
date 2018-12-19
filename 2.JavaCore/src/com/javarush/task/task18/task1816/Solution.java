package com.javarush.task.task18.task1816;

/* 
Английские буквы
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
        int k = 0;
        for (int i = 0; i < c; i++){
            if ((buffer[i] >= 65 && buffer[i] <= 90)
                || (buffer[i] >= 97 && buffer[i] <= 122)){
                k++;
            }
        }

        System.out.println(k);

        fileInputStream.close();

    }
}
