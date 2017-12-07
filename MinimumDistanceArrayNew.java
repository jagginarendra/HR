package com.demo;

import java.util.Scanner;

public class MinimumDistanceArrayNew {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int array[] = new int[N + N];
		for (int i = 0; i < N; i++) {
			array[i] = s.nextInt();
			array[N + i] = array[i];
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

		boolean gotFirst = false, gotSecond = false;
		int firstIndex = Integer.MAX_VALUE, secondIndex = Integer.MAX_VALUE, minDistance = Integer.MAX_VALUE;

		for (int i = 0; i < array.length; i++) {

			if (array[i] == first) {

				gotFirst = true;
				firstIndex = i;
				if (gotSecond == true) {
					int tempDistance = Math.abs(firstIndex - secondIndex);
					if (tempDistance < minDistance)
						minDistance = tempDistance;
				}
			}
			if (array[i] == second) {

				gotSecond = true;
				secondIndex = i;
				if (gotFirst == true) {
					int tempDistance = Math.abs(firstIndex - secondIndex);
					if (tempDistance < minDistance)
						minDistance = tempDistance;
				}
			}

		}
		return minDistance;
	}

}
