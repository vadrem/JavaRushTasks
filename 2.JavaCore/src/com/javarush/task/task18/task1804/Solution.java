package com.javarush.task.task18.task1804;

import java.io.*;

/* 
Самые редкие байты
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

        int minByte = 0;
        boolean erstesJoggen = true;
        for (int i = 0; i < 256; i++)
        {
            if (bytes[i] > 0) {
                if (erstesJoggen)
                {
                    minByte = bytes[i];
                    erstesJoggen = false;
                }
                if (minByte >= bytes[i]) {
                    minByte = bytes[i];
                }
            }
        }

        String s = "";
        boolean k = false;
        for (int i = 0; i < 256; i++)
        {
            if(minByte == bytes[i])
            {
                s = s + (k ? " " : "") + i;
                k = true;
            }
        }
        System.out.println(s);
        fileInputStream.close();

    }
}
