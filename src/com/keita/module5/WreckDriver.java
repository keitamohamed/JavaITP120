package com.keita.module5;

import com.keita.module5.rentalblueprint.Auto;
import com.keita.module5.rentalblueprint.Customer;
import com.keita.module5.rentalblueprint.Rental;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class WreckDriver {

    static Scanner scan = new Scanner(System.in);
    static NumberFormat nf = NumberFormat.getCurrencyInstance();

    public static void main(String[] args){

        ArrayList<Customer> cust = new ArrayList<Customer>();
        ArrayList<Rental> rent = new ArrayList<Rental>();
        ArrayList<Auto> auto = new ArrayList<Auto>();

        boolean more = false;

        loadNewData(auto, cust);
        // load the data
        while (!more) {

            customer(cust);

            System.out.println("\nWhich customer? ");
            int choseCust = scan.nextInt();

            Customer customer = cust.get(choseCust - 1);

            if (customer.isGoldMember()) {
                System.out.println("This customer is a gold card member so we will treat him well!\n");
            }
            else {
                System.out.println("This customer is not a gold card member\n");
            }

            showCars(auto);

            System.out.println("\nWhich auto?");
            int choseCar = scan.nextInt();

            Auto car = auto.get(choseCar - 1);

            System.out.println("How many days do you wish to have this beautiful vehicle? ");
            int numDay = scan.nextInt();

            Rental rental = new Rental(customer, car, numDay);

            System.out.println("\n" +rental.toString() + "\n");

            if (customer.isGoldMember() && numDay > 6) {
                System.out.println("This person was both a gold card member and rented over\nsix days and received a a 25% discount\n");
            }
            else if (numDay > 6) {
                System.out.println("This person rented over six days and received a 15% discount\n");
            }
            else {
                System.out.println("This person was a gold card member and received a 10% discount\n");
            }

            System.out.println("The cost was: " + nf.format(rental.totalCost(customer, numDay)) + "\n");
            rent.add(rental);

            scan.nextLine();

        }

    }

    public static void loadNewData(ArrayList<Auto> a, ArrayList<Customer> c)
    {
        a.add(new Auto(2009,"Ford" , "Mustang","ABC123", 1256.54));
        a.add(new Auto(2010,"Chevy","Camero","QWI459", 33.98));
        a.add(new Auto(1970,"Pink","Cadillac","950AKH", 212874.51));
        a.add(new Auto(2007,"Lotus","Elise MkII","1A2D3F", 12859.90));

        c.add(new Customer( "Brett Farve",false));
        c.add(new Customer( "Bruce Springsteen",true));
        c.add(new Customer( "Mickey Mouse", true));
        c.add(new Customer( "Peyton Manning", true));
        c.add(new Customer( "Donald Duck", true));
    }

    private static void customer (ArrayList<Customer> cust) {
        int counter = 0;
        System.out.println("These are the list of customer\n".toUpperCase() +
                "==============================");
        for (Customer c : cust) {
            System.out.println((counter + 1)+ ". " + c.toString());
            counter++;
        }
    }

    //Prints the cars that are available for rent
    public static void showCars(ArrayList<Auto> a) {
        int counter = 0;

        System.out.println("\nThe following cars are available for rent!!!\n".toUpperCase() +
                "============================================");
        for (Auto auto : a) {
            System.out.println((counter + 1) + ". " + auto.toString());
            counter++;
        }

    }

    // prints all the rentals that have been made
    public static void printRentals(ArrayList<Rental> rents) {

    }
}
