package com.module3;

public class DiceGame {
    public static void main(String[] args) {

        int userScore = 0, computerScore = 0, numTie = 0;

        for (int i = 0; i < 5; i++) {
            int computer = (int) (Math.random() * 6 + 1);
            int user = (int) (Math.random() * 6 + 1);

            if (computer > user) {
                System.out.println("\nComputer's number: " + computer + "" +
                        "\nPlayer's number: " + user + "\nComputer wins!");
                computerScore++;

            }
            else if (computer < user){
                System.out.println("\nComputer's number: " + computer + "" +
                        "\nPlayer's number: " + user + "\nPlayer wins!");
                userScore++;

            }
            else {
                System.out.println("\nComputer's number: " + computer + "" +
                        "\nPlayer's number: " + user + "\nIt's a tie!");
                numTie++;
            }
        }

        if (computerScore > userScore) {
            System.out.println("\nComputer was the winner with " + computerScore + "" +
                    " wins.\nPlayer had " + userScore + " wins.\nThere were " + numTie + "" +
                    " ties.");
        }
        else {
            System.out.println("\nPlayer was the winner with " + userScore + "" +
                    " wins.\nComputer had " + computerScore + " wins.\nThere were " + numTie + "" +
                    " ties.");
        }
    }
}
