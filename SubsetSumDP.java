package com.practice.DynamicProgramming;

import java.util.Scanner;

public class SubsetSumDP {

    static int set[];
    static int sum;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int N  = scanner.nextInt();
        set = new int[N+1];
        for(int i = 1 ; i < N+1 ; i++ ){
            set[i] = scanner.nextInt();
        }
        sum = scanner.nextInt();
        System.out.println(subsetSumAvailable());
    }

    private static boolean subsetSumAvailable() {

        boolean memo[][] = new boolean[set.length+1][sum+1];
        // intialize memo array
        memo[0][0] = true;
        for (int i = 0 ; i < 1 ; i++){
            for (int j = 1 ; j < sum+1 ; j++ ){
                memo[i][j] = false;
            }
        }
        for (int i = 0 ; i < set.length+1 ; i++){
            for (int j = 0 ; j < 1 ; j++ ){
                memo[i][j] = true;
            }
        }

        //System.out.println("setlength="+set.length+1);
        int rowsLength = set.length;
        for (int i = 1 ; i < rowsLength ; i++){
            for (int j = 1 ; j < sum+1 ; j++ ){
                if(set[i] > j){
                     memo[i][j] = memo[i-1][j];
                }else {

                    memo[i][j] = memo[i - 1][j] || memo[i - 1][j - set[i]];
                }
            }
        }

        for (int i = 0 ; i < set.length ; i++){
            for(int j = 0 ; j < sum + 1 ; j++){
                if(memo[i][j] == true)
                    System.out.print("T ");
                else
                    System.out.print("F ");
            }
            System.out.println();
        }

        return memo[set.length-1][sum];
    }
}
