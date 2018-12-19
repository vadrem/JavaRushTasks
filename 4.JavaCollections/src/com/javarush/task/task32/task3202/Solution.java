package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {

        if(is == null){

            return new StringWriter();

        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringWriter stringWriter = new StringWriter();

        while (bufferedReader.ready()) {
                //читаем строку из Reader’а
                String line = bufferedReader.readLine();

                //пишем строку в Writer
                stringWriter.write(line);

            }

        return stringWriter;

    }
}