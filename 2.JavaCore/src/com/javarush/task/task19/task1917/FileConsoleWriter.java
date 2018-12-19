package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {

    private FileWriter fileWriter;
    public static void main(String[] args) throws Exception{
    }

    public FileConsoleWriter(String fileName) throws IOException{

        fileWriter = new FileWriter(fileName);

    }
    public FileConsoleWriter(String fileName, boolean append) throws IOException{

        fileWriter = new FileWriter(fileName, append);

    }
    public FileConsoleWriter(File file) throws IOException{

        fileWriter = new FileWriter(file);

    }
    public FileConsoleWriter(File file, boolean append) throws IOException{

        fileWriter = new FileWriter(file, append);

    }
    public FileConsoleWriter(FileDescriptor fd) throws IOException{

        fileWriter = new FileWriter(fd);

    }

    public void write(char[] cbuf, int off, int len) throws IOException{

        fileWriter.write(cbuf, off, len);
        StringBuilder stringBuilder  = new StringBuilder();
        for (int i = off; i < off+len; i++)
            stringBuilder.append(cbuf[i]);
        System.out.println(stringBuilder);

    }
    public void write(int c) throws IOException{

        fileWriter.write(c);
        System.out.println(c);

    }
    public void write(String str) throws IOException{

        fileWriter.write(str);
        System.out.println(str);

    }
    public void write(String str, int off, int len) throws IOException{

        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off + len));

    }
    public void write(char[] cbuf) throws IOException{

        fileWriter.write(cbuf);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: cbuf)
            stringBuilder.append(c);
        System.out.println(stringBuilder);

    }


    public void close() throws IOException{

        fileWriter.close();

    }


}
