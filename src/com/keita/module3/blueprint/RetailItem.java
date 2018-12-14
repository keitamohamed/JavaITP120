package com.keita.module3.blueprint;

import java.text.NumberFormat;

public class RetailItem {
    NumberFormat format = NumberFormat.getCurrencyInstance();
    private String description;
    private int unitsOnHand;
    private double price;

    public RetailItem() {

    }

    public RetailItem(String d, int unit, double p) {
        this.description = d;
        this.unitsOnHand = unit;
        this.price = p;
    }

    @Override
    public String toString() {
        return "The inventory currently had " + unitsOnHand + " " +
                "" + description + " which cost " + format.format(price) + " for each units\n" +
                "for a total of " + format.format((unitsOnHand * price));
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnitsOnHand() {
        return unitsOnHand;
    }

    public void setUnitsOnHand(int unitsOnHand) {
        this.unitsOnHand = unitsOnHand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
