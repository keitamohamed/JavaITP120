package com.module5;

import java.util.Scanner;

public class DandSalaryArray {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        System.out.println("How many Band Boosters are there?");
        int num = scan.nextInt();

        // define an array of BandBoosters that is this exact size
        BandBooster[] bb = new BandBooster[num];
        scan.nextLine();
        //loop through and get the information
        for (int i=0;i<bb.length;i++)
        {
            System.out.println("Name of Band Booster number " + (i+1));
            String n = scan.nextLine();
            //create a BandBooster instance
            BandBooster b = new BandBooster(n);
            //add it to the array
            bb[i] = b;
        }

        System.out.println("How many weeks of sales?");
        int numWks = scan.nextInt();

        for (int i=0;i<bb.length;i++)
        {
            for (int j=0;j<numWks;j++)
            {
                System.out.println("How many boxes did " + bb[i].getName() + " sell for week number " + (j+1));
                int numBoxes = scan.nextInt();
                bb[i].updateSales(numBoxes);
            }  // end of sales for this band booster

        }

        //NOTE: when passing a reference array as an argument, you do not indicate the size
        printBoosters(bb);

        showTotalSales(bb);

    }

    //NOTE: when using a reference array as a parameter, use the [ ] but not the actual size
    public static void printBoosters(BandBooster[] bands) {

        for (int i=0;i<bands.length;i++)
        {

            //toString
            System.out.println(bands[i].toString());
        }
    }

    public static void showTotalSales(BandBooster[] bands){
        int totalSales=0;
        System.out.println("\n\nSumamry of sales:");
        for (int i=0;i<bands.length;i++) {
            System.out.println (bands[i].getName()+ " sold "+ bands[i].getBoxesSold()+ " boxes");
            totalSales = totalSales +bands[i].getBoxesSold();
        }
        System.out.println("Total number of boxes sold: " + totalSales);

    }
}
