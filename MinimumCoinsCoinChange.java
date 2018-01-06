package com.practice;

import java.util.Scanner;

public class MinimumCoinsCoinChange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int numberOfCoins = scanner.nextInt();
        int coins[] = new int[numberOfCoins + 1];

        for (int i = 1; i < numberOfCoins + 1; i++) {
            coins[i] = scanner.nextInt();
        }
        // for large numbers
        long array[][] = new long[numberOfCoins + 1][value + 1];
        array[0][0] = 1;
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < value + 1; j++) {
                array[i][j] = Long.MAX_VALUE;
            }
        }
        for (int i = 0; i < numberOfCoins + 1; i++) {
            for (int j = 0; j < 1; j++) {
                array[i][j] = 0;
            }
        }
        // calculating
        for (int i = 1; i < numberOfCoins + 1; i++) {
            for (int j = 1; j < value + 1; j++) {

                // r  > c then copy value from above cell
                if (coins[i] > j) {
                    array[i][j] = array[i - 1][j];
                } else {
                    long tempValue = array[i][j - coins[i]];
                    if (tempValue != Long.MAX_VALUE){
                        tempValue++;
                    }
                    array[i][j] =  Long.min( array[i - 1][j] , tempValue);
                }
            }
        }
        System.out.println(array[numberOfCoins][value]);
        scanner.close();
    }
}
