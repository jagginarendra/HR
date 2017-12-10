package com.practice;

import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int array[] = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        mergesort(array);
        for (int item:
             array) {
            System.out.print(item+" ");
        }
    }

    private static void mergesort(int[] array) {
        mergesort(array,new int[array.length],0,array.length-1);
    }

    private static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd)
            return;
        int middle = (leftStart+rightEnd)/2;
        mergesort(array,temp,leftStart,middle);
        mergesort(array,temp,middle+1, rightEnd);
        mergeHalves(array,temp,leftStart,rightEnd);
    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {

        int middle = (rightEnd+leftStart)/2;
        int leftIndex = leftStart;
        int rightIndex = middle + 1;
        int tempIndex = leftStart;
        while (leftIndex <= middle && rightIndex <= rightEnd){
            //System.out.println("temp="+tempIndex);
            if(array[leftIndex] <= array[rightIndex]){
                temp[tempIndex++] = array[leftIndex];
                leftIndex++;
            }else{
                temp[tempIndex++] = array[rightIndex];
                rightIndex++;
            }
            //tempIndex++;
        }
        // leftcopy
        System.arraycopy(array,leftIndex,temp,tempIndex,middle-leftIndex+1);
        //rightCopy
        System.arraycopy(array,rightIndex,temp,tempIndex,rightEnd-rightIndex+1);
        // temp copy to original array
        System.arraycopy(temp,leftStart,array,leftStart,rightEnd-leftStart+1);
    }
}
