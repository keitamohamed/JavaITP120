package com.keita.practice;

public class Peter extends Human {

    String color() {
        return "Black";
    }

    @Override
    String secondName() {
        return "Smith";
    }

    @Override
    void height() {
        System.out.println("Height is: " + 5.5);
    }


}
