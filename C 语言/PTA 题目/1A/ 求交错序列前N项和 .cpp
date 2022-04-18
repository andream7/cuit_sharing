#include <stdio.h>

int main(){
	int n;
	float sum = 0;
	scanf("%d", &n);
	for(float i = 1, j = 1, sign = 1; i <= n; i++, j+=2, sign = -sign){
		sum += sign * i / j;
	}
	printf("%.3f", sum);
	
	return 0;
}
