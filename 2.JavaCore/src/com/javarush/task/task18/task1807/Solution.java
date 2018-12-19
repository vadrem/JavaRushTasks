package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int count = 0;
        while (fileInputStream.available() > 0){

            if (fileInputStream.read() == 44){

                count++;

            }

        }
        System.out.println(count);
        fileInputStream.close();
    }
}
