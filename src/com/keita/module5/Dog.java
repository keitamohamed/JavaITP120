package com.module5;

public class Dog {
    private String name;

    public Dog()
    {

    }
    public Dog(String n)
    {
        name = n;
    }

    public String toString()
    {
        return "Name is " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
