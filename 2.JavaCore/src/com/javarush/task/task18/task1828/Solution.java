package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = bufferedReader.readLine();

        if (args[0].equals("-u")){

            String id = getString(args[1], " ", 8); //8
            String productName = getString(args[2], " ", 30); //30
            String price = getString(args[3], " ", 8); //8
            String quantity = getString(args[4], " ", 4); //4

            //надо найти товар с id и заменить его параметры
            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[fileInputStream.available()];
            String textNew = "";
            if (fileInputStream.available() > 0){

                int c = fileInputStream.read(buffer);
                String text = new String(buffer);
                while(true){

                    int k = text.indexOf((char)10);
                    if(k < 0){

                        if (id.equals(text.substring(0,8))) {

                            textNew = textNew + id + productName + price + quantity;

                        }else {
                            textNew = textNew + text;
                        }
                        break;

                    }else {

                        if (id.equals(text.substring(0,8))) {

                            textNew = textNew + id + productName + price + quantity + (char)13 + (char)10;

                        }else {
                            textNew = textNew + text.substring(0,k+1);
                        }

                        text = text.substring(k + 1);

                    }

                }
            }

            fileInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(textNew.getBytes());

            fileOutputStream.close();

        } else if(args[0].equals("-d")){

            String id = getString(args[1], " ", 8); //8
            //надо найти товар с id и заменить его параметры
            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[fileInputStream.available()];
            String textNew = "";
            if (fileInputStream.available() > 0){

                int c = fileInputStream.read(buffer);
                String text = new String(buffer);
                while(true){

                    int k = text.indexOf((char)10);
                    if(k < 0){

                        if (id.equals(text.substring(0,8))) {

                            textNew = textNew + "";

                        }else {
                            textNew = textNew + text;
                        }
                        break;

                    }else {

                        if (id.equals(text.substring(0,8))) {

                            textNew = textNew + "";

                        }else {
                            textNew = textNew + text.substring(0,k+1);
                        }

                        text = text.substring(k + 1);

                    }

                }
            }

            fileInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(textNew.getBytes());

            fileOutputStream.close();

        }

        bufferedReader.close();

    }

    private static String getString(String text, String symbol, int count){

        int stringLength = text.length();
        if (stringLength > count){

            text = text.substring(0,count);

        } else if (stringLength < count){

            for(int i = stringLength; i < count; i++){

                text = text + symbol;

            }

        }

        return text;
    }
}
