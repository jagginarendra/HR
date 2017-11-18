#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int main(){

	char input1[10001],input2[100001];
	scanf("%s %s",input1,input2);
	int i,count = 0;
	int array1[26]={0},array2[26]={0};
	int length1 = strlen(input1), length2 = strlen(input2);
	for(i = 0 ; i < length1 ;i++){
		array1[input1[i]-97]++;
	}
	//scan 2 string
	for(i = 0 ; i < length2 ;i++){
		array2[input2[i]-97]++;
	}
	for( i = 0 ;i < 26 ; i++){
		count = count + abs(array1[i]-array2[i]);
	}
	printf("%d ",count);		
	return 0;
}
