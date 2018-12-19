package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            int count = users.size();
            printWriter.println(count);

            if (count > 0) {

                for (User user : users) {
                    printWriter.println(user.getFirstName() == null ? "null" : user.getFirstName());
                    printWriter.println(user.getLastName() == null ? "null" : user.getLastName());
                    printWriter.println(user.getBirthDate() == null ? "null" : format.format(user.getBirthDate()));

                    printWriter.println(user.isMale() ? "male" : "female");
                    printWriter.println(user.getCountry() == null ? "null" : user.getCountry().getDisplayedName());
                }

            }

            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:s");
            int count = Integer.parseInt(reader.readLine());
            String userString = "";
            for (int i = 0; i < count; i++) {
                User user = new User();

                userString = reader.readLine();
                if(!userString.equals("null"))user.setFirstName(userString);

                userString = reader.readLine();
                if(!userString.equals("null"))user.setLastName(userString);

                userString = reader.readLine();
                if(!userString.equals("null"))user.setBirthDate(format.parse(userString));

                user.setMale(reader.readLine().equals("male"));

                userString = reader.readLine();
                if (userString.equals(User.Country.RUSSIA.getDisplayedName())) user.setCountry(User.Country.RUSSIA);
                if (userString.equals(User.Country.UKRAINE.getDisplayedName())) user.setCountry(User.Country.UKRAINE);
                if (userString.equals(User.Country.OTHER.getDisplayedName())) user.setCountry(User.Country.OTHER);

                users.add(user);

            }
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
