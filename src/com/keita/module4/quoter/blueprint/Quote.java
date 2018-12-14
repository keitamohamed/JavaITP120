package com.module4.quoter.blueprint;

import java.util.Scanner;

public class Quote {
    // put in your instance variable and constructors here
    private String quote;

    public Quote() {

    }

    public Quote(String quote) {
        super();
        this.quote = quote;
    }

    public int numChars() {
        return quote.length();
    }

    // b. The quote in all uppercase letters
    public String upper() {
        return quote.toUpperCase();

    }

    // The quote in all lowercase letters
    public String lower() {
        return quote.toLowerCase();
    }

    // d. The first character in the quote
    public char firstChar() {
        return quote.charAt(0);
    }

    // e. the number of vowels in the string
    // my counter

    // this program does not run properly. does not return any vowels.
    public int numVowels() {
        // my counter
        int numVowels = 0;
        char ch;
        // you code this
        // set up a counter for the number of vowels and set it to zero
        // put this above the method signature
        // figure out how long the string is
        // loop through the string (FOR LOOP) and get each character
        // check each character to see if it is a vowel (IF)
        // if it is, increment counter

        // for (int i = 0; i < quote.length(); i++)
        // for (int i = quote.length() - 1; i >= 0; i++) {
        for (int i = 0; i < quote.length(); i++) {
            ch = quote.toUpperCase().charAt(i);
            if (isVowel(ch)) {
                numVowels++;
            }
        }
        return numVowels;
    }

    // this program does not work either. does not return consonants.
    // f. the number of consonants in the string.
    public int numCons() {
        // need counter for number of consonants in the user's quote
        int numCons = 0;
        char ch;

        // for (int i = 0; quote.length() > i; i++)
        for (int i = 0; i < quote.length(); i++) {
            ch = quote.toUpperCase().charAt(i);
            if (isConsonants(ch)) {
                numCons++;
            }
        }
        return numCons;
    }

    // g. A method that asks the user to enter a character.

    public char giveChar() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a character: ");
        // just inserting a place holder
        return scan.next().charAt(0);
    }

    // this program does not work either.
    // The program should count and return the number of times that the
    // specified character appears in the string.
    public int numTimes(char c) {

        int singleOccurs = 0;
        for (int i = 0; i < quote.length(); i++)
            if (quote.charAt(i) == c) {
                singleOccurs = singleOccurs + 1;

            }

        // place holder for return
        return c;

    }

    private boolean isVowel(char ch) {
        return ch == 'A' || ch == 'E' || ch == 'I' ||
                ch == 'O' || ch == 'U';
    }

    private boolean isConsonants(char ch) {
        return ch == 'B' || ch == 'C' || ch == 'D' || ch == 'F' ||
                ch == 'G' || ch == 'H' || ch == 'J' || ch == 'K' ||
                ch == 'L' || ch == 'M' || ch == 'N' || ch == 'P' ||
                ch == 'Q' || ch == 'R' || ch == 'S' || ch == 'T' ||
                ch == 'V' || ch == 'W' || ch == 'X' || ch == 'Y' ||
                ch == 'Z';
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

}
