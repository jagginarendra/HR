package com.practice.DynamicProgramming;

import java.io.*;
import java.util.*;


public class Solution {

    

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int length1 = scanner.nextInt();
        final int length2 = scanner.nextInt();
        int input1[] = new int[length1+1];
        int input2[] = new int[length2+1];
        for (int i = 1 ; i < length1+1 ;i++){
            input1[i] = scanner.nextInt();
        }
        for (int i = 1 ; i < length2+1 ;i++){
            input2[i] = scanner.nextInt();
        }
        int memo[][] = new int[length1+1][length2+1];
        getLargestCommonSubsequence(memo,input1,input2);
        scanner.close();
    }
    
    
    private static void getLargestCommonSubsequence(int[][] memo, int[] input1, int[] input2) {
        //initialize for base case
        for (int i = 1 ; i < input1.length  ; i++){
            for (int j = 1 ; j < input2.length  ; j++ ){
                if(input1[i] == input2[j]){
                    memo[i][j] = 1 + memo[i-1][j-1];
                }else{
                    memo[i][j] = max(memo[i-1][j],memo[i][j-1]);
                }
            }
        }
        printSequence(memo , input1.length-1 , input2.length-1 , input1 , input2);
        //System.out.println( memo[input1.length-1][input2.length-1]);
    }
    
    private static int max(int a , int b){
        if(a > b)
            return a;
        else
            return b;
    }
    

    private static void printSequence(int[][] memo , int rows , int cols , int[] input1, int[] input2) {
        int array[] = new int[memo[rows][cols]]; // creating array of size , we got in memo final cell
        int count  = 0 ;
        int i = rows, j = cols;
        while( count < memo[rows][cols]){
            if(input1[i] == input2[j]){ // both inputs are equal
                array[count++] = input1[i];
                i--; j--;
            }else{ // if not equal
                if(memo[i-1][j] > memo[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }// while end
        for (i = count-1 ; i >= 0 ; i--){
            System.out.print(array[i] + " ");
        }

    }
}
