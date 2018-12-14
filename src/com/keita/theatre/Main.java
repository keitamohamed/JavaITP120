package com.keita.theatre;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static int choice = 0;

    public static void main(String[] args) {

        Theatre theatre = new Theatre();

        String more = "Y";
        while (choice != 7) {
            choice = theatre.validInput(menu());
            switch (choice){
                case 1:
                    File file = openFile();
                    theatre.loadData(file);
                    break;
                case 2:
                    theatre.printTheatreSeat();
                    break;
                case 3:
                    theatre.ticketDetail();
                    break;
                case 4:
                    while (more.equalsIgnoreCase("Y")) {
                        if (theatre.sellTicket() == -1) {
                            more = "N";
                            continue;
                        }
                        System.out.println("\nMore Sell: (Y / N)");
                        more = sc.nextLine();
                    }
                    break;
                case 5:
                    System.out.println();
                    break;
                case 6:
                    theatre.writeFile(fileTypeTWrite());
                    break;
                default:
                    System.out.println("Invalid Choice. Try Again>");
            }
        }

    }

    private static int menu(){
        System.out.println("WELCOME TO ROANOKE VALLEY VIEW MOVIES THEATRE\n" +
                "=============================================");
        System.out.println("1. Load Data From a File\n" +
                "2. Print Theatre Seat Layout\n" +
                "3. Counter All Available Seat and Price If Sold\n" +
                "4. Sale Ticket\n" +
                "5. Print Sale Record\n" +
                "6. Write Theatre Info To File\n" +
                "7. End Program\n\n" +
                "Chose From The List: ");
        choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    private static int fileTypeTWrite(){
        System.out.println("Chose A File Type You Will Be Writing Today:\n" +
                "---------------------------------------\n" +
                "1. Text File\n" +
                "2. An Excel File (For ticket sale record)\n" +
                "Chose file type: ");
        int type = sc.nextInt();
        sc.nextLine();
        return type;
    }

    private static File openFile(){
        Frame f = new Frame();

        FileDialog foBox = new FileDialog(f, "Chose Theatre Seats File", FileDialog.LOAD);
        foBox.setVisible(true);

        String foName = foBox.getFile();
        String dirPath = foBox.getDirectory();
        return new File (dirPath + foName);
    }


}
