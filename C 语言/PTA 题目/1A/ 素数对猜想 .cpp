#include <stdio.h>
#include <math.h>

int main(){
    int n;
    scanf("%d", &n);
    int cnt = 0, last = 3;
    for(int i=5; i<=n; i+=2){
        int flag = 1;
        for(int j=2; j<=sqrt(i); j++){
            if(i%j == 0){
                flag = 0;
                break;
            }
        }
        if(flag){
            if(i-last == 2)
                cnt++;
            last = i;
        }
    }
    if(n < 5)   cnt = 0;
    printf("%d", cnt);
    return 0;
}