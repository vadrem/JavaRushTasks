package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        this.map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        return (int)this.map.values().stream().flatMap(list -> list.stream()).count();
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        List<V> list = this.map.get(key);
        if (list != null)
        {
            if (list.size() == this.repeatCount)
            {
                list.remove(0);
            }
            list.add(value);

            return list.get(list.size() - 2);
        }
        else
        {
            list = new ArrayList<>();
            list.add(value);
            this.map.put(key, list);

            return null;
        }
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        List<V> list = this.map.get(key);
        if (list == null)
            return null;

        V storeValue = list.get(0);
        list.remove(0);

        if (list.size() == 0)
            map.remove(key);

        return storeValue;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return this.map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        final ArrayList<V> arrayList = new ArrayList<>();
        this.map.values().stream().forEach(list -> list.forEach(arrayList :: add));
        return arrayList;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return this.map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        return this.map.values().stream().filter(list -> list.contains(value)).count() != 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}