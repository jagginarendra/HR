package com.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianImplementation {

	public static double[] getMedians(int array[]) {

		// maxheap
		PriorityQueue<Integer> lower = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {

				/*System.out.println("a=" + a + "   b=" + b);
				System.out.println(-1 * a.compareTo(b));
				*/return -1 * a.compareTo(b);
			}
		});
		// min heap
		PriorityQueue<Integer> upper = new PriorityQueue<>();
		double[] medians = new double[array.length];
		for (int i = 0; i < array.length; i++) {

			int number = array[i];
			addNumber(number, lower, upper);
			rebalance(lower, upper);
			medians[i] = getMedian(lower , upper);
		}
		return medians;
	}

	private static double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> upper) {
		
		PriorityQueue<Integer> biggerSizeHeap  = lower.size() > upper.size() ? lower:upper;
		PriorityQueue<Integer> smallerSizeHeap = lower.size() > upper.size() ? upper:lower;
		
		
		if(smallerSizeHeap.size() == biggerSizeHeap.size()){
			return ( (double) biggerSizeHeap.peek() + smallerSizeHeap.peek() )/ 2;
		}
		else
			return biggerSizeHeap.peek(); 
	}

	private static void rebalance(PriorityQueue<Integer> lower, PriorityQueue<Integer> upper) {

		PriorityQueue<Integer> biggerSizeHeap  = lower.size() > upper.size() ? lower:upper;
		PriorityQueue<Integer> smallerSizeHeap = lower.size() > upper.size() ? upper:lower;
		if(biggerSizeHeap.size() - smallerSizeHeap.size() >= 2){
			smallerSizeHeap.add(biggerSizeHeap.poll());
		}
		
	}

	private static void addNumber(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> upper) {

		if (lower.size() == 0 || number  < lower.peek()) {
			lower.add(number);
		} else {
			upper.add(number);
		}
	}

}

public class RunningMedian {

	public static void main(String[] args) {

		MedianImplementation impl = new MedianImplementation();
		int array[] = {12,4,5,3,8,7};
		double medians[] = impl.getMedians(array);
		
		for (double d : medians) {
			System.out.println(d);
		}
	}
}
