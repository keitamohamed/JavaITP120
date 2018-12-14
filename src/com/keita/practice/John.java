package com.practice;

public class John extends Human{

    @Override
    String color() {
        return "White";
    }

    @Override
    String secondName() {
        return super.secondName();
    }


}
