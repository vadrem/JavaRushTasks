package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {



        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
        byte[] buffer = new byte[fileInputStream.available()];

        if (fileInputStream.available() > 0) {
            int c = fileInputStream.read(buffer);
            if (args[0].equals("-e")) {
                buffer = eincoding(buffer);


            } else if (args[0].equals("-d")){

                    buffer = decoding(buffer);

            }

            fileOutputStream.write(buffer);
        }
        fileOutputStream.close();
        fileInputStream.close();

    }

    private static byte[] eincoding(byte[] buffer) {

        for (int i = 0; i < buffer.length; i++) {

            buffer[i]++;

        }

        return buffer;

    }

    private static byte[] decoding(byte[] buffer){

        for (int i = 0; i < buffer.length; i++){

            buffer[i]--;

        }

        return buffer;

    }

}
