package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while(fileReader.ready()){

            String line = fileReader.readLine();
            for (int i = line.length() - 1; i >=0; i--){
                System.out.print(line.charAt(i));
            }

            System.out.print((char)10);
        }

        fileReader.close();

    }
}
