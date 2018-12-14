package com.module6;

import com.module6.insurance.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TrackInsurance extends Object {

    public static Scanner scan = new Scanner(System.in);

    // method that runs first
    public static void main(String[] args) throws Exception {

        // make an ArrayList of customers and insurance policies
        List<Customer> cust = new ArrayList<>();
        // note - the ArrayList below can hold Insurance objects
        // but with inheritance, that includes Auto, Health, Life and Art
        List<Insurance> ins = new ArrayList<>();

        // create some fake customers (used for testing the program)
        Customer c = new Customer("Duck", "Donald");
        Customer c1 = new Customer("Mouse", "Minnie");
        Customer c2 = new Customer("Mouse", "Mickey");

        // add the customers to the array list

        cust.add(c2);
        cust.add(c1);
        cust.add(c);

        // make and add some insurance policies to the ArrayList
        ins.add(new AutoInsurance(c, 2));
        ins.add(new AutoInsurance(c1, 3));
        ins.add(new HealthInsurance(c, 5));
        ins.add(new HealthInsurance(c2, 1));
        ins.add(new LifeInsurance(c, 30000, 65));
        ins.add(new LifeInsurance(c1, 400000, 34));

        // add your ArtInsurance instances here
        ins.add(new ArtInsurance(c, "picasso painting", 500000));
        ins.add(new ArtInsurance(c, "monet painting", 400000));
        ins.add(new ArtInsurance(c1, "van gogh painting", 300000));
        ins.add(new ArtInsurance(c1, "lowry painting", 200000));
        ins.add(new ArtInsurance(c2, "matisse painting", 100000));

        int choice = 0;
        while (choice >= 0) {
            choice = menu();
            if (choice == 1)
                printAllCustomers(cust);
            else if (choice == 2)
                printAllInsurance(ins);
            else if (choice == 3) {
                System.out
                        .println("Now lets find the information for a certain policy number");
                System.out.println("What policy number do you want to find?");
                int num = scan.nextInt();
                printPolicy(ins, num);
            } else if (choice == 4) {
                System.out
                        .println("Now let's find all of the policies for a given customer");
                System.out.println("What is the customer id?");
                int custNum = scan.nextInt();
                getCustomers(ins, custNum);
                //getCustomer(cust, ins, custNum);
            } else if (choice == 5) {
                sortCustNum(ins);
                printAllInsurance(ins);
            }
            else if (choice == 6) {
                sortPolNum(ins);
                printAllInsurance(ins);
            }
            else if (choice == 7) {
                System.out.println("Bye!!!!!");
                choice = -1;
            }
        } // end while

    }

    public static int menu() {
        System.out.println("Choice:");
        System.out
                .println("   1.  Print all customers (call the toString method)");
        System.out
                .println("   2.  Print all insurance information (call the toString method)");
        System.out
                .println("   3.  Given a policy number, print the policy information");
        System.out
                .println("   4.  Find all of the policies for a given customer");
        System.out
                .println("   5.  Sort the insurance policy information by customer number");
        System.out
                .println("   6.  Sort the insurance policy information by policy number");
        System.out.println("   7. QUIT!! ");
        System.out.println("\n CHOICE:");
        int value = scan.nextInt();
        return value;

    }



    // write a printAllCusts method that prints out the toString method for all
    // of the customers
    public static void printAllCustomers(List<Customer> cust) {
        cust.forEach(e -> System.out.println(e));
    }

    // write a printAllInsurance method that prints out the toString method for
    // all of the insurance policies
    public static void printAllInsurance(List<Insurance> insure) {
        // print out all of the information
        insure.forEach(System.out::println);
//        for (Insurance ins : insure) {
//            System.out.println(ins.toString());
//        }
    }

    // write a printPolicy method that prints the information for the policy
    // number
    // passed in or the statement "That policy does not exist" if it is not
    // present
    public static void printPolicy(List<Insurance> insure, int num) {
        for (int i = 0; i < insure.size(); i++) {
            if (insure.get(i).getPolicyNumber() == num) {
                System.out.println(insure.get(i));
            }
        }
    }

    // write a getCustomer method that prints the information for all of the
    // policies for a given customer
    // that customer number is passed in. If none, have it print
    // "There are no policies for that customer"
    private static void getCustomers(List<Insurance> insure, int num) {

        boolean found = false;

        for (int i = 0; i < insure.size(); i++) {
            if (insure.get(i).getCustomer().getId() == num) {
                System.out.println(insure.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("There are no customer in the list with ID number " + num);
        }

    }

    // write a method that sorts the policies by policy number
    // look at the example in the search_sort package
    public static void sortPolNum(List<Insurance> insure) {
        Collections.sort(insure);
    }

    // write a method that sorts the policies by customer number
    // this one is tougher since you can not use the Collections.sort() method
    // so you need to just slug out some code.
    // Look at the bubble sort from the SortByHand in the search_sort package
    // You will want to do something similar
    // Here is some pseudocode to help
    public static void sortCustNum(List<Insurance> insure) {

            for (int out = insure.size() - 1; out > 0; out--) {

                for (int in = 0; in < out; in++) {
                    // get the first insurance policy
                    Insurance fInsurance = insure.get(in);
                    // get the customer from that insurance policy
                    Customer fCust = fInsurance.getCustomer();
                    // get the customer number from that insurance policy
                    int fCustNum = fCust.getId();

                    // get the second insurance policy
                    Insurance sInsurance = insure.get(in + 1);
                    // get the customer from that insurance policy
                    Customer sCust = sInsurance.getCustomer();
                    // get the customer number from that insurance policy
                    int sCustNum = sCust.getId();

                    // We want to check to see if the second customer number is
                    // less than the first one

                    // NOTE: When comparing customer numbers:
                    // SortByHand uses Strings so it uses the compareTo()
                    // method.
                    // We are comparing integers so we can just use <

                    // if the second customer number is less than the first one
                    // swap the two insurance policies in the original "insure"
                    // ArrayList

                    if (sCustNum < fCustNum) {
                        Collections.swap(insure, in, (in + 1));
                    }
                    // check out the SortByHand to see how to swap.
                }
        }
    }

}
