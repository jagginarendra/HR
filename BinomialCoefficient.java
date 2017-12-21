package com.practice.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class BinomialCoefficient {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        memo = new int[N+1];
        //Arrays.fill(memo,-1);
        int result = factorial(N) / ( factorial(N-K) * factorial(K) );
        System.out.println(result);

        /*for (int i:
             memo) {
            System.out.println(i);

        }*/
        scanner.close();
    }

    static int memo[];
    private static int factorial(int n) {
        if(n == 1)
            return 1;
        if(memo[n] != 0)
            return memo[n];
        memo[n] = n * factorial(n-1);
        return memo[n];
    }
}
