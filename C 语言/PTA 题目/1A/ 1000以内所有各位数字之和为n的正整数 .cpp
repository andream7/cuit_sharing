#include <stdio.h>

int main(){
    int n, cnt = 0;
    scanf("%d", &n);
    for(int i=n; i<=1000; i++){
        int sum = 0, t = i;
        while(t){
            sum += t%10;
            t /= 10;
        }
        if(sum == n){
            cnt++;
            printf("%8d", i);
            if(cnt % 6 == 0)
                printf("\n");
        }
    }
    if(cnt%6 != 0)  printf("\n");
    return 0;
}