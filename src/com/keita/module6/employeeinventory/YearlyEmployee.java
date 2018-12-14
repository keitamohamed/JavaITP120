package com.module6.employeeinventory;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YearlyEmployee extends Employee {
    Scanner sc = new Scanner(System.in);

    private double yearlySalary;
    private List<Director> directors = new ArrayList<>() ;

    public YearlyEmployee() {

    }

    public YearlyEmployee(int empid, String name, double ySalary) {
        super(empid, name);
        this.yearlySalary = ySalary;
    }

    public boolean isAdded(int empid, String name, double ySalary) {
        System.out.println("Enter employee bonus: ");
        double bonus = sc.nextDouble();
        sc.nextLine();
        addNewDirector(empid, name, ySalary, bonus);
        return true;
    }

    private boolean addNewDirector(int id, String name, double ySalary, double bonus) {
        directors.add(new Director(id, name, ySalary, bonus));
        return true;
    }

    public void printAllDirector() {
        for (Director director : directors) {
            System.out.println(director.toString());
        }
    }

    public boolean isEmployeeDirector(String name) {
        Director director = findDirector(name);
        if (director != null) {
            System.out.println(director.toString());
            return true;
        }
        return false;
    }

    public boolean isEmployeeDirector(int empID) {
        Director director = findDirector(empID);
        if (director != null) {
            System.out.println(director.toString());
            return true;
        }
        return false;
    }

    private Director findDirector(String name) {
        if (directors.size() > 0) {
            for (int i = 0; i < directors.size(); i++) {
                Director director = directors.get(i);
                if (director.getName().equalsIgnoreCase(name)) {
                    return director;
                }
            }
        }
        return null;
    }

    private Director findDirector(int empID) {
        if (directors.size() > 0) {
            for (int i = 0; i < directors.size(); i++) {
                Director director = directors.get(i);
                if (director.getEmpid() == empID) {
                    return director;
                }
            }
        }
        return null;
    }

    @Override
    public double calcAmount() {
        return yearlySalary;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return super.toString() + ", make " + nf.format(yearlySalary) + " in yearly salary.\n";
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }
}
