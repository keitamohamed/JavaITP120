package com.module8;

import java.util.*;

public class Dups {
    private static List<String> listQuote = new ArrayList<>();
    private static TreeSet<String> removeDup;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Type a sentence to enter in:");
        String quote = scan.nextLine();
        System.out.println("Do you want it case sensitive, yes or no?");
        boolean input = scan.nextBoolean();

         if (!input) {
             quote = quote.toLowerCase();
        }

        addingToList(quote);
        sortQuote();
        printQuote(listQuote);

        removeDup = new TreeSet<>(listQuote);
        removeDupAndPrint(removeDup);
    }

    private static void printQuote(List<String> quote) {
        System.out.println("Here is the list of words in alphabetical order:\n" +
                "=========================================");
        for (String word : quote) {
            System.out.print(word + " ");
        }
    }

    private static void addingToList(String quote) {
        StringTokenizer t = new StringTokenizer (quote, " |,./-! ");
        while (t.hasMoreElements()) {
            listQuote.add(t.nextToken());
        }
    }

    private static List<String> sortQuote() {
        Collections.sort(listQuote, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
        return listQuote;
//        listQuote.sort(String::compareToIgnoreCase);
    }

    private static void removeDupAndPrint(SortedSet<String> set) {
        Iterator iterator = set.iterator();
        System.out.println("\n\nHere is the alphabetized list without duplicates:\n" +
                "=================================================");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

}
