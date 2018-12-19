package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        int j =0 ;

        while(true)
        {
            int k = scanner.nextInt();
            if(k == -1)
            {
                break;
            } else
            {
                i+=k;
                j++;
            }
        }

        System.out.println((double)i/j);
        //напишите тут ваш код
    }
}

