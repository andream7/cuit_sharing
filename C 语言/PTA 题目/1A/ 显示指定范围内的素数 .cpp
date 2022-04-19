#include <stdio.h>
#include <math.h>

int main(){
    int m;
    scanf("%d", &m);
    int prime[100+5], cnt = 0;
    if(m <= 2){
        printf("NO");
        return 0;
    }
    for(int i=2; i<m; i++){
        int flag = 1;
        for(int j=2; j<=sqrt(i); j++){
            if(i%j == 0){
                flag = 0;
                break;
            }
        }
        if(flag)    prime[cnt++] = i;
        if(cnt > 100){
            printf("OVERFLOW");
            return 0;
        }
    }
    int cnt2 = 0;
    for(int i=0; i<cnt; i++){      
//        i == cnt-1 ? printf("%5d", prime[i]) : printf("%5d ", prime[i]);
		printf("%5d", prime[i]);
		cnt2++;
        if(cnt2%15 == 0){
            printf("\n");
        }
    }
//    printf("1");
    return 0;
}