package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream fileOutputStream;

    public AmigoOutputStream(FileOutputStream file) throws FileNotFoundException {

        super(fileName);
        this.fileOutputStream = file;

    }

    public void write(int b) throws IOException{

        this.fileOutputStream.write(b);

    }
    public void write(byte[] b) throws IOException{

        this.fileOutputStream.write(b);

    }
    public void write(byte[] b, int off, int len) throws IOException{

        this.fileOutputStream.write(b, off, len);

    }
    public void flush() throws IOException{

        this.fileOutputStream.flush();

    }
    public void close() throws IOException{

        String s = "JavaRush © All rights reserved.";

        this.flush();
        this.write(s.getBytes());

        this.fileOutputStream.close();

    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
