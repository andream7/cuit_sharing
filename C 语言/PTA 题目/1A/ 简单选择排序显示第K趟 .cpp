#include <stdio.h>

int main(){
    int n, k;
    scanf("%d%d", &n, &k);
    int num[200];
    for(int i=0; i<n; i++){
        scanf("%d", &num[i]);
    }
    for(int i=0; i<k; i++){
    	int max = 0;
        for(int j=0; j<n-i; j++){
            if(num[max] < num[j]){
                max = j;
            }
        }
        int t = num[max]; num[max] = num[n-i-1]; num[n-i-1] = t;
    }
    for(int i=0; i<n; i++){
        i == 0 ? printf("%d", num[i]) : printf(" %d", num[i]);
    }
    return 0;
}