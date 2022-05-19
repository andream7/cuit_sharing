#include <stdio.h>
#include <math.h>

int main()
{
    int cnt, m, n, p;
    cnt = 0;
    scanf ( "%d %d", &m, &n );
    printf("Count of ( ");
    for ( p = m; p <= n; p++ ) {
        if ( prime ( p ) != 0 ){
            printf ( "%d ", p );
            cnt++;
        }
    }
    printf(") = %d\n", cnt);
    return 0;
}


/* 请在这里填写答案 */
int prime(int p){
    if(p < 2)   return 0;
    for(int i=2; i<=sqrt(p); i++)
        if(p % i == 0)
            return 0;
    return 1;
}