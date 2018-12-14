package com.reading;

import com.reading.employee.blueprint.Employee;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileChooser {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Throwable {
        List<Employee> list = new ArrayList<>();

        boolean keepAlive = true;
        while (keepAlive) {
            int choice = mainMenu();
            switch (choice) {
                case 0:
                    keepAlive = false;
                    break;
                case 1:
                    choice = readFile();
                    readFileMenu(choice, list);
                    break;
                case 2:
                    printMenu(list);
                    break;
                case 3:
                    break;
                case 4:
                    encryptingAFile(list);
                    break;
                case 5:
                    break;
                case 6:
                    garbageCollection();
                    break;
            }

        }

    }

    private static List<Employee> readFileWCommon(List<Employee> list) {
        JFileChooser chooser = new JFileChooser();
        File file;
        FileReader fReader = null;
        BufferedReader bReader;

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
                if (file.canRead() && file.exists()) {
                    fReader = new FileReader(file);
                }
            }
            bReader = new BufferedReader(fReader);

            String line;
            while ((line = bReader.readLine()) != null) {

                if (line.contains("EMPID")) {
                    continue;
                }
                String[] date = line.split(",");

                String name = date[1];
                int employeeId = Integer.parseInt(date[0]);
                double salary = Double.parseDouble(date[2]);

                Employee employee = new Employee(name, employeeId, salary);
                list.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static List<Employee> readPipeDelimitedFile(List<Employee> list) {
        JFileChooser fileChooser = new JFileChooser();
        File file;
        FileReader fReader = null;
        BufferedReader bReader;

        try {
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                if (file.canRead() && file.exists()) {
                    fReader = new FileReader(file);
                }
            }
            bReader = new BufferedReader(fReader);

            String line;
            while ((line = bReader.readLine()) != null) {

                if (line.contains("EMPID")) {
                    continue;
                }
                String[] date = line.split("\\|");

                String name = date[1];
                int employeeId = Integer.parseInt(date[0]);
                double salary = Double.parseDouble(date[2]);

                Employee employee = new Employee(name, employeeId, salary);
                list.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException p) {
            System.out.println("You didn't select a file");
        }
        return list;
    }

    private static List<Employee> fileTokenizere(List<Employee> list) {
        JFileChooser fileChooser = new JFileChooser();
        File file;
        FileReader fReader = null;
        BufferedReader bReader;
        StringTokenizer tokenizer;

        try {
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                if (file.canRead() && file.exists()) {
                    fReader = new FileReader(file);
                }
            }

            bReader = new BufferedReader(fReader);
            String line;
            while ((line = bReader.readLine()) != null) {
                if (line.contains("EMPID")) {
                    continue;
                }
                tokenizer = new StringTokenizer(line, "\\|");
                while (tokenizer.hasMoreElements()) {
                    int employeeId = Integer.parseInt(tokenizer.nextToken());
                    String name = tokenizer.nextToken();
                    double salary = Double.parseDouble(tokenizer.nextToken());
                    Employee employee = new Employee(name, employeeId, salary);
                    list.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException p) {
            System.out.println("You didn't select a file");
        }
        return list;
    }

    private static byte[] encryptingAFile(List<Employee> list) {
        byte[] empList, textEncrypted = null;

        try {
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream object = new ObjectOutputStream(byteArray);

            KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
            SecretKey myDesKey = keygenerator.generateKey();

            Cipher desCipher;
            desCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            object.writeObject(list);

//            for (Employee employee: list) {
//                object.writeObject(employee);
//            }

            empList = byteArray.toByteArray();
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey, new IvParameterSpec(new byte[16]));
            textEncrypted = desCipher.doFinal(empList);

            Files.write(Paths.get("Encrypt.txt"), textEncrypted);

            desCipher.init(Cipher.DECRYPT_MODE, myDesKey, new IvParameterSpec(new byte[16]));
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);

            ByteArrayInputStream bis = new ByteArrayInputStream(textDecrypted);
            ObjectInputStream ois = new ObjectInputStream(bis);

            List<Employee> result = (List<Employee>) ois.readObject();
            result.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return textEncrypted;
    }

    private static void printEmployee(List<Employee> employees) {
        if (employees.size() > 0) {
            System.out.println("\nLIST OF ALL EMPLOYEE\n" +
                    "==========================");
            for (Employee emp : employees) {
                System.out.println(emp.toStringF());
            }
            System.out.println();
        }
    }

    private static int mainMenu() {
        System.out.println("READ AND WRITING TO A FILE:\n" +
                "=========================\n" +
                "1. Read a file\n" +
                "2. Print file\n" +
                "3. Write to a file\n" +
                "4. Encrypt to a file\n" +
                "5. Decrypting the file\n" +
                "6. Clear data in memory\n" +
                "7. End program");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    private static void printMenu(List<Employee> list) {
        System.out.println("1. Print list of employee\n" +
                "2. Print encrypted file to console");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                printEmployee(list);
                break;
            case 2:
                break;
        }
    }

    private static int readFile() {
        System.out.println("1. Read txt file with common\n" +
                "2. Read a pipe delimited txt file\n" +
                "3. Read an excel file");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    private static int writeToAFile() {
        System.out.println("1. Write to txt file\n" +
                "2. Write to an excel file");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    private static void readFileMenu(int choice, List<Employee> list) {
        switch (choice) {
            case 1:
                readFileWCommon(list);
                break;
            case 2:
                readPipeDelimitedFile(list);
                break;
            case 3:
                break;
        }
    }

    private static void garbageCollection() throws Throwable{
        System.gc();
        System.out.println("Don collecting garbage");
    }
}
