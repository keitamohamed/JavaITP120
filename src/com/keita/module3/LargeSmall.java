package com.module3;

import java.util.*;

public class LargeSmall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numList = new ArrayList<>();

        for (int i = 1; i < 3; i++) {
            String moreNumber;
            int numberEnter = 0;
            System.out.println("Round #" + i + "\n" +
                    "==========");

            if (i <= 2) {
                moreNumber = "yes";
            }
            else {
                moreNumber = "No";
            }

            while (moreNumber.equals("yes")) {
                numberEnter++;
                System.out.println("Please enter a number: ");
                int number = sc.nextInt();
                numList.add(number);

                sc.nextLine();

                System.out.println("More number? (Yes or No");
                moreNumber = sc.nextLine();

                if(!moreNumber.equalsIgnoreCase("yes")) {
                    int max = numList.get(0);
                    int min = numList.get(0);
                    for (int j = 0; j < numList.size(); j++) {
                        if (numList.get(j) > max){
                            max = numList.get(j);
                        }

                        if (numList.get(j) < min) {
                            min = numList.get(j);
                        }
                    }
                    System.out.println("You enter " + numberEnter + " number. Lowest " +
                            "number: " + min + " and the highest number " + max + "\n");
                    numList.clear();

                    // This is the easier way to do it;
//                min = Collections.min(numList);
//                max = Collections.max(numList);
//                System.out.println("You enter " + numberEnter + " number. Lowest " +
//                        "number: " + min + " and the highest number " + max);
                }
            }
        }
    }
}
