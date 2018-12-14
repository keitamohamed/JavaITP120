package com.keita.module5;

public class RainFallDriver {
    public static void main(String[] args) {
        double [] rainFall = {.5, .3, .7, 1.2, .1, .8, 2.1, .5, 3.3, 2.8, .9, 1.2};
        double totalRain = totalRainFall(rainFall);
        double averageRain = averageRainFall(rainFall);
        double maxRain = maxRainFall(rainFall);
        double minRainFall = minRainFall(rainFall);

        System.out.println("Total rain fall: " + totalRain);
        System.out.println("The average monthly rainfall is: " + averageRain);
        System.out.println("The maximum monthly rainfall is: " + maxRain);
        System.out.println("The minimum monthly rainfall is: " + minRainFall);
    }

    private static double totalRainFall(double[] rainFall) {
        double totalRainFall = 0;
        for (int i = 0; i < rainFall.length; i++) {
            totalRainFall += rainFall[i];

        }
        return totalRainFall;
    }

    private static double averageRainFall(double[] rainFall) {
        int counter = 0;
        double totalRain = 0;
        for (int i = 0; i < rainFall.length; i++) {
            totalRain += rainFall[i];
            counter++;
        }
        return (totalRain / counter);
    }

    private static double maxRainFall(double[] rainFall){
        double maxRain = rainFall[0];

        for (int i = 0; i < rainFall.length; i++) {
            if (maxRain < rainFall[i]) {
                maxRain = rainFall[i];
            }
        }
        return maxRain;
    }

    private static double minRainFall(double[] rainFall) {
        double minRainFall = rainFall[0];

        for (int i = 0; i < rainFall.length; i++) {
            if (minRainFall > rainFall[i]) {
                minRainFall = rainFall[i];
            }
        }
        return minRainFall;
    }
}
