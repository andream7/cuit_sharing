#include <stdio.h>

int is( int number );
void count_sum( int a, int b );

int main()
{
    int a, b;

    scanf("%d %d", &a, &b);
    if (is(a)) printf("%d is counted.\n", a);
    if (is(b)) printf("%d is counted.\n", b);
    count_sum(a, b);

    return 0;
}

/* ?????????? */
int is( int number ){
	int sum = 0;
	while(number){
		int t = number%10;
		number /= 10;
		sum += t;
	}
	if(sum == 5)
		return 1;
	else
		return 0;
	
}

void count_sum( int a, int b ){
	int i, sum = 0, cnt = 0;
	for(i=a; i<=b; i++){
		if(is(i))
			sum += i, cnt++;
	}
	printf("count = %d, sum = %d", cnt, sum);
	
}
