package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static
    {
        threads.add(new Nit1());
        threads.add(new Nit2());
        threads.add(new Nit3());
        threads.add(new Nit4());
        threads.add(new Nit5());
    }

    public static void main(String[] args) {



    }

    public static class Nit1 extends Thread
    {

        public void run()
        {
            while (true)
            {

            }

        }

    }

    public static class Nit2 extends Thread
    {

        public void run()
        {
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               System.out.println("InterruptedException");
           }
        }

    }

    public static class Nit3 extends Thread
    {
        public void run()
        {

            try
            {
                while (!isInterrupted())
                {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }

    public static class Nit4 extends Thread implements Message
    {
        public void run()
        {
            showWarning();
        }

        @Override
        public void showWarning() {

            this.interrupt();

        }
    }

    public static class Nit5 extends Thread
    {
        public void run()
        {
            try
            {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                ArrayList<Integer> aList = new ArrayList<Integer>();
                int k = 0;
                while (!this.isInterrupted())
                {
                    String s = bufferedReader.readLine();
                    if (s.equals("N"))
                    {
                        for (int i = 0; i < aList.size(); i++){
                            k+=aList.get(i);
                        }

                        System.out.println(k);
                    } else
                    {
                        aList.add(Integer.parseInt(s));
                    }

                }



            }catch (IOException e)
            {

            }
        }
    }
}