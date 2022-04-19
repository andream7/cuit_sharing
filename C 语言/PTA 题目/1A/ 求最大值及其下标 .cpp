#include <stdio.h>

int main(){
    int n;
    scanf("%d", &n);
    int num[20], max = 0;
    for(int i=0; i<n; i++){
        scanf("%d", &num[i]);
        if(num[i] > num[max])
            max = i;
    }
    printf("%d %d", num[max], max);

    return 0;
}