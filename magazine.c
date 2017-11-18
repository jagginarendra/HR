#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    int m; 
    int n; 
    scanf("%d %d",&m,&n);
    char* *magazine = malloc(sizeof(char*) * m);
    for(int magazine_i = 0; magazine_i < m; magazine_i++){
       magazine[magazine_i] = (char *)malloc(10240 * sizeof(char));
       scanf("%s",magazine[magazine_i]);
    }
    char* *ransom = malloc(sizeof(char*) * n);
    for(int ransom_i = 0; ransom_i < n; ransom_i++){
       ransom[ransom_i] = (char *)malloc(10240 * sizeof(char));
       scanf("%s",ransom[ransom_i]);
    }
    return 0;
}

