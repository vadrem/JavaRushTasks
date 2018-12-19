package com.javarush.task.task31.task3102;

import java.io.*;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        File file = new File(root);
        Queue<File> queue = new PriorityQueue<>();
        Collections.addAll(queue, file.listFiles());
        ArrayList<String> aList = new ArrayList<String>();
        while(!queue.isEmpty()){

            File currentFile = queue.remove();
            if(currentFile.isDirectory()){

                Collections.addAll(queue, currentFile.listFiles());

            }else{
                aList.add(currentFile.getAbsolutePath());
            }

        }

        return aList;

    }

    public static void main(String[] args) throws IOException {

        List<String> arrayList = getFileTree("gg");

    }
}
