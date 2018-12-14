package com.theatre;

import java.awt.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

public class Theatre {
    private Scanner sc = new Scanner(System.in);
    private NumberFormat nf = NumberFormat.getCurrencyInstance();
    private List<Customer> customers;
    private WriteExcelFile excelFile;
    private String[][] seats;

    Theatre (){
        customers = new ArrayList<>();
        seats = new String[0][0];
        excelFile = new WriteExcelFile();
    }

    void ticketDetail(){
        if (isDataLoaded()) {
            System.out.println("Data Is Not Loaded. Please Load Data First: ");
            return;
        }
        int availableSeat = 0;
        double tAvailableSeatPrice = 0;

        System.out.println("\nTheatre Ticket Detail\n" +
                "=======================");
        for (String[] seat : seats) {
            for (String aSeat : seat) {
                if (aSeat != null && !aSeat.equals("X")) {
                    availableSeat++;
                    tAvailableSeatPrice += Double.parseDouble(aSeat);
                }
            }
        }

        System.out.println("Total Available Seat: " + availableSeat + "\n" +
                "Price If All Sold: " + nf.format(tAvailableSeatPrice) + "\n");

    }

    int sellTicket() {
        if (isDataLoaded()) {
            System.out.println("Data Is Not Loaded. Please Load Data First: ");
            return -1;
        }
        customerDetail();
        return 0;
    }

    void printTheatreSeat(){
        if (isDataLoaded()) {
            System.out.println("Data Is Not Loaded. Please Load Data First: ");
            return;
        }
        System.out.println();
        System.out.println("\t\t| THEATRE SEAT LAYOUT DETAIL: |\n" +
                "\t\t ----------------------------- ");
        for (int r = 0; r < seats[0].length; r++) {
            if (r == 0)
                System.out.print("Row:\t  |");
            System.out.print("\t" + (r + 1) + "\t");
        }
        System.out.println("\n_____________________________________________" +
                "___________________________________");
        for (int i = 0; i < seats.length; i++) {
            for (int r = 0; r < seats[i].length; r++) {
                if (r == 0) {
                    System.out.print("Column " + (i + 1) + ": |\t" + seats[i][r] + "\t|");
                    continue;
                }
                if (seats[i][r] == null) {
                    System.out.print("\tX\t|");
                    continue;
                }
                System.out.print("\t" + seats[i][r] + "\t|");
            }
            System.out.println("\n----------------------------------" +
                    "----------------------------------------------");
        }
        System.out.println();
    }

