package com.keita.module4.nursery.blueprint;

import java.text.NumberFormat;

public class Inventory {
    private int inventoryID;
    private String name;
    private int numInStock;
    private double costEach;
    private Supplier supplier;

    static int nextNumber = 1000;

    public Inventory(){}

    public Inventory(String itemName, int numInStock, double costEach,
                     Supplier supply) {
        supplier = supply;
        this.inventoryID = nextNumber;
        this.name = itemName;
        this.numInStock = numInStock;
        this.costEach = costEach;

        nextNumber++;
    }

    public double calculatePrice() {
        return (costEach * numInStock);
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return name + " with an id number of " + inventoryID + ", has " + numInStock + " item in " +
                "stock cost " + nf.format(costEach) + " pre each,\nfor a " +
                "total value of " + nf.format(calculatePrice());
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public String getName() {
        return name;
    }

    public int getNumInStock() {
        return numInStock;
    }

    public double getCostEach() {
        return costEach;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
