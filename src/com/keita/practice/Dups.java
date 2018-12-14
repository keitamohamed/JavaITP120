package com.practice;

import java.util.*;

public class Dups {
    private static Scanner scan = new Scanner(System.in);
//    private static List<String> listQuote = new ArrayList<>();
    public static void main(String[] args) {
        List<String> listQuote = new ArrayList<>();

        TreeSet<String> tree;

        Scanner scan = new Scanner(System.in);
        // ask user to input a line of text from the keyboard
        // ask if case sensitive or not
        System.out.println("Type a sentence to enter in:");
        String quote = scan.nextLine();
        System.out.println("Do you want it case sensitive, yes or no?");
        boolean answer = scan.nextBoolean();

        if (!answer){
            System.out.println("All in lower");
            quote = quote.toLowerCase();
        }

        addToList(listQuote, quote);
        sortQuote(listQuote);
        printQuote(listQuote);
        tree = new TreeSet<>(listQuote);
        removerDupAndPrint(tree);

        // read it in as String
        // break String into parts - StringTokenizer or split method in String
        // class in Baseball
        // also a hint for removing punctuation

        // line - the first thing in here has to be what you want to break up
        // line stands for the String, can come in from the keyboard
        // second thing stands for what you want to break it up with

        // output must be the list of words alphabetically including duplicates:

        // and list of words in the sentence alphabetically removing duplicates:
        // treeset
        // worry about removing punctuation AFTER writing up the program

    }

    private static void printQuote(List<String> quote) {
        System.out.println("Here is the list of words in alphabetical order:\n" +
                "=======================================");
        for (String word : quote){
            System.out.print(word + " ");
        }
    }

    private static void addToList(List<String> listQuote, String quote) {
        StringTokenizer t = new StringTokenizer (quote, " |,./-! ");
        while (t.hasMoreElements()) {
            listQuote.add(t.nextToken());
        }
    }

    private static List<String> sortQuote(List<String> listQuote) {

        Collections.sort(listQuote, (s1, s2) -> s1.compareToIgnoreCase(s2));
//        listQuote.sort(String::compareToIgnoreCase);
        return listQuote;
    }

    private static void removerDupAndPrint(SortedSet<String> set) {
        Iterator iterator = set.iterator();
        System.out.println("\n\nHere is the alphabetized list without duplicates:\n" +
                "=========================================");
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }
}
