package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        if (args.length > 0)
        {

            switch (args[0]) {
                case "-c":
                    //- o добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
                    synchronized (allPeople) {
                        try {

                            for (int i = 1; i < args.length; i += 3) {
                                addPerson(args[i], args[i + 1], args[i + 2]);
                            }

                        } catch (ParseException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case "-u":

                //-u — обновляет данные человека с данным id
                    synchronized (allPeople) {
                        try {
                            for (int i = 1; i < args.length; i += 4) {
                                updatePerson(args[i], args[i + 1], args[i + 2], args[i + 3]);
                            }
                        } catch (ParseException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "-d" :

                //-d — производит логическое удаление человека с id, заменяет все его данные на null

                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            delPerson(args[i]);
                        }
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            printPerson(args[i]);
                        }
                    }
                    break;
            }
        }

    }

    private static void addPerson(String name, String sex, String birthDay) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date addBirthDate = format.parse(birthDay);

        if (sex.equals("м"))
        {
            Person person = Person.createMale(name, addBirthDate);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        } else if (sex.equals("ж"))
        {
            Person person = Person.createFemale(name, addBirthDate);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }



    }
    private static void updatePerson(String index, String name, String sex, String birthDay) throws ParseException
    {
        int i = Integer.parseInt(index);
        Person person = allPeople.get(i);
        // обновим данные у полученой персоны
        person.setName(name);
        person.setSex(sex.equals("м") ? Sex.MALE:Sex.FEMALE);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date addBirthDate = format.parse(birthDay);
        person.setBirthDay(addBirthDate);
    }

    private static void delPerson(String index)
    {

        int i = Integer.parseInt(index);
        Person person = allPeople.get(i);
        // обновим данные у полученой персоны
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);

    }

    private static void printPerson(String index)
    {
        int i = Integer.parseInt(index);
        Person person = allPeople.get(i);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " +format.format(person.getBirthDay()));

    }
}
