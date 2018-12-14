package com.keita.module6.employeeinventory;

import java.text.NumberFormat;

public class Director extends YearlyEmployee {
    private double yearlyBonus;

    public Director(int empid, String name, double salary, double bonus) {
        super(empid, name, salary);
        this.yearlyBonus = bonus;
    }

    public double calcAmount() {
        return super.calcAmount() + yearlyBonus;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return super.toString() + nf.format(yearlyBonus) + " in bonus. " +
                "Total year earning is " + nf.format(calcAmount()) + "\n";
    }

}
