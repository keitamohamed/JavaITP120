package com.keita.module5;

import java.util.Random;

public class RandomDiceDriver {

    public static void main(String[] args) {
        int[] rolls = new int[7];
        loadRolls(rolls);
        printRolls(rolls);
    }

    private static void loadRolls(int[] roll) {
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {

            int randomNum = (random.nextInt(6) + 1);
            roll[randomNum] += 1;
        }
    }


    private static void printRolls(int[] load) {
        System.out.println("Number\tOccurrence\n" +
                "==================");
        for (int i = 1; i < load.length ; i++) {
            System.out.println(i + ": \t\t" + load[i]);
        }
    }

}
