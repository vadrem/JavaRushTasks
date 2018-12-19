package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);

        if (fileInputStream1.available() > 0){
            byte[] buffer = new byte[fileInputStream1.available()];
            int cByte = fileInputStream1.read(buffer);
            for (int i = cByte - 1; i >=0 ; i--){

                fileOutputStream2.write(buffer[i]);

            }

        }

        fileOutputStream2.flush();
        fileOutputStream2.close();
        fileInputStream1.close();

    }
}
