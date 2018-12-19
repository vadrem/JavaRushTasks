package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        String fileName3 = bufferedReader.readLine();

        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream3 = new FileOutputStream(fileName3);

        int cByte1 = fileInputStream1.available();
        if (cByte1 > 0){
            int cByte2 = 0;
            int cByte3 = 0;
            if (cByte1%2 > 0){

                cByte2 = (cByte1 / 2) + 1;
                cByte3 = cByte1 - cByte2;

            } else {
                cByte2 = cByte1 / 2;
                cByte3 = cByte2;
            }

            if (cByte2 > 0){

                byte[] buffer2 = new byte[cByte2];
                int c2 = fileInputStream1.read(buffer2);
                fileOutputStream2.write(buffer2, 0, cByte2);

            }

            if (cByte3 > 0){

                byte[] buffer3 = new byte[cByte3];
                int c3 = fileInputStream1.read(buffer3);
                fileOutputStream3.write(buffer3, 0, cByte3);

            }

        }

        fileOutputStream2.flush();
        fileOutputStream3.flush();

        fileInputStream1.close();
        fileOutputStream2.close();
        fileOutputStream3.close();

    }
}
