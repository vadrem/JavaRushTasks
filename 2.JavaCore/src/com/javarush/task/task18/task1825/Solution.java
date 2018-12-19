package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        ArrayList<String> aList = new ArrayList<String>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        int iLeztePunkt = 0;
        String fileName = "";
        boolean erstLauf = true;
        while (true){

            s = bufferedReader.readLine();
            if (s.equals("end")) break;

            if (erstLauf){

                iLeztePunkt = s.lastIndexOf(".");
                fileName = s.substring(0, iLeztePunkt);

            }

            //найдем порядковый номер файла, чтоб добавить его на конкретное местов конкретного индекса в эррэйлист
            int index = Integer.parseInt(s.substring(iLeztePunkt + 5));
            aList.add(s);

            erstLauf = false;

        }

        Collections.sort(aList);

        File file = new File(fileName);
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        for (int i = 0; i < aList.size(); i++){

            FileInputStream fileInputStream = new FileInputStream(aList.get(i));
            if(fileInputStream.available() > 0) {
                byte[] buffer = new byte[fileInputStream.available()];
                int c = fileInputStream.read(buffer);

                fileOutputStream.write(buffer);
                fileOutputStream.flush();
            }

            fileInputStream.close();

        }

        fileOutputStream.close();

        bufferedReader.close();

    }
}
