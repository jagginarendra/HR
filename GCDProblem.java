package com.practice;

import java.util.Scanner;

public class GCDProblem {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int array[] = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = s.nextInt();
        }
        System.out.println(gcdUtil(array));
        s.close();
    }

    private static int gcdUtil(int[] array) {

        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = gcd(result,array[i]);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        if(a == 0 )
            return b;
        return gcd(b%a, a);
    }

}
