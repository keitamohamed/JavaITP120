package com.practice;

public class StaticKeyWord {

    public static void main(String[] args) {

        System.out.println(Human.number);
        Human.printText();

        John john = new John();
        System.out.println(john.secondName());
        System.out.println(john.color());
        john.height();

        Human peter = new Peter();
        System.out.println();

        System.out.println(peter.secondName());
        System.out.println(peter.color());
        peter.height();
    }
}
