package com.module5;

import java.util.Scanner;

public class DogArrayUnknownSize {
    public static void main(String[] args) {
        // add some numbers
        Scanner scan = new Scanner(System.in);
        // let's assume that we do not know how many dogs so we will assume
        // there will
        // not be more than ten
        Dog[] dogs = new Dog[10]; // this only makes the array --not the dogs
        String more = "yes";
        int counter = 0;
        while (more.equalsIgnoreCase("yes")) {
            String who;
            System.out.println("Dog's name:");
            who = scan.nextLine();
            // create the dog before putting him on the array
            Dog d = new Dog(who);
            dogs[counter] = d;
            counter++;
            System.out.println("More dogs? (yes or no)");
            more = scan.nextLine();
        }
        printDogs(dogs, counter);

    }

    public static void printDogs(Dog[] dogs, int howMany) {
        for (int i = 0; i < howMany; i++)
            System.out.println(dogs[i].toString());
    }
}
