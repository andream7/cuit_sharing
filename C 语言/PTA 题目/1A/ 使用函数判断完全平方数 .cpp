#include <stdio.h>
#include <math.h>

int IsSquare( int n );

int main()
{
    int n;

    scanf("%d", &n);
    if ( IsSquare(n) ) printf("YES\n");
    else printf("NO\n");

    return 0;
}

/* 你的代码将被嵌在这里 */
int IsSquare( int n ){
    int q = sqrt(n);
    return q*q == n ? 1 : 0;
}