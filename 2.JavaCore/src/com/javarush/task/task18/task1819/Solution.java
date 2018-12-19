package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        FileInputStream file1Input = new FileInputStream(fileName1);

        //list man 1-e file
        byte[] buffer1 = new byte[file1Input.available()];
        int c1 = file1Input.read(buffer1);

        file1Input.close();

        FileInputStream file2 = new FileInputStream(fileName2);
        FileOutputStream file1Output = new FileOutputStream(fileName1);

        //list man 2-e file
        byte[] buffer2 = new byte[file2.available()];
        int c2 = file2.read(buffer2);

        file1Output.write(buffer2, 0, c2);
        file1Output.write(buffer1);

        file1Output.close();
        file2.close();

        bufferedReader.close();

    }
}
