package com.module6.employeeinventory;

import java.text.NumberFormat;

public class AdminAsst extends Employee {
    private double hrlyWage;

    public AdminAsst(int empid, String name, double amount) {
        super(empid, name);
        this.hrlyWage = amount;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return super.toString() +  " make " + nf.format(hrlyWage) + " per hour\n" +
                "and for a total year earning of " + nf.format(calcAmount());
    }

    @Override
    public double calcAmount() {
        return (((this.hrlyWage * 40) * 4) * 12);
    }

    public double getHrlyWage() {
        return hrlyWage;
    }

    public void setHrlyWage(double hrlyWage) {
        this.hrlyWage = hrlyWage;
    }
}
