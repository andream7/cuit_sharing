#include <stdio.h>

int reverse( int number );

int main()
{
    int n;

    scanf("%d", &n);
    printf("%d\n", reverse(n));

    return 0;
}

/* ?????????? */
int reverse( int number ){
	int sum = 0;
	while(number){
		sum = sum * 10 + number % 10;
		number /= 10;
	}
	return sum;
}
