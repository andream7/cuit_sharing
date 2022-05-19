#include <stdio.h>
#include <math.h>

int prime( int p );
int PrimeSum( int m, int n );

int main()
{
    int m, n, p;

    scanf("%d %d", &m, &n);
    printf("Sum of ( ");
    for( p=m; p<=n; p++ ) {
        if( prime(p) != 0 )
            printf("%d ", p);
    }
    printf(") = %d\n", PrimeSum(m, n));

    return 0;
}

/* 你的代码将被嵌在这里 */
int prime( int p ){
    if(p<2) return 0;
    for(int i=2; i*i<=p; i++)
        if(p%i == 0)
            return 0;
    return 1;
}
int PrimeSum( int m, int n ){
    int sum = 0;
    for(int i=m; i<=n; i++){
        if(prime(i))
            sum += i;
    }
    return sum;
}