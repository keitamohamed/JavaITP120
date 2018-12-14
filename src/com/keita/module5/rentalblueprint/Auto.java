package com.keita.module5.rentalblueprint;

public class Auto {
    private int year;
    private String make;
    private String model;
    private String vin;
    private double miles;

    public Auto() {
    }

    public Auto(int y, String m, String mo, String v, double mi) {
        this.year = y;
        this.make = m;
        this.model = mo;
        this.vin = v;
        this.miles = mi;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model + "\nwith a VIN# of " + vin +
                " and a miles of " + miles;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }
}
