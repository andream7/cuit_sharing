#include <stdio.h>

int main(){
    int m, n, t;
    scanf("%d%d", &m, &n);
    m > n ? t=m, m=n, n=t : 0;
    int p, q;
    for(int i=n; ; i++){
        if(i%m==0 && i%n==0){
            p = i;
            break;
        }
    }
    q = m*n/p;
    printf("%d %d", q, p);
    return 0;
}