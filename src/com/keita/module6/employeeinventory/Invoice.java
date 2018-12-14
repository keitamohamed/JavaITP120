package com.keita.module6.employeeinventory;

public class Invoice implements Calculable{
    private int num;
    private double costEach;
    private Inventory inventory;

    public Invoice(Inventory inv, int n, double cost) {
        this.num = n;
        this.costEach = cost;
        this.inventory = inv;

    }

    @Override
    public double calcAmount() {
        return (num * costEach);
    }
}
