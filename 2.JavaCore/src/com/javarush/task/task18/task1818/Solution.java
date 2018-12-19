package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        String fileName3 = bufferedReader.readLine();

        FileOutputStream file1 = new FileOutputStream(fileName1);
        FileInputStream file2 = new FileInputStream(fileName2);
        FileInputStream file3 = new FileInputStream(fileName3);

        //list man 2-e file
        byte[] buffer2 = new byte[file2.available()];
        int c2 = file2.read(buffer2);

        //list man 3-e file
        byte[] buffer3 = new byte[file3.available()];
        int c3 = file3.read(buffer3);

        file1.write(buffer2);
        file1.write(buffer3);

        file1.close();
        file2.close();
        file3.close();

        bufferedReader.close();

    }
}
