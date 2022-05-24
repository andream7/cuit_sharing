#include <stdio.h>

int main(){
    int n, num[20], t;
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        scanf("%d", &num[i]);
    }
    int min = num[0], minNum = 0;
    for(int i=1; i<n; i++){
        if(num[i] < min){
            min = num[i];
            minNum = i;
        }
    }
    t = num[0], num[0] = min, num[minNum] = t;
    int max = num[0], maxNum = 0;
    for(int i=1; i<n; i++){
        if(num[i] > max){
            max = num[i];
            maxNum = i;
        }
    }
    t = num[n-1], num[n-1] = max, num[maxNum] = t;
    for(int i=0; i<n; i++)
        printf("%d ", num[i]);
    return 0;
}