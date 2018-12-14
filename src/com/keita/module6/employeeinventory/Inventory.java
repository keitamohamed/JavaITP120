package com.keita.module6.employeeinventory;

public class Inventory implements Calculable {

    private int invNum;
    private int num;
    private double costEach;

    public Inventory(int iNum, int num, double cost) {
        this.invNum = iNum;
        this.num = num;
        this.costEach = cost;
    }

    @Override
    public double calcAmount() {
        return (num * costEach);
    }
}
