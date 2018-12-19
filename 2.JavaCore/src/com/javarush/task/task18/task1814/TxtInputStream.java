package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    private FileInputStream fileInputStream;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {


        super(fileName);
        String mask = "";
        int k = fileName.lastIndexOf(".");
        mask = fileName.substring(k + 1);
        if (!mask.equals("txt")){
            super.close();
            throw new UnsupportedFileNameException();
        } else {
            this.fileInputStream = new FileInputStream(fileName);
        }



    }

    public static void main(String[] args) {
    }
}

