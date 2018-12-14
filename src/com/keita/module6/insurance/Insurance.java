package com.keita.module6.insurance;

import java.text.NumberFormat;

public abstract class Insurance implements Comparable<Insurance> {

    // NOTE: these fields are protected!!!!!  If I am to inherit
    // these , they must be protected (private allows NO other classes
    // to use them) - protected means this class and any class that inherits
    // from this one can use these
    protected Customer customer;
    protected double yearlyRate;
    protected int policyNumber;

    // for currency output
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    // a static variable used to make the insurance id unique
    public static int num = 1000;

    // full constructor - automatically creates a new Insurance id
    public Insurance (Customer cust) {
        customer = cust;
        policyNumber = num;
        num++;
    }

    // used for reading from a file where policy number and rate already set
    public Insurance (Customer cust, int polNum, double yrRate) {
        customer = cust;
        policyNumber=polNum;
        yearlyRate = yrRate;
    }

    // the empty constructor but still sets a unique id
    public Insurance () {
        policyNumber=num;
        num++;
    }


    // the calcRate method is used to set the yearlyRate
    // NOTE: this is an abstract class.  That means it can not be used (has no body)
    // but by putting here, we require any class that inherits from the Insurance class
    // to fully implement this method if they want to be a concrete class
    public abstract void calcRate();

    // required by the Comparable interface. Describes how to compare two Insurance instances
    // In this one, we want to compare policy numbers
    // Look at how we did the one in the Customer Employee
    // Look at the one in the search_sort.Account class
    // Note the difference if you are sorting on primitives versus objects
    public int compareTo(Insurance ins)
    {
        // you get to write this!!
        if (this.policyNumber > ins.getPolicyNumber()) {
            return 1;
        }
        else if (this.policyNumber < ins.getPolicyNumber()) {
            return -1;
        }
        return 0;
    }

    // toString method.  Note - we let the customer write themself out since they have their own toString method
    // a class should only write out their fields in the toString method
    public String toString () {
        return (customer.toString() + " policy number " + policyNumber + " has a yearly rate of " + currency.format(yearlyRate));
    }

    // getters and setters
    public Customer getCustomer() {
        return customer;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
