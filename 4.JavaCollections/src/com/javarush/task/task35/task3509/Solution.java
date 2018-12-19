package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> aList = new ArrayList<>();
        for(T element : elements){
            aList.add(element);
        }

        return aList;
    }

    public static <T> HashSet <T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> set = new HashSet<>();
        for(T element : elements){
            set.add(element);
        }
        return set;
    }

    public static <K,V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        HashMap<K,V> map = new HashMap<>();

        if(keys.size() == values.size()){
            for(int i = 0; i < keys.size(); i++){
                map.put(keys.get(i),values.get(i));
            }
        }else
            throw new IllegalArgumentException();

        return map;
    }
}
