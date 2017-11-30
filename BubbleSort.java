package com.demo;

import java.util.Scanner;

public class BubbleSort {

	public int count;
	int[] input;
	
	public int[] sort(int input[]){
		
		if(input == null)
			throw new IllegalStateException();
		
		this.input = input;
		int n = input.length;
		
		for(int i = 0 ; i < n-1 ; i++){
			for(int j = 0 ; j < n-i-1 ; j++){
				
				if(input[j] > input[j+1]){
					swap(j,j+1);
				}
			}
		}
		return input;
	}
	
	private void swap(int j, int i) {
		int temp = input[j];
		input[j] = input[i];
		input[i] = temp;
		this.count++;
	}

	public static void main(String[] args) {
		
		BubbleSort obj = new BubbleSort();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int array[] = new int[n];
		for(int i = 0 ; i < n ; i++){
			array[i] = s.nextInt();
		}
		array = obj.sort(array);
		System.out.println("Array is sorted in "+obj.count+" swaps.");
		/*for (int i : array) {
			System.out.print(i+" ");
		}*/
		System.out.println("First Element: "+array[0]);
		System.out.println("Last Element: "+array[n-1]);
	}

}
