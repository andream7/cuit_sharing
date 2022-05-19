#include <stdio.h>

int fn( int a, int n );
int SumA( int a, int n );

int main()
{
    int a, n;

    scanf("%d %d", &a, &n);
    printf("fn(%d, %d) = %d\n", a, n, fn(a,n));        
    printf("s = %d\n", SumA(a,n));    

    return 0;
}

/* ?????????? */

int fn( int a, int n ){
	int i, mul = 0;
	for(i=0; i<n; i++)
		mul = mul*10 + a;
	return mul;	
}

int SumA( int a, int n ){
	int i, sum = 0;
	for(i=0; i<n; i++){
		sum += fn(a, i+1);
	}
	
	return sum;
}
