#include<stdio.h>

int Prime_number ( int N );

int main()
{ 
    int num;
     scanf("%d",&num);
     printf("%d\n",Prime_number(num));
     return 0;
}

/* ???????? */
#include <math.h>
int Prime_number ( int N ){
	int i, j;
	for(i=N+1; ; i++){
		int flag = 1;
		for(j=2; j<=sqrt(i); j++){
			if(i%j == 0){
				flag = 0;
				break;
			}
		}
		if(flag)	return i;
	}	
}
