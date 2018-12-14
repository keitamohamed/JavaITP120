package com.practice;

public class StaticBluePrint {

    private String name;
    public static int number = 100;
    public int age;

    public StaticBluePrint (){}

    public StaticBluePrint(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
