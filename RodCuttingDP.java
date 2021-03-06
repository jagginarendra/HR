package com.practice.DynamicProgramming;

import java.util.Scanner;

public class RodCuttingDP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rodLength = scanner.nextInt();
        int N = scanner.nextInt();
        int prices[] = new int[N];
        for(int i = 0 ; i < N ; i++){
            prices[i] = scanner.nextInt();
        }
        int values[] = new int[N+1];
        for(int i = 1 ; i < N+1 ; i++){
            values[i] = scanner.nextInt();
        }

        System.out.println(maxProfit(rodLength,N, prices, values));

    }

    private static int maxProfit(int totalRodLength,int N, int[] rodLength, int[] values) {

        int array[][] = new int[N+1][totalRodLength+1];

        for(int i = 1 ; i < N+1 ; i++){
            for (int j=1 ; j < totalRodLength+1 ;  j++){

                array[i][j] = Integer.max(array[i-1][j] ,
                        j/i*values[i] + array[i][j%i]);

            }
          }
        return array[N][totalRodLength];
    }
}
