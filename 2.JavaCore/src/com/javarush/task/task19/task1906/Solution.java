package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);

        int i = 1;
        while (fileReader.ready()){
            int c = fileReader.read();
            if (i%2 == 0){
                fileWriter.write(c);
            }

            i++;
        }

        fileWriter.close();
        fileReader.close();
        bufferedReader.close();

    }
}
