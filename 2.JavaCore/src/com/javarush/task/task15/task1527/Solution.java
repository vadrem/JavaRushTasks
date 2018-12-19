package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String url = bufferedReader.readLine();

            int i = url.indexOf("?");
            url = url.substring(i + 1);

            String sResult = "";
            String sObj = "";

            while (true) {
                int k = url.indexOf("&");
                if (k == -1) {
                    int j = url.indexOf("=");
                    if (j == -1) {
                        sResult = (sResult.equals("") ? sResult + "" : sResult + " ") + url;
                        break;
                    } else {

                        sResult = (sResult.equals("") ? sResult + "" : sResult + " ") + url.substring(0, j);
                        if (url.substring(0, j).equals("obj")) {
                            sObj = (sObj.equals("") ? sObj + "" : sObj + " ") + url.substring(j + 1);
                        }
                        break;
                    }
                } else {
                    String c = url.substring(0, k);
                    int j = c.indexOf("=");
                    if (j == -1) {
                        sResult = (sResult.equals("") ? sResult + "" : sResult + " ") + c;
                    } else {
                        sResult = (sResult.equals("") ? sResult + "" : sResult + " ") + c.substring(0, j);
                        if (c.substring(0, j).equals("obj")) {
                            sObj = (sObj.equals("") ? sObj + "" : sObj + " ") + c.substring(j + 1, k);
                        }
                    }

                }

                url = url.substring(k + 1);
            }

            System.out.println(sResult);
            if (!sObj.equals("")) {
                while (true) {
                    int n = sObj.indexOf(" ");
                    if (n == -1) {
                        if (!sObj.equals("")) {
                            try {
                                alert(Double.parseDouble(sObj));
                            } catch (Exception e) {
                                alert(sObj);
                            }

                            break;
                        }

                    } else {
                        try {
                            alert(Double.parseDouble(sObj.substring(0, n)));
                        } catch (Exception e) {
                            alert(sObj.substring(0, n));
                        }
                    }

                    sObj = sObj.substring(n + 1);
                }

            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
