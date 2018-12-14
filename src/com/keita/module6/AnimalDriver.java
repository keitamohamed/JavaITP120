package com.module6;

public class AnimalDriver {
    public static void main(String[] args) {
        AnimalAbstractClass dog = new Dog();
        AnimalAbstractClass cat = new Cat();
        AnimalAbstractClass chicken = new Chicken();

        dog.sound();
        cat.sound();
        chicken.sound();
    }
}

abstract class AnimalAbstractClass {
    abstract void sound();
}

class Dog extends AnimalAbstractClass {

    @Override
    void sound() {
        System.out.println("Wolff");
    }
}

class Cat extends AnimalAbstractClass {

    @Override
    void sound() {
        System.out.println("Mew");

    }
}

class Chicken extends AnimalAbstractClass {

    @Override
    void sound() { System.out.println("Cluck");
    }
}
