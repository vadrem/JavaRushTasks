package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

        char c;
        while (fileReader.ready()){

            c = (char)fileReader.read();
            if (c == 46) c= 33;
            fileWriter.write(c);

        }

        fileWriter.close();
        fileReader.close();
        bufferedReader.close();

    }

}
