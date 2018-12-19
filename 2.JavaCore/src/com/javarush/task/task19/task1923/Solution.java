package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {

        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));

        FileWriter fileWriter = new FileWriter(fileName2);
        String newLine = "";
        boolean eL = true;
        while (fileReader.ready()) {

            String line = fileReader.readLine();
            newLine = newLine + (eL ? "" : " ") + line;
            eL = false;
        }

        fileReader.close();

        eL = true;
        String lineFile2 = "";
        String[] ss = newLine.split(" ");
        for (String s : ss) {

            if(s.matches(".*\\d.*")) {
                lineFile2 = lineFile2 + (eL ? "" : " ") + s;
                eL = false;
            }

        }

        fileWriter.write(lineFile2);

        fileWriter.close();

    }
}
