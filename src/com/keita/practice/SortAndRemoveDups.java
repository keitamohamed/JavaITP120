package com.practice;

import java.util.*;

public class SortAndRemoveDups {
    // given an array of names
    // want to take the array and turn it into an arraylist or some type of list
    private static final String names[] = { "yellow", "green", "black", "tan", "grey", "white", "orange", "red",
            "green" };

    // create a sorted set with TreeSet, then manipulate it
    public static void main(String args[]) {
        List<String> list = Arrays.asList(names);
        // this one line of code can turn the array into a List
        // want to remove the duplicates
        // create TreeSet
        TreeSet<String> tree = new TreeSet<String>(list);
        // turn the List into a TreeSet
        // treeset removes duplicates and orders it according to comparable
        // String class already has a compareto method, therefore, it already
        // implements comparable
        // going to print out a set

        System.out.println("sorted set: ");

        printSet(tree); // output contents of tree
    }

    // output set
    // there are no indexes in sets
    // two ways to do it - iterator and enhanced for loop
    private static void printSet(SortedSet<String> set) {
        // Better to use iterators instead of "for" loops. Since sets have no
        // order, what does it mean
        // to progress through them in order like a "for" loop does? A set also
        // does not have indices
        Iterator it = set.iterator(); // get the iterator for the set
        while (it.hasNext())
            System.out.println(it.next());
        // says to go through the entire collection and iterate through it and print every one of them out

		/*
		 * another way it could be done for ( String s : set ) System.out.print(
		 * s + " " ); this is an enhanced for loop
		 * this says: for every String in set, call it 's' and print out 's'
		 * set is the variable name of the collection being passed in the method
		 */

        System.out.println();
    } // end method printSet

}
