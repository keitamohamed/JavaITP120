package com.module6.employeeinventory;

import java.io.Serializable;

public abstract class Employee implements Calculable, Serializable {
    private int empid;
    private String name;

    public Employee(){ }

    public Employee(int empid, String n) {
        this.empid = empid;
        this.name = n;
    }

    @Override
    public double calcAmount() {
        return 0;
    }

    @Override
    public String toString() {
        return "Employee name: " + name + ", id number " + empid;
    }

    public int compareTo(Employee empID, Employee empID2) {
        return empID.empid - empID2.empid;

    }

    public int getEmpid() {
        return empid;
    }

    public String getName() {
        return name;
    }
}
