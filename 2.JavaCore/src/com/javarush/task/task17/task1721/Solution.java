package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static String firstFileName;
    public static String secondFileName;

    static
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            firstFileName = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();

            bufferedReader.close();
        } catch (IOException e) {

        }

    }

    public static void main(String[] args) {

        allLines = RedFileToList(allLines, firstFileName);
        forRemoveLines = RedFileToList(forRemoveLines, secondFileName);

        try
        {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public void joinData () throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
        } else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }

    public static List<String> RedFileToList (List<String> aList, String fileName)
    {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null) {

                aList.add(line);
                line = reader.readLine();

            }
            reader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        return aList;
    }
}
