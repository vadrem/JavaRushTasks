package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        String fileName = args[0];

        FileInputStream fileInputStream = new FileInputStream(fileName);

        int[] aSCII = new int[255];

        byte[] buffer = new byte[fileInputStream.available()];
        int c = fileInputStream.read(buffer);

        for (int i = 0; i < c; i++){

            aSCII[buffer[i]]++;

        }

        for (int i = 0; i < aSCII.length; i++){

            if(aSCII[i] != 0) System.out.println((char)i + " " + aSCII[i]);

        }

        fileInputStream.close();

    }
}
