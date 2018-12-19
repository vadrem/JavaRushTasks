package com.javarush.task.task34.task3404;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6


        String s = "";
        s = "sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output 0.5 6 actually ");
        solution.recursion(s, 0);
        s = "tan(45)";
        System.out.print(s + " expected output 1 1 actually ");
        solution.recursion(s, 0);
        s = "tan(-45)";
        System.out.print(s + " expected output -1 2 actually ");
        solution.recursion(s, 0);
        s = "0.305";
        System.out.print(s + " expected output 0.3 0 actually ");
        solution.recursion(s, 0);
        s = "0.3051";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0);
        s = "(0.3051)";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0);
        s = "6/2*3";
        System.out.print(s + " expected output 9 2 actually ");
        solution.recursion(s, 0);
        s = "6*2/3";
        System.out.print(s + " expected output 4 2 actually ");
        solution.recursion(s, 0);
        s = "6*2*3";
        System.out.print(s + " expected output 36 2 actually ");
        solution.recursion(s, 0);
        s = "6/2/3";
        System.out.print(s + " expected output 1 2 actually ");
        solution.recursion(s, 0);
        s = "1+(1+(1+1)*(1+1))*(1+1)+1";
        System.out.print(s + " expected output 12 8 actually ");
        solution.recursion(s, 0);
        s = "tan(44+sin(89-cos(180)^2))";
        System.out.print(s + " expected output 1 6 actually ");
        solution.recursion(s, 0);
        s = "-2+(-2+(-2)-2*(2+2))";
        System.out.print(s + " expected output -14 8 actually ");
        solution.recursion(s, 0);
        s = "sin(80+(2+(1+1))*(1+1)+2)";
        System.out.print(s + " expected output 1 7 actually ");
        solution.recursion(s, 0);
        s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
        System.out.print(s + " expected output 6 11 actually ");
        solution.recursion(s, 0);
        s = "2^10+2^(5+5)";
        System.out.print(s + " expected output 2048 4 actually ");
        solution.recursion(s, 0);
        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
        System.out.print(s + " expected output 72.96 8 actually ");
        solution.recursion(s, 0);
        s = "0.000025+0.000012";
        System.out.print(s + " expected output 0 1 actually ");
        solution.recursion(s, 0);
        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
        System.out.print(s + " expected output -3 16 actually ");
        solution.recursion(s, 0);
        s = "cos(3 + 19*3)";
        System.out.print(s + " expected output 0.5 3 actually ");
        solution.recursion(s, 0);
        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
        System.out.print(s + " expected output 8302231.36 14 actually ");
        solution.recursion(s, 0);
        s = "(-1 + (-2))";
        System.out.print(s + " expected output -3 3 actually ");
        solution.recursion(s, 0);
        s = "-sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output -0.5 7 actually ");
        solution.recursion(s, 0);
        s = "sin(100)-sin(100)";
        System.out.print(s + " expected output 0 3 actually ");
        solution.recursion(s, 0);
        s = "-(-22+22*2)";
        System.out.print(s + " expected output -22 4 actually ");
        solution.recursion(s, 0);
        s = "-2^(-2)";
        System.out.print(s + " expected output -0.25 3 actually ");
        solution.recursion(s, 0);
        s = "-(-2^(-2))+2+(-(-2^(-2)))";
        System.out.print(s + " expected output 2.5 10 actually ");
        solution.recursion(s, 0);
        s = "(-2)*(-2)";
        System.out.print(s + " expected output 4 3 actually ");
        solution.recursion(s, 0);
        s = "(-2)/(-2)";
        System.out.print(s + " expected output 1 3 actually ");
        solution.recursion(s, 0);
        s = "sin(-30)";
        System.out.print(s + " expected output -0.5 2 actually ");
        solution.recursion(s, 0);
        s = "cos(-30)";
        System.out.print(s + " expected output 0.87 2 actually ");
        solution.recursion(s, 0);
        s = "tan(-30)";
        System.out.print(s + " expected output -0.58 2 actually ");
        solution.recursion(s, 0);
        s = "2+8*(9/4-1.5)^(1+1)";
        System.out.print(s + " expected output 6.5 6 actually ");
        solution.recursion(s, 0);
        s = "0.005 ";
        System.out.print(s + " expected output 0.01 0 actually ");
        solution.recursion(s, 0);
        s = "0.0049 ";
        System.out.print(s + " expected output 0 0 actually ");
        solution.recursion(s, 0);
        s = "0+0.304";
        System.out.print(s + " expected output 0.3 1 actually ");
        solution.recursion(s, 0);
        s = "28^sin(1-98098^0)";
        System.out.print(s + " expected output 1 4 actually ");
        solution.recursion(s, 0);

    }

    public void recursion(final String expression, int countOperation) {
        //implement
        String newExpression = expression;
        newExpression = newExpression.trim();
        newExpression = newExpression.replaceAll(" ", "");

        if(countOperation == 0){

            countOperation = (newExpression.split("sin").length - 1)
            + (newExpression.split("cos").length - 1)
            + (newExpression.split("tan").length - 1)
            + (newExpression.split("\\*").length - 1)
            + (newExpression.split("-").length - 1)
            + (newExpression.split("\\+").length - 1)
            + (newExpression.split("/").length - 1)
            + (newExpression.split("\\^").length - 1);

        }

        //в метод передали число, значит выводим значение на экран и выходим из метода
        if(newExpression.matches("^-?\\d+(?:\\.\\d+)?$") || newExpression.matches("^\\d+$")){

            //String s = ""+(double)((int) Math.round(Double.parseDouble(newExpression) * 100)) / 100+"";
            String s = new DecimalFormat("#.##").format(Double.valueOf(newExpression));
            s = s.replaceAll(",", ".");

            System.out.print(s.endsWith(".0") ? s.substring(0, s.length() - 2) : s);
            System.out.println(" " + countOperation);
            return;

        }

        //ищем скобки
        String strokaObrabotki = newExpression;
        int indexSkobaL = newExpression.lastIndexOf("(");
        int indexSkobaR = -1;
        if(indexSkobaL >=0){

            indexSkobaR = newExpression.indexOf(")",indexSkobaL);
            strokaObrabotki = newExpression.substring(indexSkobaL + 1, indexSkobaR);

        }

        //ищем тригонометрические функции
        Pattern p = Pattern.compile("(sin|cos|tan)-?\\d+(?:\\.\\d+)?"); //подходит для поиска тригонометрических функций с числом внутри
        Matcher m = p.matcher(strokaObrabotki);
        if(m.find()){

            int indexA = m.start();
            int indexB = m.end();

            String substring = m.group();
            double rechnenResult = rechnen(substring, true);

            substring = new BigDecimal(rechnenResult).setScale(4, RoundingMode.HALF_UP).toString();

            strokaObrabotki = strokaObrabotki.substring(0, indexA) + substring + strokaObrabotki.substring(indexB);
            if(indexSkobaL >= 0)strokaObrabotki = newExpression.substring(0,indexSkobaL + 1) + strokaObrabotki + newExpression.substring(indexSkobaR);

            recursion(strokaObrabotki, countOperation);
            return;

        }

        //обработаем степень, два варианта (перед числом со степенью стоит +- или -- или *- u.a. и вариант когда один знак)
        p = Pattern.compile("(\\+-|--|\\*-|/-|\\^-)\\d+(?:\\.\\d+)?\\^-?\\d+(?:\\.\\d+)?"); //подходит для поиска числа возведенного в степень, перед которым стоит +- или --
        m = p.matcher(strokaObrabotki);
        if(m.find()){

            int indexA = m.start();
            int indexB = m.end();

            String substring = m.group();
            double rechnenResult = rechnen(substring.substring(1), false);

            substring = new BigDecimal(rechnenResult).setScale(4, RoundingMode.HALF_UP).toString();

            strokaObrabotki = strokaObrabotki.substring(0, indexA+1) + substring + strokaObrabotki.substring(indexB);
            if(indexSkobaL >= 0)strokaObrabotki = newExpression.substring(0,indexSkobaL + 1) + strokaObrabotki + newExpression.substring(indexSkobaR);

            recursion(strokaObrabotki, countOperation);
            return;

        }

        p = Pattern.compile("-?\\d+(?:\\.\\d+)?\\^-?\\d+(?:\\.\\d+)?"); //подходит для поиска числа возведенного в степень
        m = p.matcher(strokaObrabotki);
        if(m.find()){

            int indexA = m.start();
            int indexB = m.end();

            String substring = m.group();
            if(indexA !=0 && substring.startsWith("-")){
                substring = substring.substring(1);
                indexA++;
            }
            double rechnenResult = rechnen(substring, false);

            substring = new BigDecimal(rechnenResult).setScale(4, RoundingMode.HALF_UP).toString();

            strokaObrabotki = strokaObrabotki.substring(0, indexA) + substring + strokaObrabotki.substring(indexB);
            if(indexSkobaL >= 0)strokaObrabotki = newExpression.substring(0,indexSkobaL + 1) + strokaObrabotki + newExpression.substring(indexSkobaR);

            recursion(strokaObrabotki, countOperation);
            return;

        }

        //обработаем умножение или деление, два варианта (перед числом со степенью стоит +- или -- или *- u.a. и вариант когда один знак)
        p = Pattern.compile("(\\+-|--|\\*-|/-|\\^-)\\d+(?:\\.\\d+)?(\\*|/)-?\\d+(?:\\.\\d+)?"); //подходит для поиска дклкния или умножения, перед которым стоит +- или --
        m = p.matcher(strokaObrabotki);
        if(m.find()){

            int indexA = m.start();
            int indexB = m.end();

            String substring = m.group();
            double rechnenResult = rechnen(substring.substring(1), false);

            substring = new BigDecimal(rechnenResult).setScale(4, RoundingMode.HALF_UP).toString();

            strokaObrabotki = strokaObrabotki.substring(0, indexA + 1) + substring + strokaObrabotki.substring(indexB);
            if(indexSkobaL >= 0)strokaObrabotki = newExpression.substring(0,indexSkobaL + 1) + strokaObrabotki + newExpression.substring(indexSkobaR);

            recursion(strokaObrabotki, countOperation);
            return;

        }

        p = Pattern.compile("-?\\d+(?:\\.\\d+)?(\\*|/)-?\\d+(?:\\.\\d+)?"); //подходит для поиска деления или умножения
        m = p.matcher(strokaObrabotki);
        if(m.find()){

            int indexA = m.start();
            int indexB = m.end();

            String substring = m.group();
            if(indexA !=0 && substring.startsWith("-")) {
                substring = substring.substring(1);
                indexA++;
            }
            double rechnenResult = rechnen(substring, false);

            substring = new BigDecimal(rechnenResult).setScale(4, RoundingMode.HALF_UP).toString();

            strokaObrabotki = strokaObrabotki.substring(0, indexA) + substring + strokaObrabotki.substring(indexB);
            if(indexSkobaL >= 0)strokaObrabotki = newExpression.substring(0,indexSkobaL + 1) + strokaObrabotki + newExpression.substring(indexSkobaR);

            recursion(strokaObrabotki, countOperation);
            return;

        }

        //обрабатываем сложение
        p = Pattern.compile("(-|--)?\\d+(?:\\.\\d+)?(\\+|--|-|\\+-)\\d+(?:\\.\\d+)?"); //подходит для поиска сложения или разности
        m = p.matcher(strokaObrabotki);
        if(m.find()){

            int indexA = m.start();
            int indexB = m.end();

            String substring = m.group();
            double rechnenResult = rechnen(substring, false);

            substring = new BigDecimal(rechnenResult).setScale(4, RoundingMode.HALF_UP).toString();

            strokaObrabotki = strokaObrabotki.substring(0, indexA) + substring + strokaObrabotki.substring(indexB);
            if(indexSkobaL >= 0)strokaObrabotki = newExpression.substring(0,indexSkobaL + 1) + strokaObrabotki + newExpression.substring(indexSkobaR);

            recursion(strokaObrabotki, countOperation);
            return;

        }

        //если сюда дошло, значит это просто число, значит это точно между скобками
        p = Pattern.compile("-?\\d+(?:\\.\\d+)?"); //подходит для поиска числа
        m = p.matcher(strokaObrabotki);
        if(m.find()){

            String substring  = m.group();
            substring = new BigDecimal(Double.parseDouble(substring)).setScale(4, RoundingMode.HALF_UP).toString();

            strokaObrabotki = newExpression.substring(0,indexSkobaL) + substring + newExpression.substring(indexSkobaR + 1);

            recursion(strokaObrabotki, countOperation);
            return;

        }

    }

    public double rechnen(String expression, boolean trigonometry){

        //вычислительные опреации
        double resultString = 0;
        if(trigonometry){

            String zahl = "0";
            Pattern p = Pattern.compile("-?\\d+(?:\\.\\d+)?");
            Matcher m = p.matcher(expression);

            if (m.find()) zahl = m.group();
            double result = 0;

            if(expression.contains("sin")){

                result = Math.sin((Double.parseDouble(zahl) * Math.PI) / 180);

            }
            if(expression.contains("cos")){

                result = Math.cos((Double.parseDouble(zahl)* Math.PI) / 180);

            }

            if(expression.contains("tan")){

                result = Math.tan((Double.parseDouble(zahl) * Math.PI) / 180);

            }

            resultString = result;

        } else {

            String substring = expression;

            //сначала найдем и обработаем степень в выражении
            if(substring.contains("^")){

                int indexStepen = substring.indexOf("^");

                double zahl1 = Double.parseDouble(substring.substring(0, indexStepen));
                double zahl2 = Double.parseDouble(substring.substring(indexStepen + 1));

                double doubleResult = Math.pow(zahl1, zahl2);
                resultString = doubleResult;

            } else if(substring.contains("*")){

                int indexMulteple = substring.indexOf("*");
                double zahl1 = Double.parseDouble(substring.substring(0, indexMulteple));
                double zahl2 = Double.parseDouble(substring.substring(indexMulteple + 1));

                double doubleResult = zahl1 * zahl2;

                resultString = doubleResult;

            } else if(substring.contains("/")){

                int indexDel = substring.indexOf("/");
                double zahl1 = Double.parseDouble(substring.substring(0, indexDel));
                double zahl2 = Double.parseDouble(substring.substring(indexDel + 1));

                double doubleResult = zahl1 / zahl2;

                resultString = doubleResult;

            } else {

                substring = substring.replaceAll("--", "+");
                substring = substring.replaceAll("-", "+-");

                String[] arrayZahl = substring.split("\\+");
                double doubleResult = 0;
                for(int i = 0; i < arrayZahl.length; i++){

                    if(arrayZahl[i].equals(""))continue;

                    doubleResult = doubleResult + Double.parseDouble(arrayZahl[i]);

                }

                resultString = doubleResult;

            }

        }

        return resultString;
    }

    public Solution() {
        //don't delete
    }
}
