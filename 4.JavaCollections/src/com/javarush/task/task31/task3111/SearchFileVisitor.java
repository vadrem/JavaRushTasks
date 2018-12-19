package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName = "";
    private String partOfContent = "";
    private int minSize = 0;
    private int maxSize = 0;

    private List<Path> foundFiles = new ArrayList<>();

    //setter
    public void setPartOfName(String partOfName){

        this.partOfName = partOfName;

    }

    public void setPartOfContent(String partOfContent){

        this.partOfContent = partOfContent;

    }

    public void setMinSize(int minSize){

        this.minSize = minSize;

    }

    public void setMaxSize(int maxSize){

        this.maxSize = maxSize;

    }

    public List<Path> getFoundFiles(){

        return foundFiles;

    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        String resultString = new String(Files.readAllBytes(file));
        boolean istPartOfContent = false;
        if (resultString.contains(partOfContent)) {

            istPartOfContent = true;

        }

        if((minSize == 0 || minSize <= Files.size(file))
                && (maxSize == 0 || maxSize >= Files.size(file))
                && (partOfName.equals("") || file.getFileName().toString().contains(partOfName))
                && (partOfContent.equals("") || istPartOfContent)){

            foundFiles.add(file);

        }

        //return super.visitFile(file, attrs);
        return FileVisitResult.CONTINUE;
    }
}
