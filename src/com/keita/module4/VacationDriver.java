package com.keita.module4;

import com.keita.module4.vacation.blueprint.Vacation;

import java.util.Scanner;

public class VacationDriver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many vacation are there?: ");
        int numVacation = sc.nextInt();
        System.out.println("How many people booking a vacation today?: ");
        int numCustomer = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < numVacation; i++) {
            System.out.println("What is the name of vacation #" + (i + 1) + "?: ");
            String vacationName = sc.nextLine();
            System.out.println("How much does it cost from " + vacationName + "?: ");
            double priceEach = sc.nextDouble();
            sc.nextLine();
            Vacation vacation = new Vacation(vacationName, priceEach);
            for (int j = 0; j < numCustomer; j++) {
                System.out.println("How many vacation were made by person #" + (j + 1) +
                        " going from " + "" + vacation.getVacationName() + "?: ");
                int numberSold = sc.nextInt();
                sc.nextLine();
                vacation.updateSales(numberSold);
            }
            System.out.println(vacation.toString() + "\n");
        }
    }
}
