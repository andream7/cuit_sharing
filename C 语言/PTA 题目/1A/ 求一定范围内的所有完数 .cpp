#include <stdio.h>

int main(){
    int m, n;
    int num[1000];
    scanf("%d%d", &m, &n);
    for(int i=m; i<=n; i++){
        int a = i, cnt = 0, sum = 0;
        for(int j=1; j<=n/2; j++){
            if(i % j == 0){
                num[cnt++] = j;
                sum += j;
            }
        }
        if(sum == i){
            printf("%d its factors are ", i);
            for(int j=0; j<cnt; j++){
                j == 0 ? printf("%d", num[j]) : printf(",%d", num[j]);
            }
        }
    }

    return 0;
}