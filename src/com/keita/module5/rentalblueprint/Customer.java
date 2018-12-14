package com.keita.module5.rentalblueprint;

public class Customer {
    private int custID;
    private String fullName;
    private boolean goldMember;

    private static int nextNum = 100;

    public Customer(){

    }

    public Customer(String name) {
        this.fullName = name;
    }

    public Customer(String name, boolean goldM) {
        this.custID = nextNum;
        this.fullName = name;
        this.goldMember = goldM;

        nextNum++;
    }

    @Override
    public String toString() {
        return fullName + " (Customer ID: " + custID + ")";
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGoldMember() {
        return goldMember;
    }

    public void setGoldMember(boolean goldMember) {
        this.goldMember = goldMember;
    }

    public static int getNextNum() {
        return nextNum;
    }

    public static void setNextNum(int nextNum) {
        Customer.nextNum = nextNum;
    }
}
