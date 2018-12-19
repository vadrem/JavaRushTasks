package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

        while(fileReader.ready()){

            String s = fileReader.readLine();
            fileWriter.write(s.replaceAll("\\p{Punct}",""));

        }

        fileWriter.close();
        fileReader.close();
        bufferedReader.close();
    }
}
