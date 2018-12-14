package com.keita.module3;

import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int randomNum = (int) (Math.random() * 20 + 1);

        boolean keepPlaying = true;
        int numGuesses = 0;

        System.out.println("Guess a number (1 - 20): ");
        int userGuess = sc.nextInt();

        sc.nextLine();
        while (keepPlaying) {

            if (randomNum > userGuess) {
                System.out.println("Your guess was low. Guess again: ");
                userGuess = sc.nextInt();
                numGuesses++;
            }
            else if (randomNum < userGuess) {
                System.out.println("Your guess was high. Guess again: ");
                userGuess = sc.nextInt();
                numGuesses++;
            }
            else {
                sc.nextLine();
                numGuesses++;
                System.out.println("You guessed right! It took you " + numGuesses + " guesses\n" +
                        "Do you want to play again? (yes or no)");
                String playAgain = sc.nextLine();

                if (playAgain.equalsIgnoreCase("No")) {
                    keepPlaying = false;
                }
                else {
                    randomNum = (int) (Math.random() * 20 + 1);
                    numGuesses = 0;
                    System.out.println("Guess a number (1 - 20): ");
                    userGuess = sc.nextInt();
                }
            }
        }
        System.out.println("Game ended.");
    }
}
