package com.finalproject;

import java.awt.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuInfo {

    private static Scanner scan = new Scanner(System.in);
    private static NumberFormat nf = NumberFormat.getCurrencyInstance();

    public List<Stock> loadStock() {
        ArrayList<Stock> stock = new ArrayList<>();
        stock.add(new Stock("IBM", 200, 134.25, 121.15, "International Business Machines"));
        stock.add(new Stock("AAPL", 130, 180.45, 246.00, "Apple, Inc"));
        stock.add(new Stock("GOOG", 450, 610.00, 434.46, "Google, Inc"));
        stock.add(new Stock("MOT", 5000, 8.28, 6.24, "Motorola, Inc."));
        stock.add(new Stock("F", 450, 8.2, 10.25, "Ford Motor Company"));
        stock.add(new Stock("RIMM", 500, 62.35, 48.05, "Research In Motion, Ltd."));
        stock.add(new Stock("GS", 650, 162.58, 131.58, "The Goldman Sachs Group, Inc"));
        stock.add(new Stock("HD", 560, 25.04, 27.54, "The Home Depot, Inc"));
        stock.add(new Stock("WMT", 670, 57.98, 48.23, "Wal-Mart Stores, Inc."));
        stock.add(new Stock("KR", 710, 19.10, 19.86, "The Krogers Company"));
        return stock;
    }

    public List<Stock> readSerializable() // menu item #1
    {
        // create the ArrayList
        List<Stock> stock = new ArrayList<>();

        Frame f = new Frame();
        // decide from where to read the file
        FileDialog foBox = new FileDialog(f, "Reading serialized file", FileDialog.LOAD);
        foBox.setVisible(true);
        // get the absolute path to the file
        String foName = foBox.getFile();
        String dirPath = foBox.getDirectory();
        File inFile = new File(dirPath + foName);

        // create a file instance for the absolute path
        ObjectInputStream OIS = null;
        try {
            FileInputStream IS = new FileInputStream(inFile); // create a file
            // input stream
            // for the file
            // that we chose
            OIS = new ObjectInputStream(IS); // create the object imput stream
            stock = (List<Stock>) OIS.readObject(); // note that you can

            for (Stock st : stock) {
                System.out.println(st);
            }
//            stock.forEach(e -> System.out.println(e));
            // read in the
            // entire object
            // (the array list)
            // at onc
            // now read in that extra piece of data that we wrote out and set
            // the next customer number to use

        }

        // catch any IOException that occurs
        catch (IOException io) {
            io.printStackTrace(); // great for debugging!
            System.out.println("An IO Exception occurred");
        }
        // note that you can also have a class not found exception.
        catch (ClassNotFoundException cnf) {
            cnf.printStackTrace(); // great for debugging!
            System.out.println("An IO Exception occurred");
        } finally // finally always runs no matter what so close the file here!
        {
            // close the file. Java is neurotic - it worried "but what if it is
            // already closed?" so needs another try/catch
            try {
                OIS.close();
            } catch (Exception e) {
            } // note the {} - means "do nothing". I wanted it closed anyway.
        }
        return stock;

    }

    public void writeSerializable(List<Stock> st) // menu item #2
    {
        // create the frame for the FileDialog box
        Frame f = new Frame();
        // decide where to save the file
        FileDialog foBox = new FileDialog(f, "Saving customer file", FileDialog.SAVE);
        foBox.setVisible(true);
        // we need to get the path where the file will be stored.
        // the user will pick one from the dialog box
        // the combination of the directory name plus the file name is the
        // absolute path
        String foName = foBox.getFile();
        String dirPath = foBox.getDirectory();
        // create a File instance for that absolute path
        File outFile = new File(dirPath + foName);
        // create a PrintWriter
        FileOutputStream OS;
        ObjectOutputStream OOS = null;

        try {
            // create the FileOutputStream object
            OS = new FileOutputStream(outFile);
            // create the ObjectOutputStream object
            OOS = new ObjectOutputStream(OS); // create your output string

            OOS.writeObject(st); // write the entire array list out at once.
            // COOL!!!

            // we also want to save the next customer number
            // now print the next customer number that should be used to the
            // file also
            // need to keep track of this so that when you read the data back
            // in, you do not reuse
            // customer numbers


        }
        // catch any IOExceptions that occur
        catch (IOException io) {
            io.printStackTrace(); // shows any errors
            System.out.println("An IO Exception occurred");
        } finally // finally always runs no matter what so close the file here!
        {
            // close the file. Java is neurotic - it worried "but what if it is
            // already closed?" so needs another try/catch
            try {
                OOS.close();
            } catch (Exception e) {
            } // note the {} - means "do nothing". I wanted it closed anyway.
        }

    }


    public void total(List<Stock> st) {
        System.out.println("THESE ARE THE LIST OF ALL STOCK WITH TOTAL INVEST VALUE,\n" +
                "TOTAL CURRENT VALUE, AND LOST AND GAIN\n" +
                "=========================================================");
        double totalInvestValue = 0;
        double totalCurrentValue = 0;
        double profit = 0;

        for (int i = 0; i < st.size(); i++) {
            System.out.println("Total invested value of " + st.get(i).getDescription() + " is " +
                    "" + nf.format(st.get(i).totalInvest()) + "\n" +
                    "Total current value of " + st.get(i).getDescription() + " is " +
                    nf.format(st.get(i).totalCurrentValue()) + "\n" + "Total loss of " + st.get(i).getDescription() +
                    " is " + nf.format(st.get(i).totalGainLoss()) + "\n");
            totalInvestValue = totalInvestValue +  st.get(i).totalInvest();
            totalCurrentValue = totalCurrentValue + st.get(i).totalCurrentValue();
            profit = profit + st.get(i).totalGainLoss();
        }

        System.out.println("Overall current value: " + nf.format(totalCurrentValue) + "\n" +
                "Overall original investment value: " + nf.format(totalInvestValue) + "\n" +
                "Overall profits/losses: " + nf.format(profit) + "\n");

    }

    public void stockBelowCost(List<Stock> stock) {
        System.out.println("LIST OF STOCK BELOW THERE VALUE\n" +
                "==========================");
        for (int i = 0; i < stock.size(); i++) {
            Stock sto = stock.get(i);
            if (sto.totalGainLoss() < 0) {
                System.out.println(sto.getDescription() + " value was " + sto.totalInvest() + "" +
                        ",\nbut now it current value is " + sto.totalCurrentValue() + ".\n" +
                        sto.getDescription() + " has lost " + sto.totalGainLoss() + " in it value.\n");
            }
        }
        System.out.println();
    }

    public void print(List<Stock> st) // menu item #5
    {
        System.out.println("THESE ARE THE CURRENT STOCK:\n" +
                "=====================================");
        for (int i = 0; i < st.size(); i++) {
            System.out.println(st.get(i).toString());
        }
        System.out.println();

    }

    public void find(List<Stock> st, String itemID) {
        boolean found = false;
        int i = 0;

        while (!found && i < st.size()) {
            Stock s = st.get(i);
            if (s.getId().equalsIgnoreCase(itemID)) {
                found = true;
                System.out.println(s.toString());
                i++;
            } else
                i++;
        }
        if (!found) {
            System.out.println("There is no stock by this id: " + itemID);
        }
        System.out.println();
    }

    public void addStock(List<Stock> st) {
        System.out.println("\n1. Add more shares to existing inventory\n" +
                "2. Add a new stock (add new id) to inventory\n" +
                "3. Exit to main menu\n");
        int choice = scan.nextInt();
        scan.nextLine();

        switch (choice) {
            case 1:
                updateShares(st);
                break;
            case 2:
                menuAdd(st);
                break;
            case 3:
                break;
        }
    }

    public void deleteStock(List<Stock> st) {
        System.out.println("Enter stock id or name you would like to delete: ");
        String nameID = scan.nextLine();

        for (Stock stock : st) {
            if (stock.getId().equalsIgnoreCase(nameID) ||
                    stock.getDescription().equalsIgnoreCase(nameID)) {
                st.remove(stock);
                System.out.println(nameID + " was successful deleted from the list.");
                return;
            }
        }
    }

    public void menuAdd(List<Stock> s) {
        System.out.println("How many stock do you want to add?: ");
        int input = scan.nextInt();
        scan.nextLine();

        while (input > 0) {
            System.out.println("Enter stock id?");
            String stockID = scan.nextLine();
            System.out.println("Enter stock name: ");
            String name = scan.nextLine();
            System.out.println("Enter number of share's holder for " + name + ": ");
            int newNumShares = scan.nextInt();
            System.out.println("Enter cost for each " + name + " share's holder: ");
            double newCostEach = scan.nextDouble();
            System.out.println("Enter current value for each " + name + " share's holder: ");
            double newValue = scan.nextInt();
            s.add(new Stock(stockID, newNumShares, newCostEach, newValue, name));
            System.out.println(name + " has been added\n");
            input--;
        }

        System.out.println();
    }

    private static void updateShares(List<Stock> shares) {
        System.out.println("These are the list of current inventory:\n" +
                "====================================" );
        for (int i = 0; i < shares.size(); i++){
            System.out.println((i + 1) + ". " + shares.get(i).getId());
        }
        System.out.println("Enter id for the stock you want to update: ");
        String sID = scan.nextLine();
        System.out.println(shares.get(getIndexPosition(shares, sID)).toString());
        System.out.println("How many shares of " + sID.toUpperCase() + " would you like to add? ");
        int numShares = scan.nextInt();
        scan.nextLine();
        int getNumShare = shares.get(getIndexPosition(shares, sID)).getNumShares();
        shares.get(getIndexPosition(shares, sID)).setNumShares(getNumShare + numShares);
        System.out.println(numShares + " shares added to " + sID.toUpperCase() + "\n");

    }

    private static int getIndexPosition(List<Stock> data, String id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
}
