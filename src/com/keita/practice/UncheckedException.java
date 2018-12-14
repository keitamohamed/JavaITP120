package com.practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UncheckedException {
    public static void main(String[] args) {
        try {
            // Invoking a method and using a try-catch to catch it
            Dogs dogs = new Dogs();
            Method method = Dogs.class.getMethod("name", String.class);
            method.invoke(dogs, "John");

        }catch (NoSuchMethodException | IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Dogs {
    public void name(String name) {
        System.out.println("Name is " + name);
        }
}










