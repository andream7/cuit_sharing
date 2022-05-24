#include <stdio.h>

int main(){
    int x;
    scanf("%d", &x);
    printf("Speed: %d - ", x);
    if(x > 60){
        printf("Speeding");
    }else{
        printf("OK");
    }

    return 0;
}