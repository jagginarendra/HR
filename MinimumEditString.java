package com.practice;

import java.util.Scanner;

//convert str1 to str2 by using min operations
public class MinimumEditString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        System.out.println(getMinimumEdits(str1,str2));
    }

    private static long getMinimumEdits(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        long array[][] = new long[length1+1][length2+1];
        for (int i = 0 ; i < 1 ; i++){
            for(int j = 1 ; j < length2+1 ; j++){
                array[i][j] = array[i][j-1]+1;
                //array[j][i] = array[j-1][i]+1;
            }
        }
        for (int i = 0 ; i < 1 ; i++){
            for(int j = 1 ; j < length1+1 ; j++){
           //     array[i][j] = array[i][j-1]+1;
                array[j][i] = array[j-1][i]+1;
            }
        }
        for (int i = 1 ; i < length1+1 ; i++){
                for(int j = 1 ; j < length2 + 1 ; j++) {
                    // if same char copy diagonal value
                    System.out.println("i="+i+" j="+j);
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        array[i][j] = array[i-1][j-1];
                    }else{
                        array[i][j] = minimum(array[i-1][j-1],array[i-1][j],array[i][j-1]) + 1;
                    }
                }
            System.out.println();
        }
        return array[length1][length2];
    }

    private static long minimum(long l1, long l2, long l3) {
        return Long.min(Long.min(l1,l2),l3);
    }
}
