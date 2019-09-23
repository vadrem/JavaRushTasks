package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        final String fileName = args[0];
        final Set<String> treeSetSort = new TreeSet<>();
        try (final BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName)))
        {
            int c = bufferedReader.read();
            while (c != -1)
            {
                if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122))
                {
                    final String symbol = new String(Character.toString((char)c)).toLowerCase();
                    treeSetSort.add(symbol);
                }
                c = bufferedReader.read();
            };
        }

        treeSetSort.stream().limit(5).forEach(System.out :: print);
    }
}
