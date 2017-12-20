package com.practice;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumStepsToOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while(N-- > 0){
            int num = scanner.nextInt();
            System.out.println(getMinimumStepsUtil(num));
        }
        scanner.close();
    }

    static int memo[];

    private static int getMinimumStepsUtil(int N) {
        memo = new int[N+1];
        Arrays.fill(memo,-1);
        return getMinSteps(N);
    }

    private static int getMinSteps(int N) {
        if(N == 1)
            return 0;
        if(memo[N] != -1)
            return memo[N];
        int result = 1 + getMinSteps(N-1);
        if(N % 2 == 0 )
            result = Integer.min(result , 1+ getMinSteps(N/2));
        if(N % 3 == 0 )
            result = Integer.min(result , 1+ getMinSteps(N/3));
        memo[N] = result;
        return result;
    }

}
