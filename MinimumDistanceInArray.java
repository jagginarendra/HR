/**
 * 
 */
package com.demo;

import java.util.Scanner;

/**
 * @author jaggi
 *
 */
public class MinimumDistanceInArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int array[] = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = s.nextInt();
		}
		int Q = s.nextInt();
		for (int i = 0; i < Q; i++) {
			int first = s.nextInt();
			int second = s.nextInt();
			System.out.println(getMinimumDistance(array, first, second));
		}
		s.close();
	}

	private static int getMinimumDistance(int[] array, int first, int second) {
		int firstIndex = Integer.MAX_VALUE, secondIndex = Integer.MAX_VALUE, minDistance = Integer.MAX_VALUE;
		int firstMinIndex=Integer.MAX_VALUE,firstMaxIndex=Integer.MAX_VALUE,secondMinIndex=Integer.MAX_VALUE,secondMaxIndex=Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == first) {
				firstIndex = i;
				if(firstMinIndex == Integer.MAX_VALUE)
					firstMinIndex = i;
			}
			if (array[i] == second) {
				secondIndex = i;
				if(secondMinIndex == Integer.MAX_VALUE)
					secondMinIndex = i;
			}
			if (firstIndex != Integer.MAX_VALUE && secondIndex != Integer.MAX_VALUE) {
				int tempDistance = Math.abs(firstIndex - secondIndex);
				if (tempDistance < minDistance) {
					if (tempDistance == 0)
						return 0;
					minDistance = tempDistance;
				}
			}
		}
		firstMaxIndex = firstIndex;
		secondMaxIndex = secondIndex;
		// first min & second max
		int bigger = firstMinIndex > secondMaxIndex ? firstMinIndex : secondMaxIndex;
		int smaller = firstMinIndex > secondMaxIndex ? secondMaxIndex : firstMinIndex  ;
		int temp = array.length - bigger + smaller;
		// second min & firstmax
		int bigger2 = secondMinIndex > firstMaxIndex ? secondMinIndex : firstMaxIndex;
		int smaller2 =secondMinIndex > firstMaxIndex ? firstMaxIndex: secondMinIndex ;
		int temp2 = array.length - bigger2 + smaller2;
		//System.out.println(temp+" " + temp2);
		if(temp < temp2 && temp < minDistance)
			minDistance = temp;
		if(temp > temp2 && temp2 < minDistance)
			minDistance = temp2;
		return minDistance;
	}
}