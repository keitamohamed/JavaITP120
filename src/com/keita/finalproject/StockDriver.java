package com.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockDriver {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Stock> stock = new ArrayList<>();

        MenuInfo mi = new MenuInfo();

        int ans;
        while (true) {
            menu();
            System.out.println("CHOICE:");
            ans = scan.nextInt();
            scan.nextLine();

            while (ans > 9) {
                menu();
                System.out.println("Invalid selection. Please select a valid\n" +
                        "value from the list: ");
                ans = scan.nextInt();
                scan.nextLine();
            }

            switch (ans) {
                case 0:
                    stock = mi.loadStock();
                    break;
                case 1:
                    stock = mi.readSerializable();
                    break;
                case 2:
                    mi.writeSerializable(stock);
                    break;
                case 3:
                    mi.total(stock);
                    break;
                case 4:
                    mi.stockBelowCost(stock);
                    break;
                case 5:
                    mi.print(stock);
                    break;
                case 6:
                    System.out.println("Enter the stock id: ");
                    String stockID = scan.nextLine();
                    mi.find(stock, stockID);
                    break;
                case 7:
                    mi.addStock(stock);
                    break;
                case 8:
                    mi.deleteStock(stock);
                    System.out.println();
                    break;
                case 9:
                    System.out.println("See you later!");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("LIST OF AN AVAILABLE MENU:\n" +
                "==========================");
        System.out.println("0. Load data");
        System.out.println("1. Read a serializable file");
        System.out.println("2. Write to a serialized file");
        System.out.println("3. List the value, amount invested, and net " +
                "gain or loss of each stock. Also total each of these");
        System.out.println("4. List all stocks currently valued below our cost");
        System.out.println("5. Print all stock information");
        System.out.println("6. Find a stock by stock id code");
        System.out.println("7. Add stock (existing or new)");
        System.out.println("8. Delete stock (existing or new)");
        System.out.println("9. Exit\n");
    }

}
