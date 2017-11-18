#include<stdio.h>
#include<math.h>
int main(){

	double baseMealCost,totalMealCost;
	int taxPercent, tipPercent;
	scanf("%lf",&baseMealCost);
	scanf("%d %d",&taxPercent,&tipPercent);	
	totalMealCost = baseMealCost + (taxPercent/100.00)*baseMealCost;
	totalMealCost = totalMealCost + (tipPercent/100.00)*baseMealCost;
	int roundOffPrice = round(totalMealCost); 
	printf("The total meal cost is %d dollars.\n",roundOffPrice);		
	return 0;
}
