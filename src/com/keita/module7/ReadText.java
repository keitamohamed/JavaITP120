package com.module7;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadText {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        List<String> quote = new ArrayList<>();
        boolean run = true;
        int choice;

        while (run) {
            choice = menu();
            scan.nextLine();

            switch (choice) {
                case 1:
                    quote = readText();
                    break;
                case 2:
                    printQuote(quote);
                    break;
                case 3:
                    quote = encryptFile(quote);
                    break;
                case 4:
                    writeToAFile(quote);
                    break;
                case 5:
                    System.gc();
                    break;
                case 6:
                    quote = readText();
                    break;
                case 7:
                    quote = decryptFile(quote);
                    break;
                case 8:
                    printQuote(quote);
                    break;
                case 9:
                    run = false;
                    System.out.println("Thank. program ended!");
                    break;
                default:
                    System.out.println("Sorry, that is not a valid option!");
            }
        }
    }

    private static int menu() {
        System.out.println(("Simple program for file management\n" +
                "=================================").toUpperCase() + "\n" +
                "1. Read in a file\n" +
                "2. Print the file to the console\n" +
                "3. Encrypt data and print to a console\n" +
                "4. Write out the encrypted file to a text file\n" +
                "5. Clear the data in memory\n" +
                "6. Read in an encrypted file\n" +
                "7. Decrypt the file\n" +
                "8. Write out the decrypted file to the console\n" +
                "9. End\n" +
                "Chose from the list: ");

        return (scan.nextInt());
    }


    private static void printQuote(List<String> quote) {
        for (String aQuote : quote) {
            System.out.println(aQuote);
        }
        System.out.println();
    }

    private static ArrayList<String> readText() {
        ArrayList<String> quote = new ArrayList<>();

        Frame f = new Frame();
        FileDialog foBox = new FileDialog(f, "Reading text file", FileDialog.LOAD);
        foBox.setVisible(true);
        String foName = foBox.getFile();
        String dirPath = foBox.getDirectory();

        File inFile = new File(dirPath + foName);
        BufferedReader in = null;
        try {

            in = new BufferedReader(new FileReader(inFile));

            String line = in.readLine();
            while (line != null) {

                quote.add(line.trim());
                line = in.readLine();
            }
        } catch (IOException io) {
            System.out.println("An IO Exception occurred\n" +
                    "" + io.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                System.out.println("An Exception occurred\n " +
                        "" + e.getMessage() + "\n");
            }
        }
        return quote;
    }

    private static ArrayList<String> writeToAFile(List<String> list) {
        ArrayList<String> quote = new ArrayList<>();

        Frame f = new Frame();
        FileDialog foBox = new FileDialog(f, "Reading text file", FileDialog.SAVE);
        foBox.setVisible(true);
        String foName = foBox.getFile();
        String dirPath = foBox.getDirectory();

        File inFile = new File(dirPath + foName);

        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(inFile)));

            for (String s : list) {
                out.println(s);
            }
        } catch (IOException io) {
            System.out.println("An IO Exception occurred\n " +
                    "" + io.getMessage() + "\n");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                System.out.println("An Exception occurred\n " +
                        "" + e.getMessage() + "\n");
            }
        }
        return quote;

    }

    private static List<String> encryptFile(List<String> file) {

        ArrayList<String> encrypted = new ArrayList<>();
        for (String s : file) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                char letter = s.charAt(j);
                int secondNumber = ((int) letter) + 1;

                char firstLetter = (char) secondNumber;
                sb.append(firstLetter);
            }
            encrypted.add(sb.toString());
        }
        return encrypted;
    }

    private static List<String> decryptFile(List<String> file) {

        ArrayList<String> decrypted = new ArrayList<>();
        for (String s : file) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                char letter = s.charAt(j);
                int secondNumber = ((int) letter) - 1;

                char firstLetter = (char) secondNumber;
                sb.append(firstLetter);

            }
            decrypted.add(sb.toString());
        }
        return decrypted;
    }


    private static void encryptingAFile(List<String> list) {
        byte[] empList, textEncrypted;

        try {
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream object = new ObjectOutputStream(byteArray);

            KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
            SecretKey myDesKey = keygenerator.generateKey();

            Cipher desCipher;
            desCipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); //FOOD --> GPPE; APPLE --> bqqmf -> ABC -->

            object.writeObject(list);

            empList = byteArray.toByteArray();
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey, new IvParameterSpec(new byte[16]));
            textEncrypted = desCipher.doFinal(empList);

            Files.write(Paths.get("file/quote.txt"), textEncrypted);

            desCipher.init(Cipher.DECRYPT_MODE, myDesKey, new IvParameterSpec(new byte[16]));
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);

            ByteArrayInputStream bis = new ByteArrayInputStream(textDecrypted);
            ObjectInputStream ois = new ObjectInputStream(bis);

            java.util.List<String> result = (List<String>) ois.readObject();
            result.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
