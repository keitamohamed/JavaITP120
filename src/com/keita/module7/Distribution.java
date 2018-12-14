package com.module7;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Distribution {

    public static void main(String[] args) {
        // create an AL to read data into
        ArrayList<Integer> numList = readText();

        calcPrintDistribution(numList);
        calcPrintAverage(numList);
    }

    public static ArrayList<Integer> readText() {
        // create the ArrayList
        ArrayList<Integer> numbersList = new ArrayList<Integer>();

        Frame f = new Frame();
        // decide from where to read the file
        FileDialog foBox = new FileDialog(f, "Reading Text File", FileDialog.LOAD);
        foBox.setVisible(true);

        // get the absolute path to the file
        String foName = foBox.getFile();
        String dirPath = foBox.getDirectory();

        // create a file instance for the absolute path
        File inFile = new File(dirPath + foName);
        BufferedReader in = null;
        try {
            // create a BufferedReader to use to read in the file
            in = new BufferedReader(new FileReader(inFile));

            // read in the first entire line from the file
            String line = in.readLine();

            // continue until the line is null (ie you are at the end of the
            // file)

            while (line != null) {

                // create a StringTokenizer instance that will break the line
                // apart at each " "
                StringTokenizer t = new StringTokenizer(line, " ");

                // need to convert the numbers from txt file to data type int
                // and also need to trim off any spaces

                while (t.hasMoreTokens()) {
                    int num = Integer.parseInt(t.nextToken().trim());
                    // add the numbers to the AL
                    numbersList.add(num);
                }

                // read in next line
                line = in.readLine();
            }
        }

        // catch any IOException that occurs
        catch (IOException io) {
            System.out.println("An IO Exception occurred");
            io.printStackTrace();
        } finally // finally always runs no matter what so close the file here!
        {
            // close the file. Java is neurotic - it worried
            // "but what if it is already closed?" so needs another try/catch
            try {
                in.close();
            } catch (Exception e) {
            } // note the {} - means "do nothing". I wanted it closed anyway.
        }
        return numbersList;

    }

    public static void calcPrintDistribution(ArrayList<Integer> values) {
        int[] dist = new int[11];
        for (int i = 0; i < values.size(); i++) {
            dist[values.get(i)] += 1;
        }

        System.out.println("Number\tFrequency\n" +
                "=================");
        for (int i = 1; i < dist.length; i++)
            System.out.println(i + ".\t\t" + dist[i]);
    }

    public static void calcPrintAverage(ArrayList<Integer> values) {
        DecimalFormat df = new DecimalFormat("#.00");
        double total = 0;
        for (int i = 0; i < values.size(); i++) {
            total += values.get(i);
        }
        System.out.println("The average value is: " + df.format(total / values.size()));
    }
}
