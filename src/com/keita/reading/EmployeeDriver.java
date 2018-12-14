package com.keita.reading;

import com.keita.reading.employee.blueprint.Employee;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDriver {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        file(employees);
        printEmployee(employees);
    }

    private static void file(List<Employee> employees) {
        BufferedReader reader = null;
        Frame frame = new Frame();
        FileDialog fobox = new FileDialog(frame, "Read File", FileDialog.LOAD);
        fobox.setVisible(true);
        String fName = fobox.getFile();
        String path = fobox.getDirectory();
        String p = fName + path;

        try {
            File file = new File(path + fName);
            //File file = new File("Employee.txt");
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();

            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (count == 0) {
                    count++;
                    continue;
                }

                String[] date = line.split(",");
                for (String a : date)
                    System.out.println(a);
                System.out.println("Value " + date[1]);

                //Employee employee = new Employee(date[1].trim(), Integer.parseInt(date[0].trim()), Double.parseDouble(date[2].trim()));
                //employees.add(employee);
            }
        } catch (FileNotFoundException f) {
            System.out.println("File not found. " + f.getMessage());
        }
        catch (NullPointerException nop) {
            System.out.println("File location not found");
        }
        catch (IOException e) {
            System.out.println("Couldn't read file. ");
        }
        finally {
            try {
                reader.close();
            }
            catch (IOException e) {
                System.out.println("Could read file. ");
            }
        }
    }

    private static void printEmployee(List<Employee> employees) {
        if (employees.size() > 0) {
            for (Employee emp : employees) {
                System.out.println(emp.toString());
            }
        }
    }
}
