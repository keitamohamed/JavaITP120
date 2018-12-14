package com.keita.module3.blueprint;

import java.util.Scanner;

public class LargeSmallD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0; int min = 0; int totalNum = 2;
        String play = "yes";

        for (int i = 1; i <= 2; i++) {

            System.out.println("Run #" + i);

            while (!play.equalsIgnoreCase("no")) {
                System.out.println("Enter a number");
                int input = sc.nextInt();

                if (max == 0 || min == 0) {
                    max = input;
                    min = input;
                }
                else if (max < input) {
                    max = input;
                }
                else if (min > input) {
                    min = input;
                }
                sc.nextLine();

                System.out.println("More number? (yes or no)");
                play = sc.nextLine();

                totalNum++;
            }

            System.out.println("You entered " + totalNum + " numbers. The lowest " +
                    "number: " + min + "   Highest number: " + max + "\n");

            if (i <= totalNum) {
                play = "yes";
            }
        }
    }
}
