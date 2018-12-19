package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = bufferedReader.readLine();

        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()){

            String line = fileReader.readLine();
            String text = "";
            int k = 0;
            boolean eL = true;
            while (true){

                int c = line.indexOf(" ");
                if (c < 0){
                    text = text + "" +(eL ? "" : " ")+ ""+line;
                    if(words.contains(line)){

                        k++;

                    }
                    break;
                } else{

                    if(words.contains(line.substring(0,c))){

                        k++;

                    }
                    text = text+ " " + line.substring(0,c);
                    eL = false;

                }

                line = line.substring(c+1);
            }

            if (k == 2){

                System.out.println(text);

            }

        }

        fileReader.close();

    }
}
