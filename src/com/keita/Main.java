package com.keita;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

import static com.keita.module6.TrackInsurance.scan;
import static com.keita.module6.TrackInsurance.sortCustNum;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Frame f = new Frame();

        FileDialog foBox = new FileDialog(f, "Load File", FileDialog.LOAD);
        foBox.setVisible(true);

        String foName = foBox.getFile();
        String dirPath = foBox.getDirectory();
        File file = new File(dirPath + foName);

        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            System.out.println("Print");
            while ((line = reader.readLine()) != null){
                String[] split = line.split(",");
                System.out.println(split[1]);
            }
            scan.close();
        }catch (FileNotFoundException o) {
            System.out.println(o.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
