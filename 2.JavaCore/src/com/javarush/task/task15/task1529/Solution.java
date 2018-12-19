package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        reset();
    }

    public static Flyable result;

    public static void reset() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try
        {
            String s = bufferedReader.readLine();

            if (s.equals("helicopter"))
            {
                result = new Helicopter();

            } else if (s.equals("plane"))
            {
                int zPass = Integer.parseInt(bufferedReader.readLine());
                result = new Plane(zPass);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            inputStreamReader.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
