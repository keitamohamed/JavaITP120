package com.module5.rentalblueprint;

import java.text.NumberFormat;

public class Rental2 {
    // the Rental class has four fields

    private Customer cust;
    private Auto auto;
    private int numDays;
    private double rentalCost;
    private char discount;

    // N = none  G = gold  D = days  B = both

    // all cars rent for $15.00 per day
    final private double COST_PER_DAY = 15.00;

    // TO DO!!write an empty and a full constructor
    public Rental2 () {

    }

    public Rental2 (Customer c, Auto a, int n, double r, char d){
        this.cust = c;
        this.auto = a;
        numDays = n;
        rentalCost = r;
        discount = d;
    }

    // toString method
    //remember that each class should print out its own fields
    // so we let the Auto and Customer class print out theirs
    // this class only prints out the number of days field
    @Override
    public String toString()
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String string;
        string =  cust.toString() + " rented " ;
        string = string + auto.toString() + " for " + numDays + " days.";
        string = string + "\n   The cost was " + nf.format(rentalCost) + "\n";
        switch  (discount) {
            case 'B':
                string = string + "This person was both a gold card memeber and rented over six days and received a a 25% discount";
                break;
            case 'G':
                string = string + "This person was  a gold card memeber and received a a 10% discount";
                break;
            case 'D':
                string = string + "This person rented over six days and received a 15% discount";
                break;
            case 'N':
                string = string + "This person did not qualify for a discount";

        }

        return string;
    }

    // TO DO!!!the setRentalCost is where the cost is set
    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    //Nersa's note: this should be rentalCost minus the applicable discount from teh setDiscountCode class, how do I call it into this method?

    // give them a 15% discount if they rent over 6 days. Also Gold card members get an
    //extra 10% off the original cost regardless of the number of days
    // note next line is just a place holder. //This is included below in the discountCode method, is that right?


    //Also set the discount code [is this right?]
    public void setDiscountCode(double discountCode) {
        double noDiscount = (rentalCost * 0);
        double goldDiscount = (rentalCost * .10);
        double daysDiscount = (rentalCost * .15);
        double bothDiscount = ((rentalCost * .1) + (rentalCost * .15));
    }
}

