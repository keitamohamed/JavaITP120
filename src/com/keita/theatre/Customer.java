package com.keita.theatre;

import java.text.NumberFormat;

public class Customer {
    private String name;
    private int numAdult;
    private int numKid;
    private double price;


    public Customer (){}
    public Customer(String n, int a, int  k, double p){
        this.name = n;
        this.numAdult = a;
        this.numKid = k;
        this.price = p;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "Name: " + name + "\nNumber Adult: " + numAdult + "\nNumber Kid: " + numKid +
                "\nPrice: " + nf.format(price);
    }

    public String toStringT(){
        return name + "\t\t\t" + numAdult + "\t\t\t" + numKid + "\t\t" + price;
    }

    public String getName() {
        return name;
    }

    public int getNumAdult() {
        return numAdult;
    }

    public int getNumKid() {
        return numKid;
    }

    public double getPrice() {
        return price;
    }
}
