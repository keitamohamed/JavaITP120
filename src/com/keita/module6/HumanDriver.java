package com.keita.module6;

public class HumanDriver {
    public static void main(String[] args) {
        Person john = new John();
        Person ashely = new Ashely();
        Person mohamed = new Mohamed();
        Smith smithSong = new SmithSong();

        john.talk();
        ashely.talk();
        mohamed.talk();
        smithSong.talk();
        smithSong.walk();
    }
}

abstract class Person {
    abstract void talk();
    abstract void walk();
}

class John extends Person {

    @Override
    void talk() {
        System.out.println("Baby talk");
    }

    @Override
    void walk() {
    }
}

class Ashely extends Person {

    @Override
    void talk() {
        System.out.println("Sound language");
    }

    @Override
    void walk() {
    }
}

class Mohamed extends Person {

    @Override
    void talk() {
        System.out.println("Fast");
    }

    @Override
    void walk() {
    }
}

abstract class Smith extends Person {

    @Override
    void talk() {
        System.out.println("Loud");
    }
}

class SmithSong extends Smith {

    @Override
    void walk() {
        System.out.println("Sweet");
    }
}



