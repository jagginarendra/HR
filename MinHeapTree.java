package com.example;

import java.util.Arrays;

class Tree{

	private int size = 0;
	private int capacity = 4;
	int items[] = new int[capacity];
	
	public void start(int size , int array[]) {
		this.size = size;
		items = array;
	}
	
	private int getLeftChildIndex(int currentIndex) { return (currentIndex*2)+1; }
	private int getRightChildIndex(int currentIndex) { return (currentIndex*2)+2; }
	private int getParentIndex(int currentIndex) { return (currentIndex-1)/2; }
	
	
	private int leftChild(int currentIndex) { return items[getLeftChildIndex(currentIndex)];}
	private int rightChild(int currentIndex) { return items[getRightChildIndex(currentIndex)];}
	private int parent(int currentIndex) { return items[getParentIndex(currentIndex)]; }
	
	
	private boolean hasLeftChild(int currentIndex) { return getLeftChildIndex(currentIndex) < size; }
	private boolean hasRightChild(int currentIndex) { return getRightChildIndex(currentIndex) < size; }
	private boolean hasParent(int currentIndex) { return getParentIndex(currentIndex) >= 0; }
	
	private void swap(int indexOne, int indexTwo) {
		items[indexOne] = items[indexOne] + items[indexTwo];
		items[indexTwo] = items[indexOne] - items[indexTwo];
		items[indexOne] = items[indexOne] - items[indexTwo];
	}
	
	private void ensureCapacity() {
		if(size == capacity) {
			items = Arrays.copyOf(items, capacity*2);
			capacity *= 2;
		}
	}
	
	/*
	 * Get the root element 
	 */
	public int peek() {
		
		if(size ==0 ) throw new IllegalStateException();
		return items[0];
	}
	
	/*
	 * Remove and return the root element from heap
	 */
	public int poll() {
		if(size == 0) throw new IllegalStateException();
		int item = items[0]; 
		// remove the top element and put the last element at first
		int lastItem = items[size-1];
		items[0] = lastItem;
		size--;
		heapifyDown();
		return item;
	}
	
	
	public void add(int item) {
		ensureCapacity();
		items[size]= item;
		size++;
		heapifyUp();
	}
	/*
	 * Maintains the heap property when a new item is inserted
	 */
	private void heapifyUp() {
		int currentIndex = size - 1;
		while(hasParent(currentIndex) && parent(currentIndex) > items[currentIndex] ) {
			swap(currentIndex, getParentIndex(currentIndex));
			currentIndex = getParentIndex(currentIndex);
		}
	}
	/*
	 * Maintains the heap property when root is deleted
	 */
	private void heapifyDown() {
		
		int currentIndex = 0;
		while( hasLeftChild(currentIndex)) {
			int smallerChildIndex = getLeftChildIndex(currentIndex);
			if( hasRightChild(currentIndex) && rightChild(currentIndex) < leftChild(currentIndex) ) {
				smallerChildIndex = getRightChildIndex(currentIndex);
			}
			if(items[currentIndex] < items[smallerChildIndex] ) {
				break;
			}else {
				swap(currentIndex, smallerChildIndex);
			}
			currentIndex = smallerChildIndex;
		}
	}
}

public class MinHeapTree {

	public static void main(String[] args) {

		Tree tree = new Tree();
		int array[] = {10,15,20,17,25};
		tree.start(5, array);
		//tree.add(8); // adding new node
		System.out.println(tree.peek()); //display root node
		tree.poll();
	}
}
