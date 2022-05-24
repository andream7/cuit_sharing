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
	int n;
	scanf("%d", &n);
	for(int i=2; i<n; i++){
		if(prime(i)){
			int q = n-i;
			if(prime(q)){
				printf("%d = %d + %d", n, i, q); 
				break; 
			} 
		}
	} 
	
	return 0;
}
