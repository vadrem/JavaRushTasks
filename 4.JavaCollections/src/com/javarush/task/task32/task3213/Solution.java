package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {

        if(reader == null){

            return "";

        }

        BufferedReader bufferedReader = new BufferedReader(reader);
        String result = "";
        while(bufferedReader.ready()){

            String s = bufferedReader.readLine();
            if(s == null){

                break;

            }
            byte[] buffer = s.getBytes();

            for(int i = 0; i < buffer.length; i ++){

                int intresult = 0;

                //if(65 <= buffer[i] && buffer[i] <= 90){

                //    intresult = machschieb(buffer[i], 65, 90, key);

                //} else if (97 <= buffer[i] && buffer[i] <= 122){

                //    intresult = machschieb(buffer[i], 97, 122, key);

                //} else if (192 <= buffer[i] && buffer[i] <= 223){

                //    intresult = machschieb(buffer[i], 192, 223, key);

                //} else if (224 <= buffer[i] && buffer[i] <= 255){

                //    intresult = machschieb(buffer[i], 224, 255, key);

                //} else {
                //    continue;
                //}

                buffer[i] = (byte)(buffer[i] + key);

            }

            result = result + new String(buffer);

        }

        return result;
    }

    private static int machschieb(int source, int a, int b, int key){

        int result = source + key;
        if(result < a){

            result = b - (a - result);

        }

        return result;
    }

}
