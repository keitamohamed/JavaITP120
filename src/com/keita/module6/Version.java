package com.module6;

import com.module6.employeeinventory.Methods;

import java.util.Scanner;

public class Version {
    private static Scanner sc = new Scanner(System.in);
    private static int choice;

    public static void main(String[] args) {
        Methods methods = new Methods();
        boolean runProgram = true;

        while (runProgram){
            choice = mainMenu();
            sc.nextLine();

            switch (choice) {
                case 0:
                    runProgram = false;
                    break;
                case 1:
                    methods.isNewNewEmployeeAdded();
                    break;
                case 2:
                    break;
                case 3:
                    methods.printAllEmployee();
                    break;
                case 4:
                    methods.printDirector();
                    break;
                case 5:
                    break;
                case 6:
                    findEmployee(methods);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private static int mainMenu() {
        System.out.println("WELCOME TO EMPLOYEE MANAGEMENT AND INVENTORY CENTER\n" +
                "=====================================\n" +
                "0. End program\n" +
                "1. Add new Employee\n" +
                "2. Delete employee\n" +
                "3. Print all employees\n" +
                "4. Print all director\n" +
                "5. Print employees by department\n" +
                "6. Search for employee\n" +
                "7. Update employee Info");
        choice = sc.nextInt();
        return choice;
    }

    private static void findEmployee(Methods methods) {
        System.out.println("Search For Employee By:\n" +
                "====================\n" +
                "1. Name\n" +
                "2. ID number");
        choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter employee full name: ");
                String name = sc.nextLine();
                methods.isEmployeeExist(name);
                break;
            case 2:
                System.out.println("Enter employee id: ");
                int empID = sc.nextInt();
                sc.nextLine();
                methods.isEmployeeExist(empID);
                break;
            default:
                System.out.println("Invalid input");
        }
    }
}
