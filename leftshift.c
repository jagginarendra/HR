#include<stdio.h>

int main(){

	int N , start , NCopy;
	scanf("%d %d",&N,&start);
	NCopy = N;
	int i=0,array[N],shiftArray[N];

	for(i ; i < N ; i++)		
		scanf("%d",&array[i]);

	//shifting logic
	int k = 0 ;
	for(i = start ; i < N ; i++)
		shiftArray[k++] = array[i];

	for(i = 0 ; i < start ; i++)
		shiftArray[k++] = array[i];


	for(i = 0 ; i < N ; i++)
		printf("%d ",shiftArray[i]);
		
	return 0;
}
