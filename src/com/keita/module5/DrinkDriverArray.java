package com.keita.module5;

import com.keita.module5.drinkblueprint.Drinks;

import java.text.NumberFormat;
import java.util.Scanner;

public class DrinkDriverArray {
    private static NumberFormat nf = NumberFormat.getCurrencyInstance();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Drinks[] drinks = new Drinks[20];

        boolean another = true;
        int counter = 0;

        while (another) {
            System.out.println("Enter the type of drink: ");
            String drinkType = sc.nextLine();
            System.out.println("What drink size?(S, M, or L)");
            String size = sc.nextLine().toUpperCase();

            while ((size.charAt(0) != 'S' && size.charAt(0) != 'M' && size.charAt(0) != 'L')) {
                System.out.println("Print " + size.charAt(0));
                System.out.println("What drink size?(S, M, or L)");
                size = sc.nextLine();
            }

            System.out.println("Enter cost of each drink: ");
            double costEach = sc.nextDouble();
            System.out.println("Enter number of drink's purchased: ");
            int numDrink = sc.nextInt();
            sc.nextLine();

            if (numDrink > 1 && (counter < 20)) {
                drinks[counter++] = new Drinks(drinkType, size.charAt(0), costEach, numDrink);
            }else {
                Drinks drinke = new Drinks(drinkType, size.charAt(0), costEach, numDrink);
            }

            System.out.println("Enter another drink order? (yes or no)");
            String anotherDrink = sc.nextLine();

            if (anotherDrink.equalsIgnoreCase("no")) {
                printOrder(drinks, counter);
                System.out.println("The total number of ticket purchased is " +
                        totalNum(drinks, counter) + ".\nThe cost of all the drinks purchased for " +
                        "all orders is " + nf.format(totalCost(drinks, counter)));
                another = false;
            }
        }
    }

    private static void printOrder(Drinks[] array, int counter) {
        for (int i = 0; i < counter; i++) {
            System.out.println(array[i].toString());
        }
    }

    private static int totalNum(Drinks[] drinks, int counter) {
        int totalTicket = 0;
        for (int i = 0; i < counter; i++) {
            totalTicket += drinks[i].getNumOrder();
        }
        return totalTicket;
    }

    private static double totalCost(Drinks[] drinks, int counter) {
        double totalPrice = 0;
        for (int i = 0; i < counter; i++) {
            totalPrice += (drinks[i].total());
        }
        return totalPrice;
    }
}

