package com.module4.nursery.blueprint;

public class Supplier {

    private int supID;
    private String name;
    private String phoneNum;

    public Supplier(){}

    public Supplier(int supID, String name, String phoneNum) {
        this.supID = supID;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Supplier id: " + supID + " name " + name + " " +
                "and phone number" + phoneNum;
    }

    public int getSupID() {
        return supID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
}
