#include<stdio.h>
#include<string.h>
int main(){

	int intVar;
	double doubleVar;
	
	char array[10001];
	scanf("%d",&intVar);
	scanf("%lf",&doubleVar);
	char temp[1];
	fgets(temp,1,stdin);
	fgets(array,10001,stdin);
	
	int sum = intVar + doubleVar;
	double doubleSum = doubleVar + doubleVar;
	

	printf("%d\n",sum);
	printf("%lf\n",doubleSum);
	printf("HackerRank %s",array);

	return 0;
}
