package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream amigoOutputStream;

    public QuestionFileOutputStream(AmigoOutputStream amigo) {

        this.amigoOutputStream = amigo;

    }

    public void flush() throws IOException{

        amigoOutputStream.flush();

    }

    public void write(int b) throws IOException{

        amigoOutputStream.write(b);

    }

    public void write(byte[] b) throws IOException{

        amigoOutputStream.write(b);

    }

    public void write(byte[] b, int off, int len) throws IOException{

        amigoOutputStream.write(b, off, len);

    }

    public void close() throws IOException{

        System.out.println("Вы действительно хотите закрыть поток? Д/Н");

        String s = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        s = bufferedReader.readLine();
        if (s.equals("Д")) amigoOutputStream.close();

    }


}

