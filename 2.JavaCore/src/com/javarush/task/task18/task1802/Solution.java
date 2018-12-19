package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int minByte = Integer.MIN_VALUE;
        boolean erstesJoggen = true;
        while (fileInputStream.available() > 0)
        {
            int flByte = fileInputStream.read();
            if (erstesJoggen)
            {
                minByte = flByte;
                erstesJoggen = false;
            }
            if(minByte >= flByte)
            {
                minByte = flByte;
            }
        }

        System.out.println(minByte);

        fileInputStream.close();
    }
}
