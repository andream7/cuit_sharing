#include <stdio.h>

int main(){
    int m, flag = 0, cnt = 0;
    scanf("%d", &m);
    if(m <= 1){
        printf("ERROR！");
        return 0;
    }
    for(int i=2; i<=m && i<=1000; i++){
        if(i%5==0 && i%7==0){
            printf("%5d", i);
            cnt++;
            flag = 1;
            if(cnt % 5 == 0)
                printf("\n");
        }
    }
    if(!flag)   printf("NOT FOUND！");
    return 0;
}