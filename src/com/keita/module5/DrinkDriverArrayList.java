package com.module5;

import com.module5.drinkblueprint.Drinks;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class DrinkDriverArrayList {
    private static NumberFormat nf = NumberFormat.getCurrencyInstance();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Drinks> drinks = new ArrayList<>();

        boolean another = true;
        int counter = 0;

        while (another) {
            System.out.println("Enter the type of drink: ");
            String drinkType = sc.nextLine();
            System.out.println("What drink size?(S, M, or L)");
            char size = sc.next().charAt(0);
            System.out.println("Enter cost of each drink: ");
            double costEach = sc.nextDouble();
            System.out.println("Enter number of drink's purchased: ");
            int numDrink = sc.nextInt();
            sc.nextLine();

            if (numDrink > 1 && (counter < 20)) {
                drinks.add(new Drinks(drinkType, size, costEach, numDrink));
            }else {
                Drinks drinke = new Drinks(drinkType, size, costEach, numDrink);
            }

            System.out.println("Enter another drink order? (yes or no)");
            String anotherDrink = sc.nextLine();

            if (anotherDrink.equalsIgnoreCase("no")) {
                printOrder(drinks);
                System.out.println("The total number of ticket purchased is " +
                        totalNum(drinks) + ".\nThe cost of all the drinks purchased for " +
                        "all orders is " + nf.format(totalCost(drinks)));
                another = false;
            }
            counter++;
        }
    }

    private static void printOrder(ArrayList<Drinks> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    private static int totalNum(ArrayList<Drinks> list) {
        int totalTicket = 0;
        for (int i = 0; i < list.size(); i++) {
            totalTicket += list.get(i).getNumOrder();
        }
        return totalTicket;
    }

    private static double totalCost(ArrayList<Drinks> list) {
        double totalPrice = 0;
        for (int i = 0; i < list.size(); i++) {
            totalPrice += (list.get(i).getNumOrder() * list.get(i).getCostEach());
        }
        return totalPrice;
    }
}

