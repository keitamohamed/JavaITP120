package com.keita.module6.insurance;

public class LifeInsurance extends Insurance {
    // declare two new fields added - the amount of insurance
    // they want (amount - an integer) and their age (age - an integer )
    private int amount;
    private int age;

    // empty constructor
    public LifeInsurance () {
    }


    // full constructor. Let super (Insurance) set any fields that really came from there.
    // Make certain to also set the rate
    public LifeInsurance (Customer cust,int amtIns, int custAge) {
        // you code the body
        super(cust);
        this.amount = amtIns;
        this.age = custAge;
    }

    // full constructor if reading from a file
    public LifeInsurance (Customer cust, int polNum, double yrRate, int amtIns, int custAge)
    {
        // you code this

    }

    // required to write this if this class is to be a real class - fulfills the abstract requirements
    public  void calcRate()
    {
        if (age > 40)
            yearlyRate = amount*.005*2;
        else
            yearlyRate = amount*.005;
    }

    // to String.  Let the Insurance class print out its fields and let this class print out new fields
//	we override the toString method from the Insurance class
    public String toString () {
        // you code the body
        return super.toString() + "  has an insurance amount of " + amount
                + " which is determined by the customer's age which is " + age
                + " years old.";
    }



    // generate the getters and setters
}
