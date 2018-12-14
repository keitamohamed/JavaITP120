package com.keita.module5.rentalblueprint;

public class Rental {
    private int numDay;
    private double rentalCost;
    private char discount;
    private Customer cust;
    private Auto auto;

    public final double COST_PER_DAY = 15;

    public Rental(){
    }

    public Rental(Customer c, Auto a, int n){
        this.cust = c;
        this.auto = a;
        this.numDay = n;
    }

    public double totalCost(Customer cust, int numDay) {
        double discount, total;

        if (numDay >= 0 && cust.isGoldMember()) {
            discount = ((COST_PER_DAY * numDay) * .25);
            total = (COST_PER_DAY * numDay) - discount;
        }
        else if (numDay >= 6 && !cust.isGoldMember()) {
            discount = ((COST_PER_DAY * numDay) * .15);
            total = (COST_PER_DAY * numDay) - discount;
        }
        else {
            total = (COST_PER_DAY * numDay);
        }
        return total;
    }


    @Override
    public String toString() {
        return cust.toString() + " rented a " + auto.toString() + " for " +
                "" + numDay + " days";
    }

    public int getNumDay() {
        return numDay;
    }

    public void setNumDay(int numDay) {

        this.numDay = numDay;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
}
