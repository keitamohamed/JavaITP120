package com.keita.module5.drinkblueprint;

import java.text.NumberFormat;

public class Drinks {
    private String drinkType;
    private char size;
    private double costEach;
    private int numOrder;

    public Drinks() {

    }

    public Drinks(String d, char s, double c, int n) {
        this.drinkType = d;
        this.size = s;
        this.costEach = c;
        this.numOrder = n;
    }

    public double total() {
        return calculateTotal();
    }

    private double calculateTotal() {
        return (costEach * numOrder);
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "You ordered " + numOrder + " " + size + " " + drinkType + " " +
                "at " + nf.format(costEach) + " for each drink. " +
                "The total cost was " + nf.format(calculateTotal());
    }

    public String getDrinkType() {
        return drinkType;
    }

    public char getSize() {
        return size;
    }

    public double getCostEach() {
        return costEach;
    }

    public int getNumOrder() {
        return numOrder;
    }
}
