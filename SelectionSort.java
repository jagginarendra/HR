package com.demo;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int array[] = new int[N];
		for(int i = 0 ; i < N ; i++){
			array[i] = s.nextInt();
		}
		sort(N, array);
		printArray(array);
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}

	private static void sort(int N, int[] array) {
		for(int i = 0 ; i < N-1 ; i++){
			int min = array[i];
			int index = i;
			for(int j = i+1 ; j < N ; j++){
				if(min > array[j]){
					min = array[j];
					index = j;
				}
			}
			swap(array , i , index);
		}
	}

	private static void swap(int[] array, int i, int index) {
		int temp = array[i];
		array[i] = array[index];
		array[index] = temp;
	}
}
