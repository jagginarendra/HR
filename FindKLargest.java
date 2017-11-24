package com.example;

import java.util.Arrays;

class MaxHeapTree{
	
	private int size;
	private int input[];
	private int capacity = 1;
	private int items[] = new int[capacity];
	
	
	public MaxHeapTree(int[] input) {
		this.input = input;
		size = 0;
	}
	
	
	private int getLeft(int currentIndex) { return items[getLeftChildIndex(currentIndex)] ;  }
	private int getRight(int currentIndex) { return items[getRightChildIndex(currentIndex)] ;  }
	private int getParent(int currentIndex) { return items[getParentIndex(currentIndex)] ;  }
	
	private int getLeftChildIndex(int currentIndex) { return (2*currentIndex)+1; }
	private int getRightChildIndex(int currentIndex) { return (2*currentIndex)+2; }
	private int getParentIndex(int currentIndex) { return (currentIndex-1)/2; }
	
	
	private boolean hasLeftChild(int currentIndex) { return getLeftChildIndex(currentIndex) < size; }
	private boolean hasRightChild(int currentIndex) { return getRightChildIndex(currentIndex) < size; }
	private boolean hasParent(int currentIndex) { return getParentIndex(currentIndex) >= 0; }
	
	
	private void add(int item) {
		ensureCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	private int poll() {
		if(size == 0 ) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		return item;
	}
	
	private void heapifyDown() {
		int currentIndex = 0;
		while(hasLeftChild(currentIndex)) {
			int biggerIndex = getLeftChildIndex(currentIndex);
			if(hasRightChild(currentIndex) && getRight(currentIndex) > getLeft(currentIndex) ) {
				biggerIndex = getRightChildIndex(currentIndex);
			}
			if( items[currentIndex] > items[biggerIndex] ) {
				break;
			}else {
				swap(currentIndex , biggerIndex);
				currentIndex = biggerIndex;
			}
		}
	}


	private void heapifyUp() {
		int currentIndex = size;
		// parent present and is less than the child(currentIndex)
		while( hasParent(currentIndex) && getParent(getParentIndex(currentIndex)) < items[currentIndex] ) {
			swap(getParentIndex(currentIndex) , currentIndex);
			currentIndex = getParentIndex(currentIndex);
		}
	}


	private void swap(int parentIndex, int currentIndex) {
		items[parentIndex] = items[parentIndex] + items[currentIndex];
		items[currentIndex] = items[parentIndex] - items[currentIndex];
		items[parentIndex] = items[parentIndex] - items[currentIndex];
	}


	private void ensureCapacity() {
		if(size == capacity) {
			items = Arrays.copyOf(items, capacity*2);
			capacity *= 2;
		}
	}


	
	public int[] getKLargestNumber(int k) {
		// build the tree by calling add for items 1 by 1 
		for (int item: input) {
			add(item);
		}
		int klargetsNumbers[] = new int[k];
		for(int i = k-1 ; i >= 0 ; i-- ) {
			klargetsNumbers[i] = poll();
		}
		return klargetsNumbers;
		
	}
	
	
	
}

public class FindKLargest {

	public static void main(String[] args) {
		
		int input[] = { 1, 23, 12, 9, 30, 2, 50 };
		MaxHeapTree tree = new MaxHeapTree(input);
		int output[] = tree.getKLargestNumber(3);
		
		for (int item : output) {
			System.out.println(item);
		}
		
		
		
	}
}
