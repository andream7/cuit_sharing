#include <stdio.h>

int main(){
    int n, num[15];
    scanf("%d", &n);
    for(int i=0; i<n; i++)
        scanf("%d", &num[i]);
    int x; scanf("%d", &x);
    int start;
    for(start=0; start<n; start++){
        if(x < num[start]){
            break;
        }
    }
    for(int i=n-1; i>=start; i--){
        num[i+1] = num[i];
    }
    num[start] = x;
    for(int i=0; i<n+1; i++)
        printf("%d ", num[i]);
    return 0;
}