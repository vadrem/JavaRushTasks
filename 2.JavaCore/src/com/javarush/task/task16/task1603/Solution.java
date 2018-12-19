package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread list1 = new SpecialThread();
        Thread thread1 = new Thread(list1);
        list.add(thread1);

        SpecialThread list2 = new SpecialThread();
        Thread thread2 = new Thread(list2);
        list.add(thread2);

        SpecialThread list3 = new SpecialThread();
        Thread thread3 = new Thread(list3);
        list.add(thread3);

        SpecialThread list4 = new SpecialThread();
        Thread thread4 = new Thread(list4);
        list.add(thread4);

        SpecialThread list5 = new SpecialThread();
        Thread thread5 = new Thread(list5);
        list.add(thread5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
