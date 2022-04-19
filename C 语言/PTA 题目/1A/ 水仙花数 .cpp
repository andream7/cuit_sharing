#include <stdio.h>

int pow(int a, int n){
	return n == 1 ? a : a*pow(a, n-1);
}

int is(int num, int n){
	int m = num, sum = 0;
	while(m){
		int t = pow(m%10, n);
		sum += t;
		m /= 10;		
	}
	return sum == num ? 1 : 0;
}

int main(){
	int n;
	scanf("%d", &n);
	for(int i=pow(10, n-1); i<=pow(10, n); i++){
		if(is(i, n))	printf("%d\n", i);
	}
	
	return 0;
}
