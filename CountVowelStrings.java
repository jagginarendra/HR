package com.practice;

import java.util.Scanner;
// accepted when taking care of range for result variable
public class CountVowelStrings {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T;
        T = s.nextInt();
        while (T-- > 0){

            String input = s.next();
            int result = 1;
            if(input.contains("_")){

                int numOfVowels = 0;
                int arrayOfVowels[] = new int[21];

                for (int i = 0; i < input.length(); i++) {
                    char temp = input.charAt(i);
                    if(temp == 'a' || temp == 'i' ||temp == 'e' || temp == 'o' || temp == 'u'){
                        arrayOfVowels[temp-97] = 1;
                    }else if(input.charAt(i) == '_'){

                        /*for (int t: arrayOfVowels) {
                            if(t == 1) numOfVowels++;
                        }*/
                        if(arrayOfVowels[0] == 1)
                            numOfVowels++;
                        if(arrayOfVowels[4] == 1)
                            numOfVowels++;
                        if(arrayOfVowels[8] == 1)
                            numOfVowels++;
                        if(arrayOfVowels[14] == 1)
                            numOfVowels++;
                        if(arrayOfVowels[20] == 1)
                            numOfVowels++;

                        //System.out.println(numOfVowels+" num of vowels before ith="+i);
                        result = result * numOfVowels;
                        //arrayOfVowels = new int[21];
                        numOfVowels = 0;
                    }
                }
                System.out.println(result);
            }else{
                System.out.println("1");
            }

        }

    }
}
