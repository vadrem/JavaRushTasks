package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

        while (fileReader.ready()){

            String[] s = fileReader.readLine().split(" ");
            String pattern = "\\d+";
            for(String ss : s){

                if (ss.matches(pattern)){
                    fileWriter.write(ss + " ");
                }

            }

        }

        fileWriter.close();
        fileReader.close();
        bufferedReader.close();

    }
}
