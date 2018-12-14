package com.keita.module8;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class MergeFiles {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        List<Integer> numList = new ArrayList<>();

        boolean runProgram = true;

        while (runProgram) {
            int choice = menu();
            switch (choice) {
                case 0:
                    runProgram = false;
                    break;
                case 1:
                    readText(numList);
                    break;
                case 2:
                    sortDataInAscOrder(numList);
                    printList(numList);
                    break;
                case 3:
                    shuffleData(numList);
                    printList(numList);
                    break;
                case 4:
                    TreeSet<Integer> treeSet = new TreeSet<>(numList);
                    removeDup(treeSet);
                    break;
            }
        }
    }

    public static int menu() {
        System.out.println("\nWHICH OF THE FOLLOWING WOULD YOU LIKE:\n" +
                "========================================");
        System.out.println("1.  Read in the files and merge");
        System.out.println("2.  Sort Numbers - Low to High");
        System.out.println("3.  Shuffle Numbers - Random");
        System.out.println("4.  Remove duplicates");
        System.out.println("0.  Quit!");
        System.out.println("CHOICE:");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    private static void printList(List<Integer> list) {
        for (Integer num : list) {
            System.out.println(num);
        }
    }

    public static List<Integer> readText(List<Integer> numbersList) {

        Frame f = new Frame();
        Frame f2 = new Frame();

        FileDialog foBox = new FileDialog(f, "Reading Text File", FileDialog.LOAD);
        foBox.setVisible(true);
        FileDialog foBox2 = new FileDialog(f2, "Reading Text File", FileDialog.LOAD);
        foBox2.setVisible(true);

        String foName = foBox.getFile();
        String dirPath = foBox.getDirectory();
        String foName2 = foBox2.getFile();
        String dirPath2 = foBox2.getDirectory();

        File inFile = new File(dirPath + foName);
        File inFile2 = new File(dirPath2 + foName2);
        BufferedReader in = null, in2;
        StringTokenizer tokenizer;
        try {

            in = new BufferedReader(new FileReader(inFile));
            in2 = new BufferedReader(new FileReader(inFile2));

            String line = in.readLine() + " " + in2.readLine();

            while (line != null) {

                tokenizer = new StringTokenizer(line, " ");

                while (tokenizer.hasMoreElements()) {
                    numbersList.add(Integer.parseInt(tokenizer.nextToken()));
                }

                line = in.readLine();
            }
            System.out.println("Successful don reading files");
        }
        catch (IOException io) {
            System.out.println("An IO Exception occurred " + io.getMessage());
        } finally
        {
            try {
                assert in != null;
                in.close();
            } catch (Exception e) {
                System.out.printf("An Exception occurred " + e.getMessage());
            }
        }
        return numbersList;
    }

    private static void sortDataInAscOrder(List<Integer> dataToSort) {
//        Collections.sort(dataToSort);

        System.out.println("AFTER SORTING NUMBER IN ASCENDING ORDER\n" +
                "===================================");
        int temp;
        for (int i = 0; i < dataToSort.size(); i++) {
            for (int j = i + 1; j < dataToSort.size(); j++) {
                if (dataToSort.get(i) > dataToSort.get(j)) {
                    temp = dataToSort.get(i);
                    dataToSort.set(i, dataToSort.get(j));
                    dataToSort.set(j, temp);
                }
            }
        }
    }

    private static void shuffleData(List<Integer> data) {
        System.out.println("AFTER SHUFFLING THE DATA\n" +
                "================================");
//        Collections.shuffle(data);
        Random random = new Random();
        int dataSize = data.size();
        int temp;
        for (int i = 0; i < data.size(); i++) {
            int change = i + random.nextInt(dataSize - i);
            temp = data.get(i);
            data.set(i, data.get(change));
            data.set(change, temp);
        }
    }

    private static void removeDup(SortedSet<Integer> set){
        System.out.printf("AFTER REMOVING DUPLICATE\n" +
                "================================");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
