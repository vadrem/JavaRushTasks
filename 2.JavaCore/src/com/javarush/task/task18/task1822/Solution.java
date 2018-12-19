package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);

        int id = Integer.parseInt(args[0]);

        byte[] buffer = new byte[fileInputStream.available()];
        int c = fileInputStream.read(buffer);

        String s = new String(buffer);
        String sNew = "";
        while (true){
            int k = s.indexOf((char)10);
            if(k < 0){

                s = s.trim();
                int j = s.indexOf(32);

                if(id == Integer.parseInt(s.substring(0,j))){
                    sNew = s;
                }

                break;
            }else {

                String sDop = s.substring(0,k);
                int j = sDop.indexOf(32);

                if(id == Integer.parseInt(sDop.substring(0,j))){
                    sNew = sDop;
                    break;
                }

                s = s.substring(k+1);

            }
        }

        if(!sNew.equals("")) System.out.println(sNew);

        fileInputStream.close();
        bufferedReader.close();

    }
}
