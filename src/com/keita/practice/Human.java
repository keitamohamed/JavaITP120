package com.practice;

public abstract class Human {

    static int number = 75100;

    abstract String color();

    void height() {
        System.out.println("Height is: " + 5.8);
    }

    String secondName() {
        return "William";
    }

    static void printText() {
        System.out.println("Human are people");
    }
}
