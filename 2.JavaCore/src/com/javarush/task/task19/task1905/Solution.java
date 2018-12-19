package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static{
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem{

        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {

            this.customer = customer;
            this.contact = contact;

        }
        public String getCountryCode(){

            String s = "";
            String country = this.customer.getCountryName();
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if(entry.getValue().equals(country)) {
                    s = entry.getKey();
                    break;
                }
            }
            return s;

        }        //example UA
        public String getCompany(){

            return this.customer.getCompanyName();

        }            //example JavaRush Ltd.
        public String getContactFirstName(){

            return contact.getName().split(", ")[1];

        }   //example Ivan
        public String getContactLastName(){

            return contact.getName().split(", ")[0];


        }    //example Ivanov
        public String getDialString(){

            String telephonNumber = this.contact.getPhoneNumber();
            String[] numb = telephonNumber.split("[\\(\\)-]");
            String newTelephonNumber="callto://";
            for(String tmp:numb) newTelephonNumber += tmp;

            return newTelephonNumber;

        }         //example callto://+380501234567

    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}