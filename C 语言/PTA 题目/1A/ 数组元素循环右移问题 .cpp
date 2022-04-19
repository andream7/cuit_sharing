#include <stdio.h>

int main(){
    int n, num[200], m, gap;
    scanf("%d%d", &n, &m);
    m = m%n;
    for(int i=0; i<n; i++){
        gap = i+m > n-1 ? i+m-n : i+m;
        scanf("%d", num+gap);
    }
    for(int i=0; i<n; i++)
        i == n-1 ? printf("%d", num[i]) : printf("%d ", num[i]);    
    return 0;
}