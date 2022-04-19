#include <stdio.h>

int main(){
    int n, number, num[10] = {0}, max = 0;
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        scanf("%d", &number);
        do{
            ++num[number%10] > max ? max = num[number%10] : 0;
            number /= 10;
        }while(number);
    }
    printf("%d:", max);
    for(int i=0; i<10; i++)
        num[i] == max ? printf(" %d", i) : 0;
    return 0;
}