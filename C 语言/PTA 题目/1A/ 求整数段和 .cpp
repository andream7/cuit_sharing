#include <stdio.h>

int main(){
	int a, b, sum = 0, cnt = 0;
	int i, j;
	scanf("%d%d", &a, &b);
	for(i=a; i<=b; i++){
		printf("%5d", i);
		cnt++;
		if(cnt%5 == 0)
			printf("\n");
		sum += i;
	}
	if(cnt%5 != 0)
		printf("\n");
	printf("Sum = %d", sum);
	return 0;
}
