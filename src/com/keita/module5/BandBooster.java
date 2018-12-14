package com.keita.module5;

public class BandBooster {
    //fields
    private String name;
    private int boxesSold;


    //empty constructor
    public BandBooster()
    {

    }

    public BandBooster( String n)
    {
        name = n;
        boxesSold = 0;
    }

    //toString

    public String toString()
    {
        return( name + ": " + boxesSold + " boxes"  );
    }

    //other methods

    public int updateSales(int newNum)
    {
        return boxesSold = boxesSold + newNum;
    }


    //getters and setters.
    public int getBoxesSold() {
        return boxesSold;
    }

    public void setBoxesSold(int boxesSold) {
        this.boxesSold = boxesSold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
