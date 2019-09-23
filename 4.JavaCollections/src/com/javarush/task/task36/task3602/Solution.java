package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass()
    {
        final Class[] classes = Collections.class.getDeclaredClasses();
        for (final Class c : classes)
        {
            if (Modifier.isPrivate(c.getModifiers())
            && Modifier.isStatic(c.getModifiers())
            && List.class.isAssignableFrom(c))
            {
                try
                {
                    final Constructor constructor = c.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    final List list = (List) constructor.newInstance();
                    list.get(0);
                } catch (IndexOutOfBoundsException e) {
                    return  c;
                } catch (NoSuchMethodException e){
                    //e.printStackTrace();
                } catch (IllegalAccessException e) {
                    //e.printStackTrace();
                } catch (InstantiationException e) {
                    //e.printStackTrace();
                } catch (InvocationTargetException e) {
                    //e.printStackTrace();
                }
            }
        }
        return null;
    }
}
