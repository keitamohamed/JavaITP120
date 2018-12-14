package com.keita.finalproject;

import java.io.Serializable;
import java.text.NumberFormat;

public class Stock implements Comparable<Stock>, Serializable{
    // Fields
    private String id;
    private int numShares;
    private double costEach;
    private double currentValue;
    private String description;

    public Stock() {
        super();
    }

    public Stock(String id, int numShares, double costEach, double currentValue, String description) {
        super();
        this.id = id;
        this.numShares = numShares;
        this.costEach = costEach;
        this.currentValue = currentValue;
        this.description = description;
    }

    public double totalCurrentValue() {
        return (numShares * currentValue);
    }

    public double totalInvest(){
        return (costEach * numShares);
    }

    public double totalGainLoss(){
        return (totalCurrentValue() - totalInvest());
    }

    // toString
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return numShares + " shares of " + id + "(" + description + "). Cost per share: " + nf.format(costEach)
                + " Current value: " + nf.format(currentValue);

    }

    // Returns true if ids are equal
    public boolean equals(Stock st) {
        if (this.getId() == st.getId())
            return true;
        else
            return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumShares() {
        return numShares;
    }

    public void setNumShares(int numShares) {
        this.numShares = numShares;
    }

    public double getCostEach() {
        return costEach;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Stock stock) {

        return (stock.getId() + stock.getNumShares() + stock.getCurrentValue() + stock.getCostEach()
                + stock.getDescription())
                .compareTo(getId() + getNumShares() + getCurrentValue() + getCostEach() + getDescription());
    }

}
