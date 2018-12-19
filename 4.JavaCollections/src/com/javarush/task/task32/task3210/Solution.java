package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {

        String fileName = args[0];
        String number = args[1];
        String text = args[2];

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");

            int len = text.length();
            byte[] buffer = new byte[len];

            randomAccessFile.seek(Integer.parseInt(number));

            randomAccessFile.read(buffer, 0, len);
            String result = convertByteToString(buffer);

            long fileLong = randomAccessFile.length();
            randomAccessFile.seek(fileLong);
            if (result.equals(text)) {

                randomAccessFile.write("true".getBytes());

            } else {
                randomAccessFile.write("false".getBytes());
            }





            randomAccessFile.close();
        } catch (Exception e){

        }

    }

    private static String convertByteToString(byte[] bt) {
        return new String(bt);
    }
}
