#include <stdio.h>
#include <math.h>

int prime(int m){
	for(int i=2; i<=sqrt(m); i++){
		if(m%i == 0)
			return 0;
	}
	return 1;
}

int main(){
	int n, flag = 0;
	scanf("%d", &n);
	for(int i=2; i<=n; i++){
		int t = pow(2, i)-1;
		if(prime(t))	printf("%d\n", t), flag = 1;
	} 
	if(!flag)	printf("None\n");
	return 0;
}
