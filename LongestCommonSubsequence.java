package com.practice.DynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubsequence {

    static int memo[][];
    static String input1 , input2;
    static int length1 , length2;

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        input1 = scanner.next();
        input2 = scanner.next();
        length1 = input1.length();
        length2 = input2.length();
        memo = new int[length1+1][length2+1];
        System.out.println(getCommonSubsequence());
    }

    private static int getCommonSubsequence() {

        for (int i = 1 ; i < length1+1 ; i++){
            for (int j = 1 ; j < length2+1 ; j++){
                if(input1.charAt(i-1) == input2.charAt(j-1)){
                    memo[i][j] = 1 + maximum(memo[i-1][j-1],memo[i-1][j]);
                }else{
                    memo[i][j] = maximum(memo[i-1][j] , memo[i][j-1]);
                }
            }
        }

        return memo[length1][length2];
    }

    private static int maximum(int i, int i1) {
        return Integer.max(i,i1);
    }

    private static int maximum(int i, int i1, int i2) {
        return Integer.max(i,Integer.max(i1,i2));
    }
}
