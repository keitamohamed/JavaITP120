package com.keita.module3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // All variables inside this main method are local variables
        String rps;
        int uScore = 0;
        int cScore = 0;

        // Although we can use a for loop here, using a while for this
        // solution will be best, then using a for loop
        for (int i = 0; i != 3; i++) {
            int comp = (int) (Math.random() * 3) + 1;
            System.out.println("Guess rock, paper, scissors: ");
            String input = scan.nextLine();
            if (comp == 1) {
                rps = "Rock";
            }
            else if (comp == 2) {
                rps = "Paper";
            }
            else {
                rps = "Scissors";
            }
            if (rps.equalsIgnoreCase(input)) {
                uScore += 5;
                System.out.println("User current point " + uScore);
            }
            else {
                cScore +=  5;
                System.out.println("Computer current point " + cScore);
            }
        }

        if (uScore > cScore) {
            System.out.println("User win the game!");
        }
        else {
            System.out.println("Sorry you lose.");
        }
    }
}
