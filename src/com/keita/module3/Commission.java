package com.module3;

import java.text.NumberFormat;
import java.util.Scanner;

public class Commission {

    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        Scanner sc = new Scanner(System.in);

        int totalEmployee = 0;
        double totalCommission = 0.0;

        System.out.println("Enter sales amount (-99 to end): ");
        double sale = sc.nextDouble();

        while (sale != -999) {
            double salary = 200;
            double commission = 0;
            totalEmployee++;

            if (sale >= 3000) {
                commission = ((sale - 3000) * .08) + (1000 * .05) + (500 * .03);
                salary += commission;
                totalCommission += salary;
            }
            else if ((sale > 1000) && (sale < 3000)) {
                commission = ((sale - 1000) * .05) + (500 * .03);
                salary += commission;
                totalCommission += salary;
            }
            else if ((sale >= 500) && (sale < 1000)) {
                commission = (sale - 500) * .03;
                salary += commission;
                totalCommission += salary;
            }

            System.out.println("You earned " + nf.format(commission) + " in " +
                    "commission for a total " + nf.format(salary) + " salary\n" +
                    "Enter sale amount (-999 to end)");
            sale = sc.nextDouble();
        }

        System.out.println("The number of employees is " + totalEmployee + " and the " +
                "total payout is " + nf.format(totalCommission));
    }
}
