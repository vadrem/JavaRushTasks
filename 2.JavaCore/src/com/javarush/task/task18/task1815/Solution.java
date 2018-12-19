package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {

        private ATableInterface aTableInterface;

        public TableInterfaceWrapper(ATableInterface aTable)
        {
            this.aTableInterface = aTable;
        }

        public void setModel(List rows){

            System.out.println(rows.size());
            this.aTableInterface.setModel(rows);

        }

        public String getHeaderText(){

            return this.aTableInterface.getHeaderText().toUpperCase();
        }

        public void setHeaderText(String newHeaderText){

            this.aTableInterface.setHeaderText(newHeaderText);

        }

    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}