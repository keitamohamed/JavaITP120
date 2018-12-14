package com.keita.module4.vacation.blueprint;

import java.text.NumberFormat;

public class Vacation {
    private String vacationName;
    private int numSold;
    private double priceEach;

    public Vacation(){};

    public Vacation(String vacationName, double priceEach) {
        this.vacationName = vacationName;
        this.priceEach = priceEach;
    }

    public int updateSales(int numSold) {
        return (this.numSold += numSold);
    }

    public double totalValue() {
        return (numSold * priceEach);
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return numSold + " trips were made from " + vacationName + " for " +
                "" + nf.format(priceEach) + " pre trip,\nfor a total cost of "+ nf.format(totalValue());
    }

    public String getVacationName() {
        return vacationName;
    }

    public int getNumSold() {
        return numSold;
    }

    public double getPriceEach() {
        return priceEach;
    }
}
