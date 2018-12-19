package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int[] bytes = new int[256];
        while (fileInputStream.available() > 0)
        {
            int flByte = fileInputStream.read();
            bytes[flByte]++;
        }

        int maxByte = 0;
        for (int i = 0; i < 256; i++)
        {
            if(maxByte < bytes[i])
            {
                maxByte = bytes[i];
            }
        }

        String s = "";
        boolean k = false;
        for (int i = 0; i < 256; i++)
        {
            if(maxByte == bytes[i])
            {
                s = s + (k ? " " : "") + i;
                k = true;
            }
        }
        System.out.println(s);
        fileInputStream.close();
    }
}
