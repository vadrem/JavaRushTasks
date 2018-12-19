package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V value = this.cache.get(key);
        if(value == null){
            Class[] paramTypes = new Class[] { key.getClass() };
            Constructor aConstrct = clazz.getConstructor(paramTypes);

            value = (V) aConstrct.newInstance(key);
            this.cache.put(key, value);
        }
        return value;
    }

    public boolean put(V obj) throws Exception {
        //TODO add your code here
        int size = size();
        Class cl = obj.getClass();

        Method method = null;
        try {
            method = cl.getDeclaredMethod("getKey", null);
            method.setAccessible(true);
            K key = (K)method.invoke(obj, null);

            cache.put(key, obj);
            if (size() <= size){
                return false;
            }
        } catch (NoSuchMethodException e) {
            return false;
        } catch (IllegalAccessException | InvocationTargetException e) {
            return false;
        }


        return true;
    }

    public int size() {
        return cache.size();
    }
}
