package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean istGros = false;
        boolean istKlein = false;
        boolean istZahl = false;
        int ch;

        while(istGros == false || istKlein == false || istZahl == false){

            istGros = false;
            istKlein = false;
            istZahl = false;
            byteArrayOutputStream.reset();

            byteArrayOutputStream.reset();
            ch = Az09();

            for (int i = 0; i < 8; i++) {
                ch = Az09();
                if (!istKlein && ch >= 97 && ch <= 122) istKlein = true;
                if (!istGros && ch >= 65 && ch <=90) istGros = true;
                if (!istZahl && ch >= 48 && ch <= 57) istZahl = true;
                byteArrayOutputStream.write(ch);

         }

        }

        return byteArrayOutputStream;
    }

    private static int Az09() {
        int ch = 0;
        boolean next = false;
        while (!next) {
            ch = (int)(48 + Math.random() * 75);
            if ((ch > 57 && ch < 65) || (ch > 90 && ch < 97)) continue;
            next = true;
        }
        return ch;
    }
}