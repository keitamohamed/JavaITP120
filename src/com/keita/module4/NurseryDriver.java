package com.keita.module4;

import com.keita.module4.nursery.blueprint.Inventory;
import com.keita.module4.nursery.blueprint.Supplier;

import java.util.Scanner;

public class NurseryDriver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter supplier id:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter supplier name: ");
        String name = sc.nextLine();
        System.out.println("Enter supplier phone number: ");
        String phoneNum = sc.nextLine();

        System.out.println("Enter number of item's to be stock?");
        int num = sc.nextInt();

        sc.nextLine();
        Supplier supplier = new Supplier(id, name, phoneNum);

        for (int i = 0; i < num; i++) {
            System.out.println("Enter name for product #" + (i + 1));
            String productName = sc.nextLine();
            System.out.println("How many " + productName + " are you adding in stock? ");
            int numItem = sc.nextInt();
            System.out.println("How much does each " + productName + " cost? ");
            double cost = sc.nextDouble();
            sc.nextLine();
            Inventory inventory = new Inventory(productName, numItem, cost, supplier);
            System.out.println(inventory.toString() + "\n");
        }
    }
}
