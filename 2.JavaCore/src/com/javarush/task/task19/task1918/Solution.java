package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();

        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String tag = args[0];
        String text = "";

        while (fileReader.ready()){

            text = text + fileReader.readLine();

        }

        fileReader.close();

        String openTag = "(<)(" + tag + ")(([\\s][^>]*)?)(>)";
        String closeTag = "((<)(/)(" + tag + ")(>))";
        Pattern pattern = Pattern.compile(openTag + "|" + closeTag);

        Matcher matcher = pattern.matcher(text);

        ArrayList<String> aListString = new ArrayList<String>();
        ArrayList<Integer> aListInteger = new ArrayList<Integer>();
        int i = 0; //индекс списка
        int k = 0;
        while (matcher.find()) {
            String match = matcher.group();
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            if (Pattern.matches(openTag, match)) {
                aListInteger.add(startIndex);
                aListString.add("");

                i++;
                k=0;
            } else if (Pattern.matches(closeTag, match)) {
                aListString.set(i-1-k,text.substring(aListInteger.get(aListInteger.size()-1), endIndex));
                aListInteger.remove(aListInteger.size()-1);
                k++;
            }
        }

        for(int j = 0; j < aListString.size(); j++){

            System.out.println(aListString.get(j));

        }


    }
}
