#include <stdio.h>
#include <math.h>

int flag = 0;

void per(int m){
	int sum = 0, num[100], cnt = 0;
	for(int i=1; i<=m/2; i++){
		m % i == 0 ? sum += i, num[cnt++] = i: 0;
	}
	if(sum == m){
		printf("%d =", sum);
		for(int i=0; i<cnt; i++){
			printf(" %d", num[i]);
			i == cnt-1 ? 0 : printf(" +");
		}
		printf("\n");
		flag = 1;
	}	
}

int main(){
	int m, n;
	scanf("%d%d", &m, &n);
	for(int i=m; i<=n; i++){
		per(i);
	}
	if(!flag)	printf("None");
	return 0;
}
