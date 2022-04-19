#include <stdio.h>

int main(){
    int n, num[15], sum = 0, mul;
    scanf("%d", &n);
    for(int i=0; i<n; i++)
        scanf("%d", &num[i]);
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(i == j)  continue;
            mul = num[i]*10 + num[j];
            sum += mul;
        }
    }
    printf("%d", sum);
    return 0;
}