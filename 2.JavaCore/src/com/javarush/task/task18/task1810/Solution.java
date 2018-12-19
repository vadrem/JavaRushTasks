package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String fileName = bufferedReader.readLine();
            FileInputStream fileInputStream = new FileInputStream(fileName);
            if (fileInputStream.available() < 1000){

                fileInputStream.close();
                throw new DownloadException();

            }
            fileInputStream.close();
        }



    }

    public static class DownloadException extends Exception {

    }
}
