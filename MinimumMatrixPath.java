package com.practice.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumMatrixPath {

    private static int array[][];
    private static int memo[][];

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int rows = scanner.nextInt();
        final int cols = scanner.nextInt();
        array = new int[rows][cols];
        memo = new int[rows][cols];
        for (int[] tempArray : memo)
            Arrays.fill(tempArray,-1);

        for (int i = 0 ; i < rows ; i++){
            for (int j = 0 ; j < cols ; j++){
                array[i][j] = scanner.nextInt();
            }
        }
        final int destinationRows = scanner.nextInt();
        final int destinationCols = scanner.nextInt();
        System.out.println(getMinimumPath(destinationRows,destinationCols));
    }

    private static int getMinimumPath(int i, int j) {

        if (i < 0 || j < 0 )
            return Integer.MAX_VALUE;
        if (i == 0 && j == 0)
            return array[0][0];

        if (memo[i][j] != -1){
            //System.out.println("using memo[][]");
            return memo[i][j];
        }
        memo[i][j] = array[i][j] + minimum( getMinimumPath(i-1,j-1), getMinimumPath(i-1,j),
                getMinimumPath(i,j-1));
        return memo[i][j];
    }

    private static int minimum(int minimumPath, int minimumPath1, int minimumPath2) {
        return Integer.min( Integer.min(minimumPath,minimumPath1),minimumPath2);
    }
}
