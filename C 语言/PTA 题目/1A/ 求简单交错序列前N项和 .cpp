#include <stdio.h>
#include <math.h>

int main(){
    int num, flag = 0;
    scanf("%d", &num);
    for(int i=100; i<=999; i++){
        int sum = 0, t = i;
        while(t){
            sum += pow(t%10, 3);
            t /= 10;
        }
        if(sum == num){
            printf("%-5d", i);
            flag = 1;
        }
    }
    if(!flag)   printf("Not Found!");
    return 0;
}