    void loadData(File file){
        seats = reSizeArray(file);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();

            int column = 0;
            while (line != null) {
                int count = 0;
                String[] split = line.split("\\s+");
                while (count < split.length) {
                    if (split[count].equals("-1")) {
                        seats[column][count] = "X";
                    }
                    else {
                        seats[column][count] = split[count];
                    }
                    count++;
                }
                column++;
                line = in.readLine();
            }
            System.out.println("Data Have Been Successfully Loaded\n");
        }
        catch (IOException io) {
            System.out.println(io.getMessage());
        } finally
        {
            try {
                assert in != null;
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    void writeFile(int choice) {
        if (customers.size() == 0) {
            System.out.println("No Data To Write!!!\n");
        }else {
            if (choice == 1) {
                System.out.println("Which Data Will You Writing:\n" +
                        "---------------------\n" +
                        "1. Theatre Seat File\n" +
                        "2. Ticket Sale Record\n" +
                        "Chose one: ");
                choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1)
                    writeSeatTextFile();
                else
                    writeSaleRecordTextFile();
            }else
                excelFile.createFile(customers);
        }
    }

    private void writeSeatTextFile() {

        if (isDataLoaded()) {
            System.out.println("There a No Data To Write.\n");
            return;
        }

        BufferedWriter writer = null;
        try {
            File file = new File(file("Save Seats Record To File") + ".txt");
            writer = new BufferedWriter(new FileWriter(file));

            for (String[] row : seats) {
                for (String seat : row){
                    if (seat.equals("X")) {
                        writer.write("-1" + "\t");
                        continue;
                    }
                    writer.write(seat + "\t");
                }
                writer.newLine();
            }

        }catch (IOException io) {
            System.out.println(io.getMessage());
        }
        finally
        {
            try {
                assert writer != null;
                writer.close();
                System.out.println("\nSuccessfully Save To A File!!!\n");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void writeSaleRecordTextFile() {

        if (customers.size() == 0) {
            System.out.println("There a No Data To Write.\n");
            return;
        }

        BufferedWriter writer = null;
        try {
            File file = new File(file("Save Sale Record File") + ".txt");
            writer = new BufferedWriter(new FileWriter(file));
            String header = "Name\t\t\tNumber Of Adult\t\tNumber Of Kid\t\tPrice\n" +
                    "-------------------------------------------------------------" +
                    "-----------------";
            writer.write(header);
            writer.newLine();

            for (Customer customer : customers) {
                writer.write(customer.toStringT() + "\t");
                writer.newLine();
            }

        }catch (IOException io) {
            System.out.println(io.getMessage());
        }
        finally
        {
            try {
                assert writer != null;
                writer.close();
                System.out.println("\nSale Record Have Been Successfully Save To A File!!!\n");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String[][] reSizeArray(File file){
        BufferedReader in = null;
        String[][] ticket = null;

        try {
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();

            int row = 0; int column = 0;
            while (line != null) {
                String[] split = line.split("\\s+");

                if (row < split.length) {
                    row = split.length;
                }
                column++;

                line = in.readLine();
            }
            ticket = new String[column][row];

            for (int i = 0; i < ticket.length; i++) {
                for (int j = 0; j < ticket[i].length; j++)
                    ticket[i][j] = "X";
            }
        }
        catch (IOException io) {
            System.out.println(io.getMessage());
        } finally
        {
            try {
                assert in != null;
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return ticket;
    }

    private void customerDetail() {
        System.out.println("Enter customer full name: ");
        String name = sc.nextLine();
        System.out.println("Enter number of adult: ");
        int numAdult = sc.nextInt();
        System.out.println("Enter number of kids: ");
        int numKids = sc.nextInt();

        double price = kidTicketPrice(numKids);
        for (int i = 0; i < numAdult; i++) {
            printTheatreSeat();
            System.out.println("Pick A Seat For Adult #: " + (i + 1) +
                    " \nEnter row number: ");
            int row = sc.nextInt();
            System.out.println("Enter Column number: ");
            int column = sc.nextInt();

            while (isSeatTaken(seats, column, row)) {
                System.out.println("\nSeat Not Available. Chose a seat without 'X, A or K'.\n" +
                        "Enter row number: ");
                row = sc.nextInt();
                System.out.println("Enter column number: ");
                column = sc.nextInt();
                printTheatreSeat();
            }
            price += Double.parseDouble(seats[column - 1][row - 1]);
            seats[column - 1][row - 1] = "A";

        }
        sc.nextLine();
        Customer customer = new Customer(name, numAdult, numKids, price);
        customers.add(customer);
        System.out.println("\nCustomer Detail:\n" +
                "---------------------\n" +
                customer.toString());
    }

    private double kidTicketPrice(int numKid){
        double price = 0;
        for (int i = 0; i < numKid; i++) {
            printTheatreSeat();
            System.out.println("Pick A Seat For Kids #: " + (i + 1) +
                    " \nEnter row number: ");
            int row = sc.nextInt();
            System.out.println("Enter Column number: ");
            int column = sc.nextInt();

            while (isSeatTaken(seats, column, row)) {
                System.out.println("Not Available. Chose a seat without 'X, A or K'.\n" +
                        "Enter row number: ");
                row = sc.nextInt();
                System.out.println("Enter column number: ");
                column = sc.nextInt();
            }
            price += 8.5;
            seats[column - 1][row - 1] = "K";
        }
        System.out.println("Kids Ticket Price: " + nf.format(price));
        return price;
    }

    int validInput(int menu) {
        int choice = menu;
        while (choice <= 0 || choice > 7) {
            System.out.println("\nInvalid Choice. Pick A Choice From 1 - 7\n");
            choice = menu;
        }
        return choice;
    }

    private File file(String title) {
        Frame f = new Frame();

        FileDialog foBox = new FileDialog(f, title, FileDialog.SAVE);
        foBox.setVisible(true);

        String foName = foBox.getFile();
        String dirPath = foBox.getDirectory();

        return new File(dirPath + foName);
    }

    private boolean isSeatTaken(String[][] seat, int column, int row){
        return seat[column - 1][row - 1].equals("X") ||
                seat[column - 1][row - 1].equals("K") ||
                seat[column - 1][row - 1].equals("A");

    }

    private boolean isDataLoaded(){
        return seats.length == 0;
    }
}
