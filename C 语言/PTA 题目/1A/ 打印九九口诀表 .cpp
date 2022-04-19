#include <stdio.h>

int main(){
    int n;
    scanf("%d", &n);
    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){
            printf("%d*%d=%-4d", j, i, i*j);
        }
        printf("\n");
    }
    return 0;
}