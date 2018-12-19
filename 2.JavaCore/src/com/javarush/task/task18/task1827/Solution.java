package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = bufferedReader.readLine();

        if (args[0].equals("-c")){

            String productName = getString(args[1], " ", 30); //30
            String price = getString(args[2], " ", 8); //8
            String quantity = getString(args[3], " ", 4); //4

            //надо найти получить id (следующий за максимальным) в файле 8 символов
            int maxid = 0;
            String s = "1";

            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[fileInputStream.available()];
            if (fileInputStream.available() > 0){

                int c = fileInputStream.read(buffer);
                String text = new String(buffer);
                while(true){

                    if (maxid < Integer.parseInt(text.substring(0,8).trim())) maxid = Integer.parseInt(text.substring(0,8).trim());

                    int k = text.indexOf((char)10);
                    if(k < 0){

                        break;
                    }else {

                        text = text.substring(k + 1);

                    }
                }
            }

            fileInputStream.close();

            if (maxid > 0) s = ""+(maxid+1)+"";
            String id = getString(s, " ", 8);

            String ware = (id.equals("1       ")? "" : ""+(char)13+""+(char)10+"")+id+productName+price+quantity+"";

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(buffer);
            fileOutputStream.write(ware.getBytes());

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
