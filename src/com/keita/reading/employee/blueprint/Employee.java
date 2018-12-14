package com.reading.employee.blueprint;

import java.io.Serializable;
import java.text.NumberFormat;

public class Employee implements Serializable{
    private String name;
    private int empID;
    private double salary;

    public Employee(){}

    public Employee(String name, int empID, double salary) {
        this.name = name;
        this.empID = empID;
        this.salary = salary;
    }


    public String toStringF() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "Employee ID number is " + empID + ", name is " + name + ", salary is " + nf.format(salary);
    }

    @Override
    public String toString() {
        return empID + "|" + name + "|" + salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
