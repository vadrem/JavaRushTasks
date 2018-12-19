package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){

            this.fileScanner = fileScanner;

        }
        public Person read() throws IOException{

            String firstName = "";
            String middleName= "";
            String lastName= "";
            String d = "";
            String m= "";
            String y= "";
            Date birthDate = new Date();

            String string = this.fileScanner.nextLine();
            for (int i = 0; i < 8; i++){

                int k = string.indexOf(" ");
                if (i == 0){
                    firstName = string.substring(0,k);
                } else if (i == 1){
                    middleName = string.substring(0,k);
                } else if (i == 2){
                    lastName = string.substring(0,k);
                } else if (i == 3){
                    d = string.substring(0,k);
                } else if (i == 4){
                    m = string.substring(0,k);
                } else if (i == 5){
                    y = string.substring(0,k);
                }

                string = string.substring(k + 1);

            }

            birthDate.setDate(Integer.parseInt(d));
            birthDate.setMonth(Integer.parseInt(m));
            birthDate.setYear(Integer.parseInt(y));
            birthDate.setHours(0);
            birthDate.setMinutes(0);
            birthDate.setSeconds(0);

            Person person = new Person(firstName, middleName, lastName, birthDate);

            return person;
        }

        public void close() throws IOException{
            this.fileScanner.close();
        }



    }
}
