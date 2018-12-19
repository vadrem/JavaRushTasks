package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName1);

        byte[] buffer = new byte[fileInputStream.available()];
        int c = fileInputStream.read(buffer);

        String s = new String(buffer);
        String sNew = "";
        boolean erstLauf = true;
        while (true){
            int k = s.indexOf(" ");
            if (k < 0){

                double d = Double.parseDouble(s);
                d = doubleRund(d);

                sNew = sNew + (erstLauf ? "" : " ")+ (int)d + "";

                break;

            }else {

                double d = Double.parseDouble(s.substring(0, k));
                d = doubleRund(d);

                sNew = sNew + (erstLauf ? "" : " ")+ (int)d + "";

                s = s.substring(k + 1);

            }
            erstLauf = false;
        }

        byte[] buffer2 = sNew.getBytes();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        fileOutputStream.write(buffer2);

        fileOutputStream.close();
        fileInputStream.close();
        bufferedReader.close();

    }

    private static double doubleRund(double d){

        if (d >= 0)
        {
            d = Math.round(d);
        }else {

            BigDecimal bd = new BigDecimal(""+d+"");

            int k = (int)d;
            double dd = Math.rint(100.00 * ((d - k)*100) / 100.00) / 100;
            if (dd < -0.5){
                bd = bd.setScale(0, BigDecimal.ROUND_FLOOR);
            } else {
                bd = bd.setScale(0, BigDecimal.ROUND_CEILING);
            }
            bd.toBigInteger();
            d = bd.doubleValue();
        }

        return d;
    }
}
