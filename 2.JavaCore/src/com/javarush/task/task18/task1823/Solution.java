package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String fileName = bufferedReader.readLine();
            if (fileName.equals("exit")) break;

            ReadThread readThread = new ReadThread(fileName);
            readThread.start();

        }

        bufferedReader.close();

    }

    public static class ReadThread extends Thread {

        private String readHeadFileName;

        public ReadThread(String fileName) {
            this.readHeadFileName = fileName;//implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут

        public void run(){

            try {
                FileInputStream fileInputStream = new FileInputStream(readHeadFileName);
                int cByte = fileInputStream.available();
                if (cByte > 0){

                    int[] argsByte = new int[256];

                    while (fileInputStream.available() > 0)
                    {
                        int flByte = fileInputStream.read();
                        argsByte[flByte]++;
                    }

                    int max = argsByte[0];
                    int maxByte = 0;
                    for (int j = 0; j < argsByte.length; j++){
                        if (argsByte[j] > max){

                            max = argsByte[j];
                            maxByte = (byte)j;


                        }
                    }

                    synchronized (resultMap){
                        resultMap.put(readHeadFileName, maxByte);
                    }

                    fileInputStream.close();

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
