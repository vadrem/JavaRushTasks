package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            firstFileName = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{

        private FileReader fileReader;
        private String sReturn = "";

        public void run()
        {
            try {
                BufferedReader reader = new BufferedReader(fileReader);
                String line = reader.readLine();
                while (line != null) {

                    sReturn = sReturn + (sReturn == "" ? "":" ") + line;
                    line = reader.readLine();

                }
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }
        }

        @Override
        public void setFileName(String fullFileName) {

            try
            {
                fileReader = new FileReader(new File(fullFileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        @Override
        public String getFileContent() {

            return sReturn;
        }
    }
}
