package com.demo;

import java.util.Scanner;

public class LonelyInteger {

	
	public static int lonelyInt(int input[]){
		int result = input[0];
        for(int i = 1 ; i < input.length ; i++){
        	result = result ^ input[i];
        }
        return result;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println(lonelyInt(a));
	}

}
