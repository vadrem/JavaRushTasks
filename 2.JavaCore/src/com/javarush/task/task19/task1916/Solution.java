package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = reader.readLine();
        String file2Name = reader.readLine();
        ArrayList<String> line1 = new ArrayList<>();
        ArrayList<String> line2 = new ArrayList<>();
        BufferedReader fr1 = new BufferedReader(new FileReader(file1Name));
        BufferedReader fr2 = new BufferedReader(new FileReader(file2Name));
        while (fr1.ready())
        {
            line1.add(fr1.readLine());
        }
        while (fr2.ready())
        {
            line2.add(fr2.readLine());
        }
        for (int index = 0; index < line1.size(); index++)
        {
            if (line2.size() > 0 && line1.get(index).equals(line2.get(0)) )
            {
                LineItem item = new LineItem(Type.SAME, line1.get(index));
                lines.add(item);
                line2.remove(0);
            }else if (line2.size() > 0 && !(line1.get(index).equals(line2.get(0))))
            {
                if (line2.size() > 1 && line1.get(index).equals(line2.get(1)))
                {
                    LineItem item = new LineItem(Type.ADDED, line2.get(0));
                    lines.add(item);
                    line2.remove(0);
                    index--;
                }else
                {
                    LineItem item = new LineItem(Type.REMOVED, line1.get(index));
                    lines.add(item);
                }
            }
        }
        if (line2.size() > 0)
        {
            for (String longerLines : line2)
            {
                lines.add(new LineItem(Type.ADDED, longerLines));
            }
        }
        // if ()
        for (LineItem x : lines)
        {
            System.out.println(x.type + " " + x.line);
        }
        reader.close();
        fr1.close();
        fr2.close();

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
