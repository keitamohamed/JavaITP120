package com.keita.module6.insurance;

import java.text.NumberFormat;

public class ArtInsurance extends Insurance{

    // ArtInsurance should have new fields of String description (describes the
    // art work) and double value (the value of the art work that you are
    // insuring).
    private String description;
    private double value;

    // full constructor - but since the full constructor for the Insurance class
    // sets customer, we pass it to that constructor.
    // super = "class above me"
    public ArtInsurance(Customer cust, String desc, double val) {
        super(cust);
        description = desc;
        value = val;
        calcRate();
    }

    // empty constructor
    public ArtInsurance() {
    }

    // constructor for reading from a file
    public ArtInsurance(Customer cust, int polNum, double yrRate, String dsc,
                        double valu) {
        super(cust, polNum, yrRate);
        description = dsc;
        value = valu;

    }

    // we were required to write a complete calcRate method by the abstract
    // method in the
    // Insurance class. Must have the exact same signature
    public void calcRate() {
        yearlyRate = 500 * value;
    }

    // we override the toString method from the Insurance class
    public String toString() {
        // NOTE TO MOHAMMED: IS THIS NECESSARY? (next line)
        // String ans = super.toString();
        // print out the toString method from my super (ie the Insurance class)
        // add on the info for this class
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return super.toString()
                + (" for auto insurance.  The type of art is " + description
                + " valued at " + nf.format(value) + ".");

    }


    // getters and setters - only for the fields added by this class

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
