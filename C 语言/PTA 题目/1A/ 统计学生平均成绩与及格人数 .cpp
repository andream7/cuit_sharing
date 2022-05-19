#include <stdio.h>

int main(){
    int n, num[1000];
    double ave = 0;
    int cnt = 0;
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        scanf("%d", &num[i]);
        ave += num[i];
        if(num[i] >= 60)
            cnt++;
    }
    ave = n == 0 ? 0 : ave/n;
    printf("average = %.1lf\ncount = %d", ave, cnt);


    return 0;
}