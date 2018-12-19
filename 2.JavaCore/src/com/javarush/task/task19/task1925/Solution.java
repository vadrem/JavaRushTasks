package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception {

        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        FileWriter fileWriter = new FileWriter(fileName2);
        String newLine = "";
        boolean eL = true;
        while (fileReader.ready()){

            String line = fileReader.readLine();
            String[] ss = line.split(" ");
            for(String s : ss){

                if (s.length() > 6){
                    newLine = newLine + (eL ? "" : ",") + s;
                    eL = false;
                }

            }


        }
        fileWriter.write(newLine);

        fileReader.close();
        fileWriter.close();

    }
}
