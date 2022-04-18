#include <stdio.h>

int main(){
    int n, num[20][20], sum1 = 0, sum2 = 0;
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            num[i][j] = (i+j)*n;
            printf("%4d", num[i][j]);
            if(i != 0 && j != 0 && i != n-1 && j != n-1)
                sum1 += num[i][j];
            if(i == j)
                sum2 += num[i][j];

        }
        printf("\n");
    }
    printf("sum1=%d\nsum2=%d\n", sum1, sum2);
    return 0;
}