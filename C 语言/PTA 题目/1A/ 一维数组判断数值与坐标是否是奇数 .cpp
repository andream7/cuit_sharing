#include <stdio.h>

int main(){
    int num[12], flag[12] = {0}, cnt = 0;
    for(int i=0; i<10; i++){
    	scanf("%d", &num[i]);
        if(i%2 == 1 && num[i]%2 == 1){
            cnt++;
            flag[i] = 1;
        }
    }
    printf("\ncount=%d\n", cnt);
    for(int i=0; i<10; i++){
        if(flag[i])
            printf("a[%d]=%d\n", i, num[i]);
    }
    return 0;
}