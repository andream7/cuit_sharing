#include <stdio.h>

int cal(int n, int a){
	int sum = 0;
	for(int i=0; i<n; i++)
		sum = sum*10 + a;
	return sum;
}

int main(){
	int a, n;
	int sum = 0;
	scanf("%d%d", &a, &n);
	for(int i=0; i<n; i++){
		sum += cal(i+1, a);
	}
	printf("s = %d", sum);
	
	return 0;
}
