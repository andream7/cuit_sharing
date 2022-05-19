#include <stdio.h>

int Count_Digit ( const int N, const int D );

int main()
{
    int N, D;

    scanf("%d %d", &N, &D);
    printf("%d\n", Count_Digit(N, D));
    return 0;
}

/* ?????????? */
int Count_Digit ( const int N, const int D ){
	int n = N > 0 ? N : -N;
	int num[10] = {0};
	do{
		num[n%10]++;
		n /= 10;
	}while(n);
	return num[D];
}
