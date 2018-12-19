package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {

        String fileName = args[0];
        String number = args[1];
        String text = args[2];

        int nummerInt = Integer.parseInt(number);


        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");


        long lengthFile = randomAccessFile.length();
        int lengthText = text.length();
        long newLength = nummerInt + lengthText;

        if(newLength > lengthFile){

            randomAccessFile.seek(lengthFile);

        }else{

            randomAccessFile.seek(nummerInt);

        }

        randomAccessFile.write(text.getBytes());
        randomAccessFile.close();

    }
}
