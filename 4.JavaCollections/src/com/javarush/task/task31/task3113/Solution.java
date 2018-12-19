package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path>  {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String directory = bufferedReader.readLine();

        Path directoryPath = Paths.get(directory);
        if(!Files.isDirectory(directoryPath)){

            System.out.println(""+directory+" - не папка");
            return;

        }

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Solution solution = new Solution();
        Files.walkFileTree(directoryPath, options, 20, solution);

        System.out.println("Всего папок - "+(solution.getzahlDirectory() - 1)+"");
        System.out.println("Всего файлов - "+solution.getzahlFile()+"");
        System.out.println("Общий размер - "+solution.getzahlByte()+"");

    }

    private int zahlFile = 0;
    private int zahlDirectory = 0;
    private long zahlByte = 0;

    public int getzahlFile() {
        return zahlFile;
    }

    public int getzahlDirectory() {
        return zahlDirectory;
    }

    public long getzahlByte() {
        return zahlByte;
    }
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {

        zahlByte = zahlByte + Files.size(path);

        zahlFile++;

        return FileVisitResult.CONTINUE;

    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) throws IOException {

        zahlDirectory++;

        return FileVisitResult.CONTINUE;

    }
}
