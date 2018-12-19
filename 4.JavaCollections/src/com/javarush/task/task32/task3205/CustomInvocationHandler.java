package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by vadrem on 09.11.2017.
 */
public class CustomInvocationHandler implements InvocationHandler {

    SomeInterfaceWithMethods someInterfaceWithMethods;

    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods){

        this.someInterfaceWithMethods = someInterfaceWithMethods;

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {

        System.out.println(""+method.getName()+" in");
        Object k = method.invoke(someInterfaceWithMethods, args);
        System.out.println(""+method.getName()+" out");

        return k;
    }
}
