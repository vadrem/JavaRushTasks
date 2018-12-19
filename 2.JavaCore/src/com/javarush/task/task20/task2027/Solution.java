package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        //int[][] crossword = new int[][]{
        //        {'f', 'd', 'e', 'r', 'l', 'k'},
        //        {'u', 's', 'a', 'm', 'e', 'o'},
        //        {'l', 'n', 'g', 'r', 'o', 'v'},
        //        {'m', 'l', 'p', 'r', 'r', 'h'},
        //        {'p', 'o', 'e', 'e', 'j', 'j'}
        //};
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'm', 'm'},
                {'l', 'n', 'g', 'm', 'o', 'm'},
                {'t', 'l', 'p', 'm', 'm', 'm'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> aList = detectAllWords(crossword, "home", "same", "om");

        ;
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */

        for(int i = 0; i < aList.size(); i++){

            System.out.println(aList.get(i).toString());

        }
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        ArrayList<Word> aList = new ArrayList<>();
        for(String word : words){

            char[] cWord = word.toCharArray();
            int lWord = cWord.length;
            char eB = cWord[0];
            int height = crossword.length;
            for (int i = 0; i < height; i++) {

                int width = crossword[i].length;
                for (int j = 0; j < width; j++) {

                    //первая буква
                    //находим первую букву. потом в каждом из направлений ищем все совпадения
                    //если все совпало добавляем элемент с указанием координат первой и последний букв
                    if(eB == (char)crossword[i][j]){

                        //слово помещается, вторая и последняя буква совпадают - значит оно
                        // j увеличивается i не изменяется, вправо
                        if(j + lWord - 1 < width){

                            boolean esGibt = true;
                            for(int k = 1; k < lWord; k++){

                                if(cWord[k] != (char)crossword[i][j+k]){
                                    esGibt = false;
                                    break;
                                }

                            }

                            if(esGibt) {
                                Word nWord = new Word(word);
                                nWord.setStartPoint(j, i);
                                nWord.setEndPoint(j + lWord - 1, i);
                                aList.add(nWord);
                            }

                        }

                        // j увеличивается i увеличивается, вниз и вправо
                        if(j + lWord - 1 < width
                                && i + lWord - 1 < height){

                            boolean esGibt = true;
                            for(int k = 1; k < lWord; k++){

                                if(cWord[k] != (char)crossword[i + k][j+k]){
                                    esGibt = false;
                                    break;
                                }

                            }

                            if(esGibt) {
                                Word nWord = new Word(word);
                                nWord.setStartPoint(j, i);
                                nWord.setEndPoint(j + lWord - 1, i + lWord - 1);

                                aList.add(nWord);
                            }

                        }

                        // j не изменяется i увеличивается
                        if(i + lWord - 1 < height){

                            boolean esGibt = true;
                            for(int k = 1; k < lWord; k++){

                                if(cWord[k] != (char)crossword[i + k][j]){
                                    esGibt = false;
                                    break;
                                }

                            }

                            if(esGibt) {
                                Word nWord = new Word(word);
                                nWord.setStartPoint(j, i);
                                nWord.setEndPoint(j, i + lWord - 1);

                                aList.add(nWord);
                            }

                        }

                        // j уменьшается i увеличивается
                        if(j - lWord + 1 >= 0
                                && i + lWord - 1 < height){

                            boolean esGibt = true;
                            for(int k = 1; k < lWord; k++){

                                if(cWord[k] != (char)crossword[i + k][j - k]){
                                    esGibt = false;
                                    break;
                                }

                            }

                            if(esGibt) {
                                Word nWord = new Word(word);
                                nWord.setStartPoint(j, i);
                                nWord.setEndPoint(j - lWord + 1, i + lWord - 1);

                                aList.add(nWord);
                            }

                        }

                        // j уменьшается i не изменяется
                        if(j - lWord + 1 >= 0){

                            boolean esGibt = true;
                            for(int k = 1; k < lWord; k++){

                                if(cWord[k] != (char)crossword[i][j - k]){
                                    esGibt = false;
                                    break;
                                }

                            }

                            if(esGibt) {
                                Word nWord = new Word(word);
                                nWord.setStartPoint(j, i);
                                nWord.setEndPoint(j - lWord + 1, i);

                                aList.add(nWord);
                            }

                        }

                        // j уменьшается i уменьшается
                        if(j - lWord + 1 >= 0
                                && i - lWord + 1 >= 0){

                            boolean esGibt = true;
                            for(int k = 1; k < lWord; k++){

                                if(cWord[k] != (char)crossword[i-k][j - k]){
                                    esGibt = false;
                                    break;
                                }

                            }

                            if(esGibt) {
                                Word nWord = new Word(word);
                                nWord.setStartPoint(j, i);
                                nWord.setEndPoint(j - lWord + 1, i - lWord + 1);

                                aList.add(nWord);
                            }

                        }

                        // j не изменяется i уменьшается
                        if(i - lWord + 1 >= 0){

                            boolean esGibt = true;
                            for(int k = 1; k < lWord; k++){

                                if(cWord[k] != (char)crossword[i-k][j]){
                                    esGibt = false;
                                    break;
                                }

                            }

                            if(esGibt) {
                                Word nWord = new Word(word);
                                nWord.setStartPoint(j, i);
                                nWord.setEndPoint(j, i - lWord + 1);

                                aList.add(nWord);
                            }

                        }

                        // j увеличивается i уменьшается
                        if(j + lWord - 1 < width
                                && i - lWord + 1 >= 0){

                            boolean esGibt = true;
                            for(int k = 1; k < lWord; k++){

                                if(cWord[k] != (char)crossword[i-k][j+k]){
                                    esGibt = false;
                                    break;
                                }

                            }

                            if(esGibt) {
                                Word nWord = new Word(word);
                                nWord.setStartPoint(j, i);
                                nWord.setEndPoint(j + lWord - 1, i - lWord + 1);

                                aList.add(nWord);
                            }

                        }

                    }

                }
            }
        }

        return aList;
    }

    //if(i+charsN.length-1<crossword.length &&(crossword[i][j]==charsN[0] && crossword[i+charsN.length-1][j]==charsN[charsN.length-1] && crossword[i+1][j]==charsN[1])){

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
