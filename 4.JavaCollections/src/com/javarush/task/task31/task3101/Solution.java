package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File directory = new File(path);
        File fileResultFileAbsolutePath = new File(resultFileAbsolutePath);
        File allFilesContent = new File(fileResultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        FileUtils.renameFile(fileResultFileAbsolutePath, allFilesContent);
        ArrayList<File> aList = new ArrayList<File>();
        try (FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent)) {
            aList = fileBearbeiten(directory, aList);
            aList.sort(new FileNameComparator());

            for (File file : aList) {
                FileInputStream fileInputStream = new FileInputStream(file);

                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read());
                }

                fileOutputStream.write(System.lineSeparator().getBytes());
                fileOutputStream.flush();

                fileInputStream.close();
            }
        }

        //fileOutputStream.close();

    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static ArrayList<File> fileBearbeiten(File directory, ArrayList<File> aList){

        for(File file : directory.listFiles()){

            if(file.isFile()){

                if(file.length() > 50){

                    FileUtils.deleteFile(file);

                } else{

                    aList.add(file);

                }

            }else{

                aList = fileBearbeiten(file, aList);

            }
        }

        return aList;

    }

    //Компаратор для сравнения
    static class FileNameComparator implements Comparator<File> {
        public int compare(File first, File second) {
            return first.getName().compareTo(second.getName());
        }
    }
}
