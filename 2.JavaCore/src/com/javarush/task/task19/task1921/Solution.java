package com.javarush.task.task19.task1921;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {

        String fileName = args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()){

            String line = fileReader.readLine();
            String name = "";
            int m = 0;
            int d = 0;
            int y = 0;
            for (int i = 0; i <= 3; i++){

                int k = line.lastIndexOf(" ");
                if (i == 0)
                {
                    y = Integer.parseInt(line.substring(k + 1));
                } else if (i == 1){
                    m = Integer.parseInt(line.substring(k + 1));
                }else if (i == 2){
                    d = Integer.parseInt(line.substring(k + 1));
                } else {
                    name = line;
                    break;
                }

                line = line.substring(0,k);

            }



            PEOPLE.add(new Person(name, new Date(""+m+"/"+d+"/"+y)));

        }

        fileReader.close();

    }
}
