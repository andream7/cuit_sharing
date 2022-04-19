#include <stdio.h>

int main(){
    int n, num[12], t;
    scanf("%d%d", &n, &num[0]);
    for(int i=1; i<n; i++){
        scanf("%d", &num[i]);  
		t = num[i] - num[i-1];  
		i%3 == 1 ? printf("%d", t) : printf(" %d", t);
        if(i%3 == 0){
            printf("\n");
        }  
    }
    return 0;
}