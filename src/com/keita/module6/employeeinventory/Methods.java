package com.keita.module6.employeeinventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {
    private Scanner sc = new Scanner(System.in);
    private int choice;
    private List<Employee> employees;
    private YearlyEmployee yearlyEmployee;

    public Methods() {
        employees = new ArrayList<>();
        yearlyEmployee = new YearlyEmployee();
    }

    public void printAllEmployee(){
        if (employees.size() > 0) {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        }
        System.out.println();
    }

    public void printDirector() {
        yearlyEmployee.printAllDirector();
    }

    public void printEmployeeByClass() {
        if (employees.size() > 0) {
            employees.getClass().getSimpleName();
        }
    }

    public boolean isNewNewEmployeeAdded() {
        System.out.println("Enter employee name: ");
        String name = sc.nextLine();
        System.out.println("Enter employee id number: ");
        int empId = sc.nextInt();
        sc.nextLine();

        Employee employee = getEmployee(empId);
        if (employee != null) {
            System.out.println("Sorry could add employee because there is an employee name\n" +
                    "" + employee.getName() + " using this id number " + employee.getEmpid());
            return false;
        }
        choice = employeeType();
        sc.nextLine();
        addNewEmployee(empId, name, choice);
        return true;
    }

    public boolean isEmployeeExist(String name) {
        Employee employee = searchForEmployee(name);
        if (employee == null) {
            System.out.println("The name you enter, " + name + " is not in the list");
            return false;
        }
        boolean isNotDirector = yearlyEmployee.isEmployeeDirector(name);
        if (!isNotDirector) {
            System.out.println(employee.toString());
        }
        return true;
    }

    public boolean isEmployeeExist(int empID) {
        Employee employee = searchForEmployee(empID);
        if (employee == null) {
            System.out.println("This id number, " + empID + " is not in the list");
            return false;
        }
        boolean isNotDirector = yearlyEmployee.isEmployeeDirector(empID);
        if (!isNotDirector) {
            System.out.println(employee.toString());
        }
        return true;
    }

    private Employee getEmployee(int empID) {
        if (employees.size() > 0) {
            for (Employee emp : employees) {
                if (emp.getEmpid() == empID) {
                    return emp;
                }
            }
        }
        return null;
    }

    private int employeeType() {
        System.out.println("Select Type Of Employee:\n" +
                "1. Admin Asst\n" +
                "2. Yearly Employee");
        choice = sc.nextInt();
        return choice;
    }

    private void addNewEmployee(int id, String name, int choice) {
        switch (choice) {
            case 1:
                System.out.println("Enter hourly wage: ");
                double hourWage = sc.nextDouble();
                sc.nextLine();
                addNewAdminAsst(id, name, hourWage);
                break;
            case 2:
                System.out.println("Enter yearly salary: ");
                double ySalary = sc.nextDouble();
                sc.nextLine();
                addYearlyEmployee(id, name, ySalary);
                System.out.println("Is this employee is a director (Yes or No)? ");
                String yesNo = sc.nextLine();
                if (yesNo.equalsIgnoreCase("Yes")) {
                    yearlyEmployee.isAdded(id, name, ySalary);
                }
        }
    }

    private Employee searchForEmployee(String name) {
        if (employeeSize() > 0) {
            for (int i = 0; i < employeeSize(); i++) {
                Employee employee = employees.get(i);
                if (employee.getName().equalsIgnoreCase(name)) {
                    return employee;
                }
            }
        }
        return null;
    }

    private Employee searchForEmployee(int empID) {
        if (employeeSize() > 0) {
            for (int i = 0; i < employeeSize(); i++) {
                Employee employee = employees.get(i);
                if (employee.getEmpid() == empID) {
                    return employee;
                }
            }
        }
        return null;
    }

    private void addYearlyEmployee(int id, String name, double salary) {
        employees.add(new YearlyEmployee(id, name, salary));
    }

    private void addNewAdminAsst(int id, String name, double hrlyWage) {
        employees.add(new AdminAsst(id, name, hrlyWage));
    }

    private int employeeSize() {
        return employees.size();
    }

}
