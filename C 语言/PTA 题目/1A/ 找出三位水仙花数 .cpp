#include <stdio.h>

int is(int n){
	int m = n, sum = 0;
	while(m){
		int a = m%10;
		sum += a*a*a;
		m /= 10;
	}
	if(sum == n)
		return 1;
	else
		return 0;
}

int main(){
	int m, n;
	int i, j;
	scanf("%d%d", &m, &n);
	if(m > n || m > 999 || m < 100 || n < 100 || n > 999){
		printf("Invalid Value.");
		return 0;
	}
	for(i=m; i<=n; i++){
		if(is(i))
			printf("%d\n", i);
	}
	
	return 0;
}
