package com;
import java.util.Scanner;

public class FindNumberInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int array[][] = new int[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            for (int j = 0 ; j < cols ; j++){
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter Number to Search");
        int number = scanner.nextInt();
        findNumberInMatrix(array , number , rows , cols);
    }

    private static void findNumberInMatrix(int[][] array, int number , int rows , int cols) {
            boolean found = false;
            for(int i = 0 ; i < rows ;i++){
                int start = 0;
                int end = cols-1;
                while(end >= 0 && end < cols && start <= end && start >= 0){
                    int mid = (start + end) / 2;
                    if(array[i][mid] == number){
                        System.out.println("found=="+i+""+mid);
                        found = true;
                        break;
                    }
                    if(array[i][mid] > number){
                        end = mid-1;
                    }else{
                        start = mid+1;
                    }
                }
            }
            if(!found){
                System.out.println("Not present in Matrix!!!");
            }
    }


}
