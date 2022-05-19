#include <stdio.h>

int main(){
    int n, sumA = 0, sumB = 0, Sum = 0;
    for(int i=0; i<10; i++){
        scanf("%d", &n);
        if(n > 0){
        	sumA = sumA + n;
		}else
			sumB = sumB + n;
        Sum += n;
    }
    printf("zhengshu=%d,fushu=%d,all=%d", sumA, sumB, Sum);
    return 0;
}